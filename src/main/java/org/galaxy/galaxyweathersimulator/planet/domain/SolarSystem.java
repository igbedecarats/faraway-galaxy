package org.galaxy.galaxyweathersimulator.planet.domain;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import lombok.Getter;

@Getter
public class SolarSystem {

  private int day;
  private Planet ferengi;
  private Planet betasoide;
  private Planet vulcano;
  private Point2D center;

  public SolarSystem(final Planet ferengi, final Planet betasoide, final Planet vulcano) {
    this.day = 0;
    this.center = new Double(0.0d, 0.0d);
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
