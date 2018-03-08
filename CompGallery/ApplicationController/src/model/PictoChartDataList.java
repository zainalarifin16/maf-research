package model;

public class PictoChartDataList
{

  private static PictoChartData[] dataPRG1;
  private static PictoChartData[] dataPRG2;
  private static PictoChartData[] dataSFO;
  private static PictoChartData[] dataDEN;
  private static PictoChartData[] dataNYC;

  public PictoChartDataList()
  {
    super();
    if (dataPRG1 == null)
      dataPRG1 = new PictoChartData[]
      {
        new PictoChartData(10, "Diana Lorentz", "PRG1", "Finance", "M2"),
        new PictoChartData(13, "Simon Austin", "PRG1", "Support", "SD2"), 
        new PictoChartData(33, "Tim Surapi", "PRG1", "IT", "M3"),
        new PictoChartData(38, "Inderjeet Narayanan", "PRG1", "Support", "SD3"),
        new PictoChartData(49, "Lukas Sobieski", "PRG1", "Support", "SD3")
      };
    if (dataPRG2 == null)
      dataPRG2 = new PictoChartData[]
      {
        new PictoChartData(1, "Alex Hunold", "PRG2", "Cloud", "M1"), 
        new PictoChartData(6, "Kelly Sullivan", "PRG2", "Finance", "SD2"),
        new PictoChartData(8, "Laura Bissot", "PRG2", "Apps", "SD2"),
        new PictoChartData(17, "Curtis Davies", "PRG2", "Finance", "SD2"),
        new PictoChartData(21, "John Ferrante", "PRG2", "Support", "SD2"),
        new PictoChartData(27, "Vinay Pataki", "PRG2", "Support", "SD3"), 
        new PictoChartData(28, "Sherry Wu", "PRG2", "Cloud", "SD2"),
        new PictoChartData(29, "Prashant Sigh", "PRG2", "Cloud", "SD1"),
        new PictoChartData(37, "Uma Mordani", "PRG2", "Finance", "M2"),
        new PictoChartData(39, "Tom Sandler", "PRG2", "Cloud", "SD2"), 
        new PictoChartData(44, "Mukul Hanamasetti", "PRG2", "Cloud", "SD2"),
        new PictoChartData(46, "Bharath Labzovsky", "PRG2", "Finance", "SD3"),
        new PictoChartData(50, "Dana Rao", "PRG2", "Support", "SD4")
      };
    if (dataSFO == null)
      dataSFO = new PictoChartData[]
      {
        new PictoChartData(2, "Steven King", "SFO", "Apps", "M2"),
        new PictoChartData(11, "Nina Evans", "SFO", "Apps", "SD2"), 
        new PictoChartData(15, "James Marlow", "SFO", "Cloud", "SD2"), 
        new PictoChartData(25, "Sadia Stachnick", "SFO", "Apps", "M3"),
        new PictoChartData(26, "Samantha Joy", "SFO", "Finance", "SD3"),
        new PictoChartData(30, "Doris De Arrif", "SFO", "Finance", "SD4"), 
        new PictoChartData(31, "Tim Marco", "SFO", "Apps", "SD4"),
        new PictoChartData(32, "Trung Chang", "SFO", "Cloud", "SD4"), 
        new PictoChartData(34, "Mohamed Ali", "SFO", "Finance", "SD2"), 
        new PictoChartData(43, "Sanket Ati", "SFO", "Apps", "M2"),
        new PictoChartData(45, "Geetha Goswami", "SFO", "IT", "SD2"),
        new PictoChartData(48, "Janet Wo", "SFO", "Cloud", "M1")
      };
    if (dataDEN == null)
      dataDEN = new PictoChartData[]
      {
        new PictoChartData(4, "Alaina Walsh", "DEN", "IT", "SD2"),
        new PictoChartData(9, "Lucy Whalen", "DEN", "IT", "SD1"), 
        new PictoChartData(12, "David Yong", "DEN", "Finance", "SD3"),
        new PictoChartData(16, "Dan Raphaely", "DEN", "IT", "SD2"),
        new PictoChartData(18, "Diana Tyrell", "DEN", "Support", "SD4"), 
        new PictoChartData(19, "Bill Akel", "DEN", "Support", "M2"),
        new PictoChartData(20, "Srini Pataky", "DEN", "Cloud", "M2"),
        new PictoChartData(22, "Shay Oberoi", "DEN", "Cloud", "SD2"), 
        new PictoChartData(35, "Apal Cho", "DEN", "IT", "SD2"),
        new PictoChartData(36, "Larry Lehmann", "DEN", "Support", "SD2"),
        new PictoChartData(47, "Prabhavalkar Muralidhar", "DEN", "Finance", "SD2")
      };
    if (dataNYC == null)
      dataNYC = new PictoChartData[]
      {
        new PictoChartData(3, "Nancy Green", "NYC", "IT", "SD2"), 
        new PictoChartData(5, "Julia Chen", "NYC", "Apps", "SD1"), 
        new PictoChartData(7, "Susan Higgins", "NYC", "Cloud", "M2"), 
        new PictoChartData(23, "Shila Faber", "NYC", "Support", "M2"),
        new PictoChartData(24, "Javed Johl", "NYC", "Finance", "SD2"),
        new PictoChartData(40, "Nazrul Islam", "NYC", "Apps", "SD4"),
        new PictoChartData(41, "Janet Lehmann", "NYC", "Finance", "SD2"), 
        new PictoChartData(42, "Rajiv Kumar", "NYC", "Apps", "M2")
      };
  }


  public PictoChartData[] getPictoChartPRG1DataList()
  {
    return dataPRG1;
  }

  public PictoChartData[] getPictoChartPRG2DataList()
  {
    return dataPRG2;
  }

  public PictoChartData[] getPictoChartSFODataList()
  {
    return dataSFO;
  }

  public PictoChartData[] getPictoChartDENDataList()
  {
    return dataDEN;
  }

  public PictoChartData[] getPictoChartNYCDataList()
  {
    return dataNYC;
  }
}
