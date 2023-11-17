package br.com.validcpf.validcpf.repository;

import br.com.validcpf.validcpf.domain.Cpf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpfRepository extends JpaRepository<Cpf, Long> {


}
