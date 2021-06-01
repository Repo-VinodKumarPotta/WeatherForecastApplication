package com.weatherforecast.juint.mockito.controller;

import com.weatherforecast.constants.WeatherForecastConstants;
import com.weatherforecast.integration.service.impl.WeatherForecastServiceImpl;
import com.weatherforecast.model.request.WeatherForecastRequest;
import com.weatherforecast.model.response.WeatherForecastResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Vinod Kumar Potta
 */

@RestController
@RequestMapping(value = WeatherForecastConstants.URL_V1_PREFIX)
@Slf4j
public class WeatherForecastController {

    @Autowired
    WeatherForecastServiceImpl weatherForecastServiceImpl;

    @Operation(summary = "This is to fetch Weather Forecast from OpenWeather")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetched WeatherForecast from OpenWeather",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Unable to fetch WeatherForecast for the given given Input",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error occurred. Please try again after sometime!!!",
                    content = @Content)
    })
    @PostMapping(value = WeatherForecastConstants.URL_WEATHERFORECAST_DATA_RETRIEVE, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WeatherForecastResponse> getWeatherForecastData(@RequestBody @Valid WeatherForecastRequest weatherForecastRequest) {
        return weatherForecastServiceImpl.getWeatherForecastData(weatherForecastRequest);
    }
}
