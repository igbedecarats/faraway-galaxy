package org.galaxy.galaxyweathersimulator.planet.domain;

import lombok.Getter;

@Getter
public class SolarSystem {

  private int day;
  private Planet ferengi;
  private Planet betasoide;
  private Planet vulcano;

  public SolarSystem(final Planet ferengi, final Planet betasoide, final Planet vulcano) {
    this.day = 0;
    this.ferengi = ferengi;
    this.betasoide = betasoide;
    this.vulcano = vulcano;
  }

  public void simulatePlanetsPositionForDay(final int day) {
    this.day = day;
    ferengi.simulatetPositionForDay(day);
    betasoide.simulatetPositionForDay(day);
    vulcano.simulatetPositionForDay(day);
  }
}
