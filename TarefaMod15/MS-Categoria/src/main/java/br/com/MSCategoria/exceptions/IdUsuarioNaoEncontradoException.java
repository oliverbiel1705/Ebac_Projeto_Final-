package br.com.MSCategoria.exceptions;

public class IdUsuarioNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public IdUsuarioNaoEncontradoException(String message) {
        super(message);
    }
}
