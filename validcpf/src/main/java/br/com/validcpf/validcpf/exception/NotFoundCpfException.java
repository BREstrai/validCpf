package br.com.validcpf.validcpf.exception;

public class NotFoundCpfException extends RuntimeException{

    public NotFoundCpfException(String message) {
        super(message);
    }
}
