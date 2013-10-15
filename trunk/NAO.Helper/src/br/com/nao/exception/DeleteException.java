package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class DeleteException extends NAOException {


	private static final long serialVersionUID = -5744689408587352762L;

	
	public DeleteException(String entityName) {
		super(DeleteException.class);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
	public DeleteException(String entityName, Throwable cause) throws NAOException {
		super(DeleteException.class, cause);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
}
