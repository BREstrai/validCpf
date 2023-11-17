package br.com.validcpf.validcpf.exception;

import lombok.Getter;

public class InvalidCpfException extends RuntimeException {

    public InvalidCpfException(String message) {
        super(message);
    }
}
