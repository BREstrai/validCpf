package br.com.validcpf.validcpf.dto;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaRestritaDto {

    private String cpf;

    private LocalDateTime createdAt;

    public ListaRestritaDto(String cpf) {
        this.cpf = cpf;
        this.createdAt = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
    }

    public String getCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return createdAt.format(formatter);
    }
}
