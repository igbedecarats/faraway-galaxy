package org.galaxy.galaxyweathersimulator.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Weather {

  private int day;

  private WeatherType weatherType;

  private double precipitation;

}
