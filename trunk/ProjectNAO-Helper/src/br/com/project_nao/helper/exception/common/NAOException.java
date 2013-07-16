package br.com.project_nao.helper.exception.common;

import br.com.project_nao.helper.message.Message;

public class NAOException extends Exception {

	private static final long serialVersionUID = 832901909136804451L;

	
	private Class<? extends NAOException> clazz;
	private Message detailMessage;
	
	
	public <T extends NAOException> NAOException(Class<T> clazz) {
		super();
		this.setClazz(clazz);
	}
	public <T extends NAOException> NAOException(Class<T> clazz, String message) {
		super(message);
		this.setClazz(clazz);
	}
	public <T extends NAOException> NAOException(Class<T> clazz, Throwable cause) {
		super(cause);
		this.setClazz(clazz);
	}
	public <T extends NAOException> NAOException(Class<T> clazz, String message, Throwable cause) {
		super(message, cause);
		this.setClazz(clazz);
	}
	public <T extends NAOException> NAOException(Class<T> clazz, String message, Throwable cause, Boolean enableSuppresion, Boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);
		this.setClazz(clazz);
	}
	public <T extends NAOException> NAOException(Class<T> clazz, Message detailMessage) {
		this(clazz);
		this.setDetailMessage(detailMessage);
	}
	public <T extends NAOException> NAOException(Class<T> clazz, Message detailMessage, String message) {
		this(clazz, message);
		this.setDetailMessage(detailMessage);
	}
	public <T extends NAOException> NAOException(Class<T> clazz, Message detailMessage, Throwable cause) {
		this(clazz, cause);
		this.setDetailMessage(detailMessage);
	}
	public <T extends NAOException> NAOException(Class<T> clazz, Message detailMessage, String message, Throwable cause) {
		this(clazz, message, cause);
		this.setDetailMessage(detailMessage);
	}
	public <T extends NAOException> NAOException(Class<T> clazz, Message detailMessage, String message, Throwable cause, Boolean enableSuppresion, Boolean writableStackTrace) {
		this(clazz, message, cause, enableSuppresion, writableStackTrace);
		this.setDetailMessage(detailMessage);
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
	
	
	public Message toMessage() {
		return new Message(this);
	}
}
