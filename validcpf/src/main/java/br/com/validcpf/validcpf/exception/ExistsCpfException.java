package br.com.validcpf.validcpf.exception;

public class ExistsCpfException extends RuntimeException{

    public ExistsCpfException(String message) {
        super(message);
    }
}
