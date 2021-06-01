
package com.weatherforecast.model.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Main {

    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("feels_like")
    private Double feelsLike;
    @JsonProperty("temp_min")
    private Double tempMin;
    @JsonProperty("temp_max")
    private Double tempMax;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("sea_level")
    private Integer seaLevel;
    @JsonProperty("grnd_level")
    private Integer grndLevel;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("temp_kf")
    private Integer tempKf;

}
