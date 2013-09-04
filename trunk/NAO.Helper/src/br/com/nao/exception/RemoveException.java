package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class RemoveException extends NAOException {

	private static final long serialVersionUID = 7214466673821711345L;

	
	public RemoveException(String entityName) {
		super(RemoveException.class);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
	public RemoveException(String entityName, Throwable cause) throws NAOException {
		super(RemoveException.class, cause);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
}
