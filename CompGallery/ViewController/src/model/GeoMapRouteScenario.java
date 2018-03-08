package model;

import java.util.List;

public class GeoMapRouteScenario
{
  final String name;
  final String type;
  final String map;
  final GeographicMapPointData[] data;

  public GeoMapRouteScenario(String name, String type, String map, List<GeographicMapPointData> data)
  {
    super();
    this.name = name;
    this.type = type;
    this.map = map;
    this.data = data.toArray(new GeographicMapPointData[data.size()]);
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }

  public String getMap()
  {
    return map;
  }

  public GeographicMapPointData[] getData()
  {
    return data;
  }
}
