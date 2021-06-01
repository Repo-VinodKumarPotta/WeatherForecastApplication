package com.weatherforecast;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Vinod Kumar Potta
 */

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				version = "1.0.0",
				title = "Weather Forecast Service",
				description = "#Introduction\n"
						+ "Weather Forecast Service is to retrieve next 5 days weather forecast information",
				contact = @Contact(email = "vinodkumar.potta@outlook.com", name = "Vinod Kumar Potta")
		)
)
public class WeatherForecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastApplication.class, args);
	}

}
