package org.galaxy.galaxyweathersimulator.forecast.domain;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.domain.WeatherType;

/**
 * Aggregation of {@link Weather}s that were calculated for different days
 */
@NoArgsConstructor
public class Forecast {

  private Map<Integer, Weather> forecast = new LinkedHashMap<>();

  /**
   * Adds a {@link Weather} to forecast for the given day.
   *
   * @param day The day of the weather being added to the forecast. It must be positive.
   * @param weather The weather being added to the forecast for the given day. It cannot be null.
   */
  public void addWeatherForDay(final int day, final Weather weather) {
    Validate.isTrue(day >= 0, "The day must be positive.");
    Validate.notNull(weather, "The weather cannot be null");
    forecast.put(day, weather);
  }

  /**
   * Returns the number of days in the forecast of the type {@link WeatherType#OPTIMAL}
   *
   * @return The number of days in the forecast of the type {@link WeatherType#OPTIMAL}. It's never negative.
   */
  public long numberOfOptimalDays() {
    return numberOfDaysWithWeather(WeatherType.OPTIMAL);
  }

  /**
   * Returns the number of days in the forecast of the type {@link WeatherType#RAIN}
   *
   * @return The number of days in the forecast of the type {@link WeatherType#RAIN}. It's never negative.
   */
  public long numberOfRainyDays() {
    return numberOfDaysWithWeather(WeatherType.RAIN);
  }

  /**
   * Returns the number of days in the forecast of the type {@link WeatherType#DROUGHT}
   *
   * @return The number of days in the forecast of the type {@link WeatherType#DROUGHT}. It's never negative.
   */
  public long numberDroughtDays() {
    return numberOfDaysWithWeather(WeatherType.DROUGHT);
  }

  /**
   * Returns the weather for the day with rainy conditions and the most precipitation.
   *
   * @return The weather for the day with rainy conditions and the most precipitation, or null if there isn't any rainy
   * day in the forecast.
   */
  public Weather getMostRainyDays() {
    return forecast.values().stream()
        .filter(weather -> weather.getWeatherType().equals(WeatherType.RAIN))
        .max(Comparator.comparing(Weather::getPrecipitation))
        .orElse(null);
  }

  private long numberOfDaysWithWeather(final WeatherType weatherType) {
    return forecast.values().stream()
        .filter(weather -> weatherType.equals(weather.getWeatherType())).count();
  }

}
