package model;

import java.text.DecimalFormat;

public class BarChartRetirementData {
    private final int age;
    private final double totalContribution;
    private final double totalSavings;

    public BarChartRetirementData(int age, double totalContribution, double totalSavings) {
      this.age = age;
      this.totalContribution = totalContribution;
      this.totalSavings = totalSavings;
    }

    public int getAge() {
      return age;
    }

    public double getTotalContribution() {
      return totalContribution;
    }

    public double getTotalSavings() {
      return totalSavings;
    }
    
    public String getShortDesc() {
      DecimalFormat decFormat = new DecimalFormat();
      decFormat.setMaximumFractionDigits(0);
      return "Age: <b>" + age + "</b><br/>" + "Savings: <b>$" + decFormat.format(totalSavings) + "</b>";
    }
}
