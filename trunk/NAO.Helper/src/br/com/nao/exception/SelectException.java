package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class SelectException extends NAOException {

	
	private static final long serialVersionUID = 1310086877600843884L;

	
	public SelectException(String entityName) {
		super(SelectException.class);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
	public SelectException(String entityName, Throwable cause) throws NAOException {
		super(SelectException.class, cause);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
}
