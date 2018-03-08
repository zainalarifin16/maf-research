package layout;

import java.util.ArrayList;

import javax.el.ValueExpression;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class LayoutWizardBean {
    
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private boolean renderNoneContentLayout;

    public void setRenderNoneContentLayout(boolean renderNoneContentLayout) {
        this.renderNoneContentLayout = renderNoneContentLayout;
    }
    
    private boolean renderContentLayout(String contentLayout){
        ValueExpression ve_pageLayout =
            AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.pageLayout}", String.class);
        String pageLayout = (String) ve_pageLayout.getValue(AdfmfJavaUtilities.getELContext());

        int indexOfPageLayout = pageLayoutList.indexOf(pageLayout);
        int indexOfTempContentLayout = contentLayoutList.indexOf(contentLayout);
        int mappedValue = layoutMatrix[indexOfTempContentLayout][indexOfPageLayout];
        boolean result = false;
        if (mappedValue == 1) {
            result = true;
        } else {
            result = false;

        }
      return result;
    
    }
    

    public boolean isRenderNoneContentLayout() {
        renderNoneContentLayout=renderContentLayout("none");
        return renderNoneContentLayout;
    }

    public void setRenderCardsContentLayout(boolean renderCardsContentLayout) {
        this.renderCardsContentLayout = renderCardsContentLayout;
    }

    public boolean isRenderCardsContentLayout() {
        renderCardsContentLayout=renderContentLayout("cards");
        return renderCardsContentLayout;
    }

    public void setRenderListviewContentLayout(boolean renderListviewContentLayout) {
        this.renderListviewContentLayout = renderListviewContentLayout;
    }

    public boolean isRenderListviewContentLayout() {
        renderListviewContentLayout=renderContentLayout("listview");
        return renderListviewContentLayout;
    }

    public void setRenderSwimlaneContentLayout(boolean renderSwimlaneContentLayout) {
        this.renderSwimlaneContentLayout = renderSwimlaneContentLayout;
    }

    public boolean isRenderSwimlaneContentLayout() {
        renderSwimlaneContentLayout=renderContentLayout("swimlane");
        return renderSwimlaneContentLayout;
    }

    public void setRenderFilmstripContentLayout(boolean renderFilmstripContentLayout) {
        this.renderFilmstripContentLayout = renderFilmstripContentLayout;
    }

    public boolean isRenderFilmstripContentLayout() {
        renderFilmstripContentLayout=renderContentLayout("filmstrip");
        return renderFilmstripContentLayout;
    }

    public void setRenderTabstopContentLayout(boolean renderTabstopContentLayout) {
        this.renderTabstopContentLayout = renderTabstopContentLayout;
    }

    public boolean isRenderTabstopContentLayout() {
        renderTabstopContentLayout=renderContentLayout("tabstop");
        return renderTabstopContentLayout;
    }

    public void setRenderTabsbottomContentLayout(boolean renderTabsbottomContentLayout) {
        this.renderTabsbottomContentLayout = renderTabsbottomContentLayout;
    }

    public boolean isRenderTabsbottomContentLayout() {
        renderTabsbottomContentLayout=renderContentLayout("tabsbottom");
        return renderTabsbottomContentLayout;
    }

    public void setRenderThumbnailContentLayout(boolean renderThumbnailContentLayout) {
        this.renderThumbnailContentLayout = renderThumbnailContentLayout;
    }

    public boolean isRenderThumbnailContentLayout() {
        renderThumbnailContentLayout=renderContentLayout("thumbnail");
        return renderThumbnailContentLayout;
    }

    public void setRenderMasonryContentLayout(boolean renderMasonryContentLayout) {
        this.renderMasonryContentLayout = renderMasonryContentLayout;
    }

    public boolean isRenderMasonryContentLayout() {
        renderMasonryContentLayout=renderContentLayout("masonry");
        return renderMasonryContentLayout;
    }

    public void setRenderFlexContentLayout(boolean renderFlexContentLayout) {
        this.renderFlexContentLayout = renderFlexContentLayout;
    }

    public boolean isRenderFlexContentLayout() {
        renderFlexContentLayout=renderContentLayout("flex");
        return renderFlexContentLayout;
    }
    private boolean renderCardsContentLayout;
    private boolean renderListviewContentLayout;
    private boolean renderSwimlaneContentLayout;
    private boolean renderFilmstripContentLayout;
    private boolean renderTabstopContentLayout;
    private boolean renderTabsbottomContentLayout;
    private boolean renderThumbnailContentLayout;
    private boolean renderMasonryContentLayout;
    private boolean renderFlexContentLayout;
    ArrayList<String> pageLayoutList = new ArrayList<String>() {
        {
            add("basic");
            add("filmstrip"); 
            add("navbarbottom");
            add("splitview");
            add("tabsbottom");
            add("tabstop");
        }
    };

    ArrayList<String> contentLayoutList = new ArrayList<String>() {
        {
            add("none");
            add("cards");
            add("filmstrip");
            add("flex");
            add("listview");
            add("masonry");
            add("swimlane");
            add("tabsbottom");
            add("tabstop");
        }
    };

    private int layoutMatrix[][] = {
        { 1, 1, 1, 1, 1, 1}, 
        { 1, 1, 1, 1, 1, 1}, 
        { 0, 0, 1, 1, 1, 1}, 
        { 1, 1, 1, 1, 1, 1},
        { 1, 1, 1, 1, 1, 1}, 
        { 1, 1, 1, 1, 1, 1}, 
        { 1, 0, 1, 1, 1, 1}, 
        { 0, 0, 0, 1, 0, 1},
        { 0, 0, 0, 1, 0, 0},    
    };
    
    

    public LayoutWizardBean() {
        super();
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    
    
  
    
}
