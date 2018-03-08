package model;

import java.util.ArrayList;
import java.util.List;

public class CommandButtonStylesDataList
{
  private static List<CommandButtonStylesData> commandButtonStylesDataList = null;

  public CommandButtonStylesDataList()
  {
    if (commandButtonStylesDataList == null)
    {
      commandButtonStylesDataList = new ArrayList<CommandButtonStylesData>();
      commandButtonStylesDataList.add(
        new CommandButtonStylesData(""));
      commandButtonStylesDataList.add(
        new CommandButtonStylesData("adfmf-commandButton-small"));
      commandButtonStylesDataList.add(
        new CommandButtonStylesData("adfmf-commandButton-medium"));
      commandButtonStylesDataList.add(
        new CommandButtonStylesData("adfmf-commandButton-large"));
      commandButtonStylesDataList.add(
        new CommandButtonStylesData("adfmf-commandButton-rounded"));
      commandButtonStylesDataList.add(
        new CommandButtonStylesData(
          "adfmf-commandButton-large adfmf-commandButton-rounded"));
      commandButtonStylesDataList.add(
        new CommandButtonStylesData("adfmf-commandButton-actionSheet"));
      commandButtonStylesDataList.add(
        new CommandButtonStylesData("adfmf-commandButton-back"));
      commandButtonStylesDataList.add(
        new CommandButtonStylesData("adfmf-commandButton-forward"));
    }
  }

  public List<CommandButtonStylesData> getCommandButtonStylesData()
  {
    return commandButtonStylesDataList;
  }
}
