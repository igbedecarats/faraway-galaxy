package org.galaxy.galaxyweathersimulator.forecast;

import org.galaxy.galaxyweathersimulator.forecast.service.SimulateForecastService;
import org.galaxy.galaxyweathersimulator.forecast.service.SimulateForecastServiceImpl;
import org.galaxy.galaxyweathersimulator.weather.service.FindWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ForecastConfiguration {

  @Autowired
  public FindWeatherService findWeatherService;

  @Bean
  public SimulateForecastService simulateForecastService() {
    return new SimulateForecastServiceImpl(findWeatherService);
  }

}
