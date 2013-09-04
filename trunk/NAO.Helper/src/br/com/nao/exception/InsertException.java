package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class InsertException extends NAOException {

	
	private static final long serialVersionUID = -6057423217852444386L;
	
	
	public InsertException(String entityName) {
		super(InsertException.class);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
	public InsertException(String entityName, Throwable cause) throws NAOException {
		super(InsertException.class, cause);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
}
