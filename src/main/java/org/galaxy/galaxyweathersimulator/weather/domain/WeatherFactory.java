package org.galaxy.galaxyweathersimulator.weather.domain;

public class WeatherFactory {

  private static double DEFAULT_PRECIPITAION = 0.0d;

  public static Weather createUndefinedWeather(final int day) {
    return new Weather(day, WeatherType.UNDEFINED, DEFAULT_PRECIPITAION);
  }
}
