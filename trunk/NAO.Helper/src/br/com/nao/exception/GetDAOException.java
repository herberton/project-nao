package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class GetDAOException extends NAOException {

	private static final long serialVersionUID = -2248444289697187637L;

	public GetDAOException(String entityName) {
		super(GetDAOException.class);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
	public GetDAOException(String entityName, Throwable cause) throws NAOException {
		super(GetDAOException.class, cause);
		super.getParameterList().add(new ParameterTO<>(0, entityName));
	}
}
