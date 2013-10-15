package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class EntityNotFoundException extends NAOException {

	private static final long serialVersionUID = 8635604731989547524L;

	public EntityNotFoundException(String entityName) {
		super(EntityNotFoundException.class);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
	public EntityNotFoundException(String entityName, Throwable cause) throws NAOException {
		super(EntityNotFoundException.class, cause);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
}
