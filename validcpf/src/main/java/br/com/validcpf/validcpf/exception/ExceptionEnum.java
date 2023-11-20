package br.com.validcpf.validcpf.exception;

public enum ExceptionEnum {

    DESCONHECIDO("UnknownException", "Erro não mapeado"),
    INVALIDO("InvalidCpfException", "CPF inválido"),
    EXISTENTE("ExistsCpfException", "CPF já cadastrado"),
    NAO_ENCONTRADO("NotFoundCpfException", "CPF não encontrado");

    public String type;
    public String message;

    ExceptionEnum(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
