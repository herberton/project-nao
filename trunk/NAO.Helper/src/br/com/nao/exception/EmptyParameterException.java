package br.com.nao.exception;

import br.com.nao.exception.common.NAOException;
import br.com.nao.to.ParameterTO;

public class EmptyParameterException extends NAOException {

	private static final long serialVersionUID = -7412695787511450192L;
	
	public EmptyParameterException() {
		super(EmptyParameterException.class);
	}
	public EmptyParameterException(String parameterName) {
		this();
		super.getParameterList().add(new ParameterTO<>(0, parameterName));
	}
}
