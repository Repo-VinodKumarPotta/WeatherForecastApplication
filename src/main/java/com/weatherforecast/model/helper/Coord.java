
package com.weatherforecast.model.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coord {

    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lon")
    private Double lon;


}
