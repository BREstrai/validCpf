package br.com.validcpf.validcpf.service;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.validcpf.validcpf.domain.ListaRestrita;
import br.com.validcpf.validcpf.dto.ListaRestritaDto;
import br.com.validcpf.validcpf.exception.ExistsCpfException;
import br.com.validcpf.validcpf.exception.InvalidCpfException;
import br.com.validcpf.validcpf.exception.NotFoundCpfException;
import br.com.validcpf.validcpf.exception.ObjectException;
import br.com.validcpf.validcpf.repository.ListaRestritaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.validcpf.validcpf.exception.ExceptionEnum.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class ListaRestritaService {

    @Autowired
    private ListaRestritaRepository listaRestritaRepository;

    public ResponseEntity<List<ListaRestritaDto>> findAllCpf() {

        List<ListaRestritaDto> listListaRestritaDto = new ArrayList<>();

        List<ListaRestrita> listaRestritaList = listaRestritaRepository.findAll();

        listaRestritaList.forEach(listaRestrita -> listListaRestritaDto.add(listaRestrita.convertToDto()));

        return ResponseEntity.ok().body(listListaRestritaDto);
    }

    public ResponseEntity<?> createCpf(ListaRestritaDto listaRestritaDto) {

        try {

            ListaRestrita listaRestrita = new ListaRestrita();
            listaRestrita.setCpf(listaRestritaDto.getCpf());
            listaRestrita.setCreatedAt(LocalDateTime.now());

            validarCpf(listaRestrita);

            listaRestrita = listaRestritaRepository.save(listaRestrita);

            return ResponseEntity.ok().body(listaRestrita.convertToDto());
        } catch (InvalidCpfException e) {

            return ResponseEntity.badRequest().body(new ObjectException(INVALIDO.type, e.getMessage()));
        } catch (ExistsCpfException e) {

            return ResponseEntity.badRequest().body(new ObjectException(EXISTENTE.type, e.getMessage()));
        }
    }

    private void validarCpf(ListaRestrita listaRestrita) {

        validaDigitos(listaRestrita.getCpf());
        validaDuplicidade(listaRestrita);
    }

    public ResponseEntity<?> checkCpf(String cpf) {

        try {
            validaDigitos(cpf);

            ListaRestrita cpfCadastrado = listaRestritaRepository.findByCpf(cpf);

            if (isNull(cpfCadastrado)) {

                throw new NotFoundCpfException(NAO_ENCONTRADO.message);
            }

            return ResponseEntity.ok().body(cpfCadastrado.convertToDto());
        } catch (NotFoundCpfException e) {

            return ResponseEntity.badRequest().body(new ObjectException(NAO_ENCONTRADO.type, NAO_ENCONTRADO.message));
        } catch (InvalidCpfException e) {

            return ResponseEntity.badRequest().body(new ObjectException(INVALIDO.type, INVALIDO.message));
        }
    }

    public ResponseEntity<?> removeCpf(String cpf) {

        try {
            validaDigitos(cpf);

            ListaRestrita cpfCadastrado = listaRestritaRepository.findByCpf(cpf);

            if (isNull(cpfCadastrado)) {

                throw new NotFoundCpfException(NAO_ENCONTRADO.message);
            }

            listaRestritaRepository.delete(cpfCadastrado);
            return ResponseEntity.noContent().build();
        } catch (NotFoundCpfException e) {

            return ResponseEntity.badRequest().body(new ObjectException(NAO_ENCONTRADO.type, NAO_ENCONTRADO.message));
        } catch (InvalidCpfException e) {

            return ResponseEntity.badRequest().body(new ObjectException(INVALIDO.type, INVALIDO.message));
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(new ObjectException(DESCONHECIDO.type, e.getMessage()));
        }
    }

    private void validaDuplicidade(ListaRestrita cpf) {

        ListaRestrita listaRestrita = listaRestritaRepository.findByCpf(cpf.getCpf());

        if (nonNull(listaRestrita)) {

            throw new ExistsCpfException(EXISTENTE.message);
        }
    }

    private void validaDigitos(String cpf) {

        CPFValidator cpfValidator = new CPFValidator();

        try {

            if (!cpf.matches("[0-9]+")) {

                throw new InvalidCpfException(INVALIDO.message);
            }

            cpfValidator.assertValid(cpf);
        } catch (Exception e) {

            throw new InvalidCpfException(INVALIDO.message);
        }
    }
}
