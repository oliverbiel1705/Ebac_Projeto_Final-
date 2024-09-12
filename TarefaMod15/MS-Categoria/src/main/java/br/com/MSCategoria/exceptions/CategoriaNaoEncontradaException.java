package br.com.MSCategoria.exceptions;

public class CategoriaNaoEncontradaException extends RuntimeException {
    private static final long serialVersionUID = 1l;
    public CategoriaNaoEncontradaException(String message) {
        super(message);
    }
}
