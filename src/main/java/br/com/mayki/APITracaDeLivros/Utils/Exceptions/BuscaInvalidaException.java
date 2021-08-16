package br.com.mayki.APITracaDeLivros.Utils.Exceptions;

public class BuscaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public BuscaInvalidaException() {
		super();
	}

	public BuscaInvalidaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BuscaInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public BuscaInvalidaException(String message) {
		super(message);
	}

	public BuscaInvalidaException(Throwable cause) {
		super(cause);
	}

}
