package br.com.validcpf.validcpf.controller;

import br.com.validcpf.validcpf.dto.ListaRestritaDto;
import br.com.validcpf.validcpf.service.ListaRestritaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "cpf")
@RestController
public class ListaRestritaController {

    @Autowired
    private ListaRestritaService listaRestritaService;

    @GetMapping
    public ResponseEntity<List<ListaRestritaDto>> findAllCpf() {

        return listaRestritaService.findAllCpf();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCpf(@RequestBody ListaRestritaDto listaRestritaDto) {

        return listaRestritaService.createCpf(listaRestritaDto);
    }

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<?> checkCpf(@PathVariable String cpf) {

        return listaRestritaService.checkCpf(cpf);
    }

    @DeleteMapping(path = "/{cpf}")
    public ResponseEntity<?> removeCpf(@PathVariable String cpf) {

        return listaRestritaService.removeCpf(cpf);
    }

}
