package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;

public class CommitTransactionException extends NAOException {

	private static final long serialVersionUID = -5890444826197928272L;

	public CommitTransactionException(Throwable cause) throws NAOException {
		super(CommitTransactionException.class, cause);
	}
}
