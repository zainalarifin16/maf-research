package model;

import java.util.ArrayList;
import java.util.List;

public class GeographicMapRouteScenarioList {
      private List<GeoMapRouteScenario> scenarios;

      public GeographicMapRouteScenarioList()
      {
        List<GeographicMapPointData> s_geographicMapPointDataList = new ArrayList<GeographicMapPointData>();
        scenarios = new ArrayList<GeoMapRouteScenario>();

        s_geographicMapPointDataList.add(new GeographicMapPointData(-71.5, 42.21, "pointXY", "Boston"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(-87.37, 41.5, "pointXY", "Chicago"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(-122.26, 37.47, "pointXY", "San Franciso"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(-95.21, 29.45, "pointXY", "Houston"));

        scenarios.add(new GeoMapRouteScenario("Long Trip", "Driving", "ROADMAP", s_geographicMapPointDataList));

        s_geographicMapPointDataList = new ArrayList<>();

        s_geographicMapPointDataList.add(new GeographicMapPointData(14.421171, 50.087504, "pointXY", "Old Town Square"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(14.420712, 50.087032, "pointXY", "Astronomical Clock"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(14.427987, 50.081013, "pointXY", "Wenceslas Square"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(14.411442, 50.086480, "pointXY", "Charles Bridge"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(14.403523, 50.085733, "pointXY",
                                                                    "Infant Jesus of Prague"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(14.418763, 50.090059, "pointXY",
                                                                    "Jewish Quarter Museum and Old New Synagogue"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(14.399584, 50.090183, "pointXY", "Prague Castle"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(14.400550, 50.090898, "pointXY",
                                                                    "St. Vitus Cathedral"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(14.391844, 50.089245, "pointXY", "Loreta"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(14.389763, 50.085618, "pointXY", "Strahov Library"));

        scenarios.add(new GeoMapRouteScenario("Little Prague Walk", "Walking", "ROADMAP", s_geographicMapPointDataList));

        s_geographicMapPointDataList = new ArrayList<>();
        s_geographicMapPointDataList.add(new GeographicMapPointData(-112.365979, 33.427984, "pointXY", "Tempe"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(-111.952772, 33.832799, "pointXY", "Phoenix"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(-112.060096, 36.209862, "pointXY", "North Rim"));
        s_geographicMapPointDataList.add(new GeographicMapPointData(-113.098516, 37.701141, "pointXY", "Cedar City"));

        scenarios.add(new GeoMapRouteScenario("Bike Tour", "Cycling", "TERRAIN", s_geographicMapPointDataList));
      }

      public List<GeoMapRouteScenario> getScenarios()
      {
        return scenarios;
      }
}
