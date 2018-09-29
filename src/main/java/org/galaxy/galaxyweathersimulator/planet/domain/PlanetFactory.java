package org.galaxy.galaxyweathersimulator.planet.domain;

public class PlanetFactory {

  public static Planet createFerengi() {
    return new Planet("Ferengi", 500, -1);
  }

  public static Planet createBetasoide() {
    return new Planet("Betasoide", 3000, -3);
  }

  public static Planet createVulcano() {
    return new Planet("Vulcano", 1000, 5);
  }

}
