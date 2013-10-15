package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class InvalidParameterException extends NAOException {

	private static final long serialVersionUID = 455564452605760207L;

	public InvalidParameterException(String parameter) {
		super(InvalidParameterException.class);
		super.getParameterList().add(new ParameterTO<>(0, parameter));
	}
	public InvalidParameterException(String parameter, Throwable cause) throws NAOException {
		super(InvalidParameterException.class, cause);
		super.getParameterList().add(new ParameterTO<>(0, parameter));
	}
}
