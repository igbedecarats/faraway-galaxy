package org.galaxy.galaxyweathersimulator.weather.domain;

public class WeatherFactory {

  private static double DEFAULT_PRECIPITAION = 0.0d;

  public static Weather createUndefinedWeather(final int day) {
    return new Weather(day, WeatherType.UNDEFINED, DEFAULT_PRECIPITAION);
  }

  public static Weather createDroughtWeather(final int day) {
    return new Weather(day, WeatherType.DROUGHT, DEFAULT_PRECIPITAION);
  }

  public static Weather createOptimaltWeather(final int day) {
    return new Weather(day, WeatherType.OPTIMAL, DEFAULT_PRECIPITAION);
  }

  public static Weather createRainyWeather(final int day, final double precipitation) {
    return new Weather(day, WeatherType.RAIN, precipitation);
  }
}
