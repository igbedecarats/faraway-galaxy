package org.galaxy.galaxyweathersimulator.planet.domain;

class PlanetFactory {

  static Planet createFerengi() {
    return new Planet("Ferengi", 500, -1);
  }

  static Planet createBetasoide() {
    return new Planet("Betasoide", 3000, -3);
  }

  static Planet createVulcano() {
    return new Planet("Vulcano", 1000, 5);
  }

}
