
package com.weatherforecast.model.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("country")
    private String country;
    @JsonProperty("population")
    private Integer population;
    @JsonProperty("timezone")
    private Integer timezone;
    @JsonProperty("sunrise")
    private Integer sunrise;
    @JsonProperty("sunset")
    private Integer sunset;

}
