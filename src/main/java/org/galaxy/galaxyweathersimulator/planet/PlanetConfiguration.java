package org.galaxy.galaxyweathersimulator.planet;

import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystemFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlanetConfiguration {

  @Bean
  public SolarSystem solarSystem() {
    return SolarSystemFactory.create();
  }

}
