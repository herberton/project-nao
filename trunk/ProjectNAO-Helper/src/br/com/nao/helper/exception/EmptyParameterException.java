package br.com.nao.helper.exception;

import br.com.nao.helper.exception.common.NAOParametrizedException;
import br.com.nao.helper.message.Message;

public class EmptyParameterException extends NAOParametrizedException {

	private static final long serialVersionUID = -5380625643222224031L;

	
	public EmptyParameterException(String parameter) {
		super(EmptyParameterException.class);
		this.setParameter(parameter);
	}
	public EmptyParameterException(String parameter, Message detailMessage) {
		super(EmptyParameterException.class, detailMessage);
		this.setParameter(parameter);
	}
	public EmptyParameterException(Throwable cause, String parameter) {
		super(cause, EmptyParameterException.class);
		this.setParameter(parameter);
	}
	public EmptyParameterException(Throwable cause, String parameter, Message detailMessage) {
		super(cause, EmptyParameterException.class, detailMessage);
		this.setParameter(parameter);
	}
	
	
	public String getParameter() {
		return super.getArgument(0).toString();
	}
	private void setParameter(String parameter) {
		super.putArgument(0, parameter);
	}
}
