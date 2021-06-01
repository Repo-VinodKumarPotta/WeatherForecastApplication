package com.weatherforecast.integration.service.impl;

import com.weatherforecast.constants.WeatherForecastConstants;
import com.weatherforecast.exception.ClientExceptions;
import com.weatherforecast.model.helper.WeatherForecastHelperMain;
import com.weatherforecast.model.request.WeatherForecastRequest;
import com.weatherforecast.model.response.WeatherForecastResponse;
import com.weatherforecast.model.response.helper.WeatherForecastDetails;
import com.weatherforecast.model.response.helper.WeatherForecastStatus;
import com.weatherforecast.service.WeatherForecastService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Vinod Kumar Potta
 */

@Service
@Slf4j
public class WeatherForecastServiceImpl implements WeatherForecastService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${org.openweathermap.api.weatherforecast:#{null}}")
    private String targetURL;

    @Value ("${com.ms.apikey}")
    private String apiKey;

    @Override
    public ResponseEntity<WeatherForecastResponse> getWeatherForecastData(WeatherForecastRequest weatherForecastRequest) {

            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(targetURL)
                    .queryParam(WeatherForecastConstants.QUERY_PARAM_ZIP_COUNTRY, weatherForecastRequest.getZipCode() + "," + (weatherForecastRequest.getCountry() != null ? weatherForecastRequest.getCountry() : ""))
                    .queryParam(WeatherForecastConstants.QUERY_PARAM_APIKEY, apiKey)
                    .queryParam(WeatherForecastConstants.QUERY_PARAM_UNITS, WeatherForecastConstants.TEMPERATURE_IN_UNITS);

        ResponseEntity<WeatherForecastHelperMain> weatherForecastHelperResponse = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, requestEntity, new ParameterizedTypeReference<WeatherForecastHelperMain>() {});
        if(weatherForecastHelperResponse.getStatusCode() == HttpStatus.OK) {
                 return ResponseEntity.ok(WeatherForecastResponse.builder()
                        .country(weatherForecastHelperResponse.getBody().getCity().getCountry())
                        .city(weatherForecastHelperResponse.getBody().getCity().getName())
                        .weatherForecastDetails(
                                weatherForecastHelperResponse.getBody().getList().stream().map(weatherdetail -> WeatherForecastDetails.builder()
                                        .date(Instant.ofEpochSecond(weatherdetail.getDt()).atZone(ZoneId.systemDefault()).toLocalDateTime())
                                        .temperature(weatherdetail.getMain().getTemp())
                                        .feelsLike(weatherdetail.getMain().getFeelsLike())
                                        .temperatureMin(weatherdetail.getMain().getTempMin())
                                        .temperatureMax(weatherdetail.getMain().getTempMax())
                                        .humidity(weatherdetail.getMain().getHumidity())
                                        .windSpeed(weatherdetail.getWind().getSpeed())
                                        .weatherForecastStatuses(weatherdetail.getWeather().stream().map(weather -> WeatherForecastStatus.builder()
                                                .category(weather.getMain())
                                                .detailedDescription(weather.getDescription())
                                                .build()).collect(Collectors.toCollection(ArrayList::new)))
                                        .build()
                                ).collect(Collectors.toCollection(ArrayList::new))
                        ).build());


            } else {
                throw new ClientExceptions ("Client Exception","Unable to fetch Weather data");
            }

    }
}
