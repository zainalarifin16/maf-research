package model;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.bindings.dbf.AmxAccessorIteratorBinding;
import oracle.adfmf.bindings.iterator.BasicIterator;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class BarChartRetirementDataList {
    
  protected int currentAge = 25;
  protected int retirementAge = 67;
  protected int lifeExpectancy = 90;
  protected double currentSavings = 25000;
  protected double annualContribution = 10000;
  protected double rateOfReturn = 30;
  protected double retiredRateOfReturn = 30;
  protected double retirementSpending = 80000;
  protected double socialSecurityIncome = 30000;

  protected final static double INFLATION_RATE = 1.03;
  
  
  public void setCurrentAge(int currentAge) {
    this.currentAge = currentAge;
  }

  public int getCurrentAge() {
    return currentAge;
  }

  public void setRetirementAge(int retirementAge) {
    this.retirementAge = Math.max(retirementAge, currentAge);
  }

  public int getRetirementAge() {
    return retirementAge;
  }

  public void setLifeExpectancy(int lifeExpectancy) {
    this.lifeExpectancy = Math.max(retirementAge, lifeExpectancy);
  }

  public int getLifeExpectancy() {
    return lifeExpectancy;
  }

  public void setCurrentSavings(double currentSavings) {
    this.currentSavings = currentSavings;
  }

  public double getCurrentSavings() {
    return currentSavings;
  }

  public void setAnnualContribution(double annualContribution) {
    this.annualContribution = annualContribution;
  }

  public double getAnnualContribution() {
    return annualContribution;
  }

  public void setRateOfReturn(double rateOfReturn) {
    this.rateOfReturn = rateOfReturn;
  }

  public double getRateOfReturn() {
    return rateOfReturn;
  }

  public void setRetiredRateOfReturn(double retiredRateOfReturn) {
    this.retiredRateOfReturn = retiredRateOfReturn;
  }

  public double getRetiredRateOfReturn() {
    return retiredRateOfReturn;
  }

  public void setRetirementSpending(double retirementSpending) {
    this.retirementSpending = retirementSpending;
  }

  public double getRetirementSpending() {
    return retirementSpending;
  }

  public void setSocialSecurityIncome(double socialSecurityIncome) {
    this.socialSecurityIncome = socialSecurityIncome;
  }

  public double getSocialSecurityIncome() {
    return socialSecurityIncome;
  }
  
    protected static List<BarChartRetirementData> model;
    
    public BarChartRetirementDataList() {
        if(model == null) {
           model = new ArrayList<BarChartRetirementData>();
           rebuildModel();
           updateMessages();
        }
    }
    
    /**
     * Returns the data model containing the calculated data.
     * @return
     */
    public List<BarChartRetirementData> getChartData() {
      return model;
    }
    
    private void rebuildModel() {
        model.clear();
        
        // Calculate the savings for each year from current to retirement
        double totalContribution = 0;
        double totalSavings = this.currentSavings;
        for(int i = this.currentAge; i <= this.lifeExpectancy; i++) {
          // Create the data item for the year
          model.add(new BarChartRetirementData(i, totalContribution, totalSavings));
          
          // Update the savings totals
          if(i < this.retirementAge) {
            // Before Retirement: Increase the savings by annual contribution and interest
            totalContribution += this.annualContribution;
            totalSavings = (totalSavings * (1 + this.rateOfReturn / 1000) +
                     this.annualContribution) / BarChartRetirementDataList.INFLATION_RATE;
          }
          else {
            // After Retirement: Decrease the savings by annual spend - social security
            double income =
                    this.socialSecurityIncome - this.retirementSpending;
            totalSavings = ((totalSavings + income) * (1 + this.retiredRateOfReturn / 1000)) /
                    BarChartRetirementDataList.INFLATION_RATE;
          }
        } 
    }
    
    /**
     * Returns the minimum amount needed to retire with the information specified in this bean.
     */
    public double getMinimumNeededToRetire() {
      int yearsAfterRetirement = this.lifeExpectancy - this.retirementAge;
      double spend = this.retirementSpending - this.socialSecurityIncome;
      double savingsNeeded = 0;
      for(int i=yearsAfterRetirement; i>0; i--) {
        savingsNeeded += spend * Math.pow(BarChartRetirementDataList.INFLATION_RATE, i)/Math.pow(1 + this.retiredRateOfReturn / 1000, i);
      }
      return savingsNeeded;
    }

    /**
     * Returns the maximum value to display on the y-Axis.
     */
    public double getMaxSavings() {
      List<BarChartRetirementData> model = getChartData();
      
      // Calculate the maximum value of the retirement savings
      double maxSavings = Double.NEGATIVE_INFINITY;
      for (BarChartRetirementData item : model) {
          maxSavings = Math.max(maxSavings, item.getTotalSavings()); 
      }
      
      return Math.max(maxSavings, getMinimumNeededToRetire());
    }
    
    /**
     * Returns the text string indicating whether the savings goals were reached.
     * @return
     */
    public String getMessage() {
      double amountAtEnd = getAmountAtLifeExpectancy();
      if(amountAtEnd > 1000000)
        return "Congratulations! You will have more than enough to retire. Please consider making a donation to your favorite data visualization developers.";
      else if(amountAtEnd >= 0) 
        return "Congratulations! You will have saved enough to enjoy your retirement.";
      else {
        double difference = getMinimumNeededToRetire() - getAmountAtRetirement();
        double additionalPerYear = getAdditionalSavingsNeeded();
        DecimalFormat decFormat = new DecimalFormat();
        decFormat.setMaximumFractionDigits(0);
        return "You will need to save an additional $" + decFormat.format(difference) + 
               " to retire.  Increase your annual contribution by $" + decFormat.format(Math.ceil(additionalPerYear)) + 
               " to meet your goals."; 
      }
    }
    
    /**
     * Returns true if the savings is not depleted during retirement.
     * @return
     */
    private boolean isSavingEnough() {
      return getAmountAtLifeExpectancy() >= 0;
    }
    
    /**
     * Helper to return the value of the account at retirement.
     */
    private double getAmountAtRetirement() {
      List<BarChartRetirementData> model = getChartData();
      return model.get(this.retirementAge - this.currentAge).getTotalSavings();
    }
    
    /**
     * Helper to return the value of the account at life expectancy.
     */
    private double getAmountAtLifeExpectancy() {
      List<BarChartRetirementData> model = getChartData();
      return model.get(model.size() - 1).getTotalSavings();
    }
    
    /**
     * Helper to return the additional contribution per year needed to meet retirement goals.
     */
    private double getAdditionalSavingsNeeded() {
      double difference = getMinimumNeededToRetire() - getAmountAtRetirement();
      if(difference <= 0)
        return 0; // Saving enough
      else {
        // Calculate the number of contribution multiples taking insurance and inflation into account
        double multiple = 0;
        double yearsToContribute = this.retirementAge - this.currentAge;
        for(int i = 0; i < yearsToContribute; i++) {
          multiple += (Math.pow(1 + this.rateOfReturn / 1000, i)/Math.pow(BarChartRetirementDataList.INFLATION_RATE, i+1));
        }
        
        // Additional per year is the difference/multiple
        return multiple > 0 ? difference/multiple : difference;
      }
    }

    public void rateOfReturnUpdated(ValueChangeEvent valueChangeEvent) {
        String newVal = valueChangeEvent.getNewValue().toString();
        double labelValue = Double.parseDouble(newVal) / 10;
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.rateOfReturnLabel}", String.class);
        ve.setValue(AdfmfJavaUtilities.getELContext(), new Double(labelValue));
        
        calculationParameterUpdated(valueChangeEvent);
    }

    public void retiredRateOfReturnUpdated(ValueChangeEvent valueChangeEvent) {
        String newVal = valueChangeEvent.getNewValue().toString();
        double labelValue = Double.parseDouble(newVal) / 10;
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.retiredRateOfReturnLabel}", String.class);
        ve.setValue(AdfmfJavaUtilities.getELContext(), new Double(labelValue));
        
        calculationParameterUpdated(valueChangeEvent);
    }
    
    private void updateChart() {
        rebuildModel();
        
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{bindings.chartDataIterator}", Object.class);
        AmxAccessorIteratorBinding aib = (AmxAccessorIteratorBinding)ve.getValue(AdfmfJavaUtilities.getELContext());
        BasicIterator bi = (BasicIterator)aib.getIterator();

        bi.refresh(true);
        
        updateMessages();
    }
    
    private void updateMessages() {
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.retirementResultMessage}", String.class);
        ve.setValue(AdfmfJavaUtilities.getELContext(), getMessage()); 
        
        ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.savingEnough}", Boolean.class);
        ve.setValue(AdfmfJavaUtilities.getELContext(), Boolean.valueOf(isSavingEnough())); 
    }

    public void calculationParameterUpdated(ValueChangeEvent valueChangeEvent) {
        updateChart();
    }
}
