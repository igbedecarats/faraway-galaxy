package org.galaxy.galaxyweathersimulator.forecast.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.domain.WeatherType;

@NoArgsConstructor
public class Forecast {

  private Map<Integer, Weather> forecast = new LinkedHashMap<>();

  public void addWeatherForDay(final int day, final Weather weather) {
    Validate.isTrue(day > 1, "The day must be greater than zero.");
    Validate.notNull(weather, "The weather cannot be null");
    forecast.put(day, weather);
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
