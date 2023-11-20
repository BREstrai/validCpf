package br.com.validcpf.validcpf.domain;

import br.com.validcpf.validcpf.dto.ListaRestritaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "lista_restrita", schema = "cpfvalid")
@Getter
@Setter
public class ListaRestrita {

    @Id
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "created_at", columnDefinition = "timestamp")
    private LocalDateTime createdAt;

    public ListaRestritaDto convertToDto() {

        return new ListaRestritaDto(this.cpf, this.createdAt);
    }
}
