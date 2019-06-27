package br.com.consultemed.exception;

public class DataAgendamentoException extends RuntimeException {

    public DataAgendamentoException(String message) {
        super(message);
    }

    public DataAgendamentoException(String message, Throwable cause) {
        super(message, cause);
    }
}
