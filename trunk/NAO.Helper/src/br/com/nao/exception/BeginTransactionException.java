package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;

public class BeginTransactionException extends NAOException {

	private static final long serialVersionUID = -5078701415179817434L;

	public BeginTransactionException(Throwable cause) throws NAOException {
		super(BeginTransactionException.class, cause);
	}
}
