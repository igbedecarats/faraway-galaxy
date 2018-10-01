package org.galaxy.galaxyweathersimulator.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The weather of the galaxy's solar system for a given day with its amount of precipitation.
 */
@Getter
@AllArgsConstructor
public class Weather {

  /**
   * The day in which this weather was calculated in the solar system. It's always positive.
   */
  private int day;

  /**
   * The weather's type. It's never null.
   */
  private WeatherType weatherType;

  /**
   * The amount of precipitation for the given day. It'll be greater than zero only for a {@link WeatherType#RAIN} day;
   * otherwise, it's always zero.
   */
  private double precipitation;

}
