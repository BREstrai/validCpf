package br.com.validcpf.validcpf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Cpf {

    private String cpf;

    private LocalDateTime createdAt;

}
