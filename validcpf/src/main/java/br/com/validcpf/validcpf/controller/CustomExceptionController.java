package br.com.validcpf.validcpf.controller;

import br.com.validcpf.validcpf.exception.ExistsCpfException;
import br.com.validcpf.validcpf.exception.InvalidCpfException;
import br.com.validcpf.validcpf.exception.NotFoundCpfException;
import br.com.validcpf.validcpf.exception.ObjectException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseBody
public class CustomExceptionController {

    @ExceptionHandler(InvalidCpfException.class)
    public ResponseEntity<Object> handleInvalidCpfException(InvalidCpfException ex) {
        ObjectException objectException = new ObjectException("InvalidCpfException", "CPF inválido");
        return ResponseEntity.badRequest().body(objectException);
    }

    @ExceptionHandler(ExistsCpfException.class)
    public ResponseEntity<Object> handleExistsCpfException(ExistsCpfException ex) {
        ObjectException objectException = new ObjectException("ExistsCpfException", "CPF já cadastrado");
        return ResponseEntity.badRequest().body(objectException);
    }

    @ExceptionHandler(NotFoundCpfException.class)
    public ResponseEntity<Object> handleNotFoundException(ExistsCpfException ex) {
        ObjectException objectException = new ObjectException("NotFoundCpfException", "CPF não encontrado");
        return ResponseEntity.badRequest().body(objectException);
    }
}
