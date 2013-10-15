package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class SaveException extends NAOException {

	private static final long serialVersionUID = 6942883156952547090L;

	
	public SaveException(String entityName) {
		super(SaveException.class);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
	public SaveException(String entityName, Throwable cause) throws NAOException {
		super(SaveException.class, cause);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
}
