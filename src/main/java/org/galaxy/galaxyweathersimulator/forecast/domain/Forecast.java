package org.galaxy.galaxyweathersimulator.forecast.domain;

import java.util.Map;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.domain.WeatherType;

public class Forecast {

  private Map<Integer, Weather> forecast;

  public Forecast(final Map<Integer, Weather> forecast) {
    this.forecast = forecast;
  }

  public long numberOfSunnyDays() {
    return numberOfDaysWithWeather(WeatherType.SUNNY);
  }

  public long numberOfRainyDays() {
    return numberOfDaysWithWeather(WeatherType.RAIN);
  }

  public long numberDroughtDays() {
    return numberOfDaysWithWeather(WeatherType.DROUGHT);
  }

  public Map<Integer, Weather> getMostRainyDays() {
    return null;
  }

  private long numberOfDaysWithWeather(final WeatherType weatherType) {
    return forecast.values().stream()
        .filter(weather -> weatherType.equals(weather.getWeatherType())).count();
  }

}
