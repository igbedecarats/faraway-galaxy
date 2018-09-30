package org.galaxy.galaxyweathersimulator.weather;

import java.util.Arrays;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.service.DroughtWeatherResolver;
import org.galaxy.galaxyweathersimulator.weather.service.FindWeatherService;
import org.galaxy.galaxyweathersimulator.weather.service.FindWeatherServiceImpl;
import org.galaxy.galaxyweathersimulator.weather.service.RainyWeatherResolver;
import org.galaxy.galaxyweathersimulator.weather.service.SunnyWeatherResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfiguration {

  @Autowired
  private SolarSystem solarSystem;

  @Bean
  public FindWeatherService findWeatherService() {
    return new FindWeatherServiceImpl(
        solarSystem,
        Arrays.asList(
            new DroughtWeatherResolver(),
            new RainyWeatherResolver(),
            new SunnyWeatherResolver()
        )
    );
  }
}
