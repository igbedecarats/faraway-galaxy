package org.galaxy.galaxyweathersimulator.forecast;

import java.util.Arrays;
import org.galaxy.galaxyweathersimulator.forecast.service.SimulateForecastService;
import org.galaxy.galaxyweathersimulator.forecast.service.SimulateForecastServiceImpl;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.service.DroughtWeatherResolver;
import org.galaxy.galaxyweathersimulator.weather.service.RainyWeatherResolver;
import org.galaxy.galaxyweathersimulator.weather.service.SunnyWeatherResolver;
import org.galaxy.galaxyweathersimulator.weather.service.UndefinedWeatherResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ForecastConfiguration {

  @Autowired
  private SolarSystem solarSystem;

  @Bean
  public SimulateForecastService simulateForecastService() {
    return new SimulateForecastServiceImpl(
        solarSystem,
        Arrays.asList(
            new DroughtWeatherResolver(),
            new RainyWeatherResolver(),
            new SunnyWeatherResolver()
        )
    );
  }

}
