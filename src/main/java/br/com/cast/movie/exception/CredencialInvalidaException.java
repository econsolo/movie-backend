package br.com.cast.movie.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CredencialInvalidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public CredencialInvalidaException() {
		super("Credenciais inválidas! Efetue a autenticação novamente.");
	}
}
