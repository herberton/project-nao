package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;

public class RollbackTransactionException extends NAOException {

	private static final long serialVersionUID = 5009355566167360439L;

	public RollbackTransactionException(Throwable cause) throws NAOException {
		super(RollbackTransactionException.class, cause);
	}
}
