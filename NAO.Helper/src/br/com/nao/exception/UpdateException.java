package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class UpdateException extends NAOException {

	private static final long serialVersionUID = 3765249947269339026L;

	public UpdateException(String entityName) {
		super(UpdateException.class);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
	public UpdateException(String entityName, Throwable cause) throws NAOException {
		super(UpdateException.class, cause);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
}
