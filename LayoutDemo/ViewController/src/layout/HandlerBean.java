package layout;

import java.util.ArrayList;

import javax.el.MethodExpression;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.SelectionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class HandlerBean {
    private String selectedTabsBottomContent = "Tab1";
    private String selectedTabsTopContent = "Tab1";
    private String selectedTabsTopTabsBottomContent1 = "Tab5";

    public void setSelectedTabsTopTabsBottomContent1(String selectedTabsTopTabsBottomContent1) {
        String oldSelectedTabsTopTabsBottomContent1 = this.selectedTabsTopTabsBottomContent1;
        this.selectedTabsTopTabsBottomContent1 = selectedTabsTopTabsBottomContent1;
        propertyChangeSupport.firePropertyChange("selectedTabsTopTabsBottomContent1",
                                                 oldSelectedTabsTopTabsBottomContent1,
                                                 selectedTabsTopTabsBottomContent1);
    }

    public String getSelectedTabsTopTabsBottomContent1() {
        return selectedTabsTopTabsBottomContent1;
    }
    private String selectedTabsTopTabsBottomContent2 = "Tab9";

    public void setSelectedTabsTopTabsBottomContent2(String selectedTabsTopTabsBottomContent2) {
        String oldSelectedTabsTopTabsBottomContent2 = this.selectedTabsTopTabsBottomContent2;
        this.selectedTabsTopTabsBottomContent2 = selectedTabsTopTabsBottomContent2;
        propertyChangeSupport.firePropertyChange("selectedTabsTopTabsBottomContent2",
                                                 oldSelectedTabsTopTabsBottomContent2,
                                                 selectedTabsTopTabsBottomContent2);
    }

    public String getSelectedTabsTopTabsBottomContent2() {
        return selectedTabsTopTabsBottomContent2;
    }

    public void setSelectedTabsTopTabsBottomContent3(String selectedTabsTopTabsBottomContent3) {
        String oldSelectedTabsTopTabsBottomContent3 = this.selectedTabsTopTabsBottomContent3;
        this.selectedTabsTopTabsBottomContent3 = selectedTabsTopTabsBottomContent3;
        propertyChangeSupport.firePropertyChange("selectedTabsTopTabsBottomContent3",
                                                 oldSelectedTabsTopTabsBottomContent3,
                                                 selectedTabsTopTabsBottomContent3);
    }

    public String getSelectedTabsTopTabsBottomContent3() {
        return selectedTabsTopTabsBottomContent3;
    }

    public void setSelectedTabsTopTabsBottomContent4(String selectedTabsTopTabsBottomContent4) {
        String oldSelectedTabsTopTabsBottomContent4 = this.selectedTabsTopTabsBottomContent4;
        this.selectedTabsTopTabsBottomContent4 = selectedTabsTopTabsBottomContent4;
        propertyChangeSupport.firePropertyChange("selectedTabsTopTabsBottomContent4",
                                                 oldSelectedTabsTopTabsBottomContent4,
                                                 selectedTabsTopTabsBottomContent4);
    }

    public String getSelectedTabsTopTabsBottomContent4() {
        return selectedTabsTopTabsBottomContent4;
    }


    private String selectedTabsTopTabsBottomContent3 = "Tab13";
    private String selectedTabsTopTabsBottomContent4 = "Tab17";



    private boolean renderContentLayout;

    public void setRenderContentLayout(boolean renderContentLayout) {
        boolean oldRenderContentLayout = this.renderContentLayout;
        this.renderContentLayout = renderContentLayout;
        propertyChangeSupport.firePropertyChange("renderContentLayout", oldRenderContentLayout, renderContentLayout);
    }

    public boolean isRenderContentLayout(String contentLayout) {
        System.out.println("CONTENT LAYOUT INSIDE isRenderContentLayout"+contentLayout);
        
        ValueExpression ve_pageLayout =
            AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.pageLayout}", String.class);
        String pageLayout = (String) ve_pageLayout.getValue(AdfmfJavaUtilities.getELContext());

        ValueExpression ve_tempContentLayout =
            AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.renderContentLayout}", String.class);
        String tempContentLayout = (String) ve_tempContentLayout.getValue(AdfmfJavaUtilities.getELContext());

        int indexOfPageLayout = pageLayoutList.indexOf(pageLayout);
        int indexOfTempContentLayout = contentLayoutList.indexOf(contentLayout);

        int mappedValue = layoutMatrix[indexOfPageLayout][indexOfTempContentLayout];
        boolean result = false;
        if (mappedValue == 1) {
            result = true;
        } else {
            result = false;

        }


        return renderContentLayout;
    }
    ArrayList<String> contentLayoutList = new ArrayList<String>() {
        {
            add("none");
            add("cards");
            add("listview");
            add("swimlane");
            add("filmstrip");
            add("tabstop");
            add("tabsbottom");
            add("thumbnail");
            add("masonry");
            add("flex");

        }
    };
    ArrayList<String> pageLayoutList = new ArrayList<String>() {
        {
            add("basic");
            add("splitview");
            add("navbartop");
            add("tabstop");
            add("toptabsinheader");
            add("navbarbottom");
            add("tabsbottom");
            add("filmstrip");            
        }
    };


    private int layoutMatrix[][] = {
        { 1, 0, 1, 1, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 0 },
        { 1, 0, 1, 1, 1, 0, 0, 0 }, 
        { 1, 0, 0, 0, 0, 1, 0, 1 }, 
        { 1, 0, 1, 1, 0, 0, 0, 1 }, 
        { 1, 0, 1, 1, 1, 0, 0, 0 },
        { 1, 0, 1, 1, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1 },
    };

    public void setSelectedTabsTopContent(String selectedTabsTopContent) {
        String oldSelectedTabsTopContent = this.selectedTabsTopContent;
        this.selectedTabsTopContent = selectedTabsTopContent;
        propertyChangeSupport.firePropertyChange("selectedTabsTopContent", oldSelectedTabsTopContent,
                                                 selectedTabsTopContent);
    }

    public String getSelectedTabsTopContent() {
        return selectedTabsTopContent;
    }
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setSelectedTabsBottomContent(String selectedTabsBottomContent) {
        String oldSelectedTabsBottomContent = this.selectedTabsBottomContent;
        this.selectedTabsBottomContent = selectedTabsBottomContent;
        propertyChangeSupport.firePropertyChange("selectedTabsBottomContent", oldSelectedTabsBottomContent,
                                                 selectedTabsBottomContent);
    }

    public String getSelectedTabsBottomContent() {
        return selectedTabsBottomContent;
    }

    public HandlerBean() {
    }

    public void handleContentLayout(SelectionEvent selectionEvent) {
        // Add event code here...
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(AdfmfJavaUtilities.getFeatureId(),
                                                                  "adf.mf.api.amx.doNavigation", new Object[] {
                                                                  "showLayout" });
    }


    public void handleTabsBottomContentSelection(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String newValue = (String) valueChangeEvent.getNewValue();
        this.setSelectedTabsBottomContent(newValue);

    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void handleTabsTopContentSelection(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String newValue = (String) valueChangeEvent.getNewValue();
        this.setSelectedTabsTopContent(newValue);
        
    }


    public void handleTabsTopTabsBottomContentSelection1(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        System.out.println("INSIDE handleTabsTopTabsBottomContentSelection1 newvalue");
        String newValue = (String) valueChangeEvent.getNewValue();
        this.setSelectedTabsTopTabsBottomContent1(newValue);
        System.out.println("INSIDE handleTabsTopTabsBottomContentSelection1 newvalue"+newValue);
    }

    public void handleTabsTopTabsBottomContentSelection2(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String newValue = (String) valueChangeEvent.getNewValue();
        this.setSelectedTabsTopTabsBottomContent2(newValue);
    }

    public void handleTabsTopTabsBottomContentSelection3(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String newValue = (String) valueChangeEvent.getNewValue();
        this.setSelectedTabsTopTabsBottomContent3(newValue);
    }

    public void handleTabsTopTabsBottomContentSelection4(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String newValue = (String) valueChangeEvent.getNewValue();
        this.setSelectedTabsTopTabsBottomContent4(newValue);
    }


    public void handleTabsTopTabsBottomSelection1(ActionEvent actionEvent) {
        // Add event code here...
        ValueExpression ve =
            AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.tabsTopThumbnailSelection1}", String.class);
        String tabsTopThumbnailSelection = (String) ve.getValue(AdfmfJavaUtilities.getELContext());
        this.setSelectedTabsTopTabsBottomContent1(tabsTopThumbnailSelection);
    }
    
    public void handleTabsTopTabsBottomSelection2(ActionEvent actionEvent) {
        // Add event code here...
        ValueExpression ve =
            AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.tabsTopThumbnailSelection2}", String.class);
        String tabsTopThumbnailSelection = (String) ve.getValue(AdfmfJavaUtilities.getELContext());
        this.setSelectedTabsTopTabsBottomContent2(tabsTopThumbnailSelection);
    }

    public void handleTabsTopTabsBottomSelection3(ActionEvent actionEvent) {
        // Add event code here...
        ValueExpression ve =
            AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.tabsTopThumbnailSelection3}", String.class);
        String tabsTopThumbnailSelection = (String) ve.getValue(AdfmfJavaUtilities.getELContext());
        this.setSelectedTabsTopTabsBottomContent3(tabsTopThumbnailSelection);
    }

    public void handleTabsTopTabsBottomSelection4(ActionEvent actionEvent) {
        // Add event code here...
        ValueExpression ve =
            AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.tabsTopThumbnailSelection4}", String.class);
        String tabsTopThumbnailSelection = (String) ve.getValue(AdfmfJavaUtilities.getELContext());
        this.setSelectedTabsTopTabsBottomContent4(tabsTopThumbnailSelection);
    }
    
    
}
