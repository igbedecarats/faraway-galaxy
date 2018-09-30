package org.galaxy.galaxyweathersimulator.weather.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.domain.WeatherType;

@Getter
@AllArgsConstructor
public class WeatherDto {

  private int day;

  private WeatherType weatherType;

  private double precipitation;

  public static WeatherDto toDto(Weather weather) {
    return new WeatherDto(weather.getDay(), weather.getWeatherType(), weather.getPrecipitation());
  }
}
