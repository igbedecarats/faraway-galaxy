package org.galaxy.galaxyweathersimulator.forecast.domain;

import java.util.HashMap;
import java.util.Map;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;

public class ForecastRepository {

  private Map<Integer, Weather> weatherBydayDB = new HashMap<>();

  private SolarSystem solarSystem;

  public ForecastRepository(
      Map<Integer, Weather> weatherBydayDB, SolarSystem solarSystem) {
    this.weatherBydayDB = weatherBydayDB;
    this.solarSystem = solarSystem;

  }


}
