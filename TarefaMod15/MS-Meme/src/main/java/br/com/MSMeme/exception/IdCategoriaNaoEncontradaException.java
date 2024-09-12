package br.com.MSMeme.exception;

public class IdCategoriaNaoEncontradaException extends RuntimeException {
    private static final long serialVersionUID = 1l;
    public IdCategoriaNaoEncontradaException(String message) {
        super(message);
    }
}
