package com.weatherforecast.model.request;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Vinod Kumar Potta
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class WeatherForecastRequest {

    private int zipCode;
    //@NotBlank
    //@NotNull
    private String country;
}
