package br.com.project_nao.helper.exception.common;

import java.util.Map;

import br.com.project_nao.helper.message.Message;

public class NAOParametrizedException extends NAOException {
	
	private static final long serialVersionUID = -781810048211007751L;
	
	
	private Map<Integer, Object> argumentMap;
	
	
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz) {
		super(clazz);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, String message) {
		super(clazz, message);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Throwable cause) {
		super(clazz, cause);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, String message, Throwable cause) {
		super(clazz, message, cause);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, String message, Throwable cause, Boolean enableSuppresion, Boolean writableStackTrace) {
		super(clazz, message, cause, enableSuppresion, writableStackTrace);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Message detailMessage) {
		super(clazz, detailMessage);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Message detailMessage, String message) {
		super(clazz, detailMessage, message);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Message detailMessage, Throwable cause) {
		super(clazz, detailMessage, cause);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Message detailMessage, String message, Throwable cause) {
		super(clazz, detailMessage, message, cause);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Message detailMessage, String message, Throwable cause, Boolean enableSuppresion, Boolean writableStackTrace) {
		super(clazz, detailMessage, message, cause, enableSuppresion, writableStackTrace);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Message detailMessage, Map<Integer, Object> argumentMap) {
		super(clazz, detailMessage);
		this.setArgumentMap(argumentMap);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Message detailMessage, Map<Integer, Object> argumentMap, String message) {
		super(clazz, detailMessage, message);
		this.setArgumentMap(argumentMap);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Message detailMessage, Map<Integer, Object> argumentMap, Throwable cause) {
		super(clazz, detailMessage, cause);
		this.setArgumentMap(argumentMap);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Message detailMessage, Map<Integer, Object> argumentMap, String message, Throwable cause) {
		super(clazz, detailMessage, message, cause);
		this.setArgumentMap(argumentMap);
	}
	public <T extends NAOParametrizedException> NAOParametrizedException(Class<T> clazz, Message detailMessage, Map<Integer, Object> argumentMap, String message, Throwable cause, Boolean enableSuppresion, Boolean writableStackTrace) {
		super(clazz, detailMessage, message, cause, enableSuppresion, writableStackTrace);
		this.setArgumentMap(argumentMap);
	}
	

	public Map<Integer, Object> getArgumentMap() {
		return this.argumentMap;
	}
	public void setArgumentMap(Map<Integer, Object> argumentMap) {
		this.argumentMap = argumentMap;
	}
}
