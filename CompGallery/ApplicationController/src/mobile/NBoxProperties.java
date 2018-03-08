package mobile;

public class NBoxProperties {
    
    private String cellTitle = "";
    private String columnsTitle = "Performance";
    private String emptyText = "No Data";
    private String groupBehavior = "withinCell";
    private String highlightedRowKeys = "2 10 11 13 22 25 30 40 44";
    private String inlineStyle = "";
    private String maximizedColumn = "";
    private String maximizedRow = "";
    private String nodeSelection = "multiple";
    private String rowsTitle = "Potential";
    private String selectedRowKeys = "";
    private String shortDesc = "";
    private boolean showCount = false;
    private boolean showDepartment = true;
    private boolean showRole = true;
    private boolean showExperience = true;
    private boolean groupDepartment = false;
    private boolean groupRole = false;
    private boolean groupExperience = false;
    private boolean showIcon = true;
    private boolean showDetails = true;
    private boolean showHighlightedNodes = false;

    public NBoxProperties() {
        super();
    }

    public void setColumnsTitle(String columnsTitle) {
        this.columnsTitle = columnsTitle;
    }

    public String getColumnsTitle() {
        return columnsTitle;
    }

    public void setCellTitle(String cellTitle)
    {
      this.cellTitle = cellTitle;
    }
  
    public String getCellTitle()
    {
      return cellTitle;
    }
  
    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
    }

    public String getEmptyText() {
        return emptyText;
    }

    public void setGroupBehavior(String groupBehavior) {
        this.groupBehavior = groupBehavior;
    }

    public String getGroupBehavior() {
        return groupBehavior;
    }

    public void setHighlightedRowKeys(String highlightedRowKeys) {
        this.highlightedRowKeys = highlightedRowKeys;
    }

    public String getHighlightedRowKeys() {
        return highlightedRowKeys;
    }

    public void setInlineStyle(String inlineStyle) {
        this.inlineStyle = inlineStyle;
    }

    public String getInlineStyle() {
        return inlineStyle;
    }

    public void setMaximizedColumn(String maximizedColumn) {
        this.maximizedColumn = maximizedColumn;
    }

    public String getMaximizedColumn() {
        return maximizedColumn;
    }

    public void setMaximizedRow(String maximizedRow) {
        this.maximizedRow = maximizedRow;
    }

    public String getMaximizedRow() {
        return maximizedRow;
    }

    public void setNodeSelection(String nodeSelection) {
        this.nodeSelection = nodeSelection;
    }

    public String getNodeSelection() {
        return nodeSelection;
    }

    public void setRowsTitle(String rowsTitle) {
        this.rowsTitle = rowsTitle;
    }

    public String getRowsTitle() {
        return rowsTitle;
    }

    public void setSelectedRowKeys(String selectedRowKeys) {
        this.selectedRowKeys = selectedRowKeys;
    }

    public String getSelectedRowKeys() {
        return selectedRowKeys;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShowCount(boolean showCount)
    {
      this.showCount = showCount;
    }
  
    public boolean isShowCount()
    {
      return showCount;
    }

    public void setShowIcon(boolean showIcon) {
        this.showIcon = showIcon;
    }

    public boolean isShowIcon() {
        return showIcon;
    }

    public void setShowHighlightedNodes(boolean showHighlightedNodes) {
        this.showHighlightedNodes = showHighlightedNodes;
    }

    public boolean isShowHighlightedNodes() {
        return showHighlightedNodes;
    }

    public void setShowDepartment(boolean showDepartment)
    {
      this.showDepartment = showDepartment;
    }
  
    public boolean isShowDepartment()
    {
      return showDepartment;
    }
  
    public void setShowRole(boolean showRole)
    {
      this.showRole = showRole;
    }
  
    public boolean isShowRole()
    {
      return showRole;
    }
  
    public void setShowExperience(boolean showExperience)
    {
      this.showExperience = showExperience;
    }
  
    public boolean isShowExperience()
    {
      return showExperience;
    }

    public void setGroupDepartment(boolean groupDepartment)
    {
      this.groupDepartment = groupDepartment;
    }
  
    public boolean isGroupDepartment()
    {
      return groupDepartment;
    }
  
    public void setGroupRole(boolean groupRole)
    {
      this.groupRole = groupRole;
    }
  
    public boolean isGroupRole()
    {
      return groupRole;
    }
  
    public void setGroupExperience(boolean groupExperience)
    {
      this.groupExperience = groupExperience;
    }
  
    public boolean isGroupExperience()
    {
      return groupExperience;
    }

  public void setShowDetails(boolean showDetails)
  {
    this.showDetails = showDetails;
  }

  public boolean isShowDetails()
  {
    return showDetails;
  }
}
