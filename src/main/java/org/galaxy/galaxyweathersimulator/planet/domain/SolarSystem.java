package org.galaxy.galaxyweathersimulator.planet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;

@Getter
@AllArgsConstructor
public class SolarSystem {
  private Planet ferengi;
  private Planet betasoide;
  private Planet vulcano;
}
