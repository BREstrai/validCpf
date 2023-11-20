package br.com.validcpf.validcpf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistsCpfException extends RuntimeException {

    public ExistsCpfException(String message) {
        super(message);
    }
}
