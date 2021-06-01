
package com.weatherforecast.model.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sys {

    @JsonProperty("pod")
    private String pod;

}
