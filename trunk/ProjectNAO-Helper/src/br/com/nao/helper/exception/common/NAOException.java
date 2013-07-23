package br.com.nao.helper.exception.common;

import br.com.nao.helper.message.IMessenger;
import br.com.nao.helper.message.Message;

public class NAOException extends Exception implements IMessenger {

	private static final long serialVersionUID = 832901909136804451L;

	
	private Class<? extends NAOException> clazz;
	private Message detailMessage;
	
	
	public <T extends NAOException> NAOException(Class<T> clazz) {
		super();
		this.setClazz(clazz);
	}
	public <T extends NAOException> NAOException(Class<T> clazz, Message detailMessage) {
		this(clazz);
		this.setDetailMessage(detailMessage);
	}
	public <T extends NAOException> NAOException(Throwable cause, Class<T> clazz) {
		super(cause);
		this.setClazz(clazz);
		this.printStackTrace(cause);
	}
	public <T extends NAOException> NAOException(Throwable cause, Class<T> clazz, Message detailMessage) {
		super(cause);
		this.setClazz(clazz);
		this.setDetailMessage(detailMessage);
		this.printStackTrace(cause);
	}
	
	
	public Class<? extends NAOException> getClazz() {
		return clazz;
	}
	protected void setClazz(Class<? extends NAOException> clazz) {
		this.clazz = clazz;
	}
	public Message getDetailMessage() {
		return this.detailMessage;
	}
	public void setDetailMessage(Message detailMessage) {
		this.detailMessage = detailMessage;
	}
	
	@Override
	public Message toMessage() {
		return new Message(this);
	}
	
	public void printStackTrace(Throwable cause) {
		if (cause != null) {
			cause.printStackTrace();	
		}
	}
}
