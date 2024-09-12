package br.com.MSMeme.exception;

public class MemeNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1l;
    public MemeNaoEncontradoException(String message) {
        super(message);
    }
}
