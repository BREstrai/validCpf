package br.com.validcpf.validcpf.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectException {

    @JsonProperty("type")
    private String type;

    @JsonProperty("message")
    private String message;

}
