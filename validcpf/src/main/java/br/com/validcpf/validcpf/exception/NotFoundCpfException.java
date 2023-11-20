package br.com.validcpf.validcpf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundCpfException extends RuntimeException{

    public NotFoundCpfException(String message) {
        super(message);
    }
}
