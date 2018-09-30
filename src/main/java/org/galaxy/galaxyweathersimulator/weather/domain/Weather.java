package org.galaxy.galaxyweathersimulator.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;

@Getter
@AllArgsConstructor
public class Weather {

  private int day;

  private WeatherType weatherType;

  private double precipitation;

}
