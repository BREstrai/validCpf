package br.com.validcpf.validcpf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CpfDto {

    private String cpf;

    private LocalDateTime createdAt;
}
