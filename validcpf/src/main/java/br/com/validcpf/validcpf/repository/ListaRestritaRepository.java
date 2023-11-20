package br.com.validcpf.validcpf.repository;

import br.com.validcpf.validcpf.domain.ListaRestrita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRestritaRepository extends JpaRepository<ListaRestrita, String> {

    ListaRestrita findByCpf(String cpf);
}
