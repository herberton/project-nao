package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class CountException extends NAOException {
	
	private static final long serialVersionUID = 4085471892199750157L;
	
	public CountException(String entityName) {
		super(CountException.class);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
	public CountException(String entityName, Throwable cause) throws NAOException {
		super(CountException.class, cause);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
}
