package br.com.nao.exception;

import br.com.nao.helper.StringHelper;

public class NAOException extends Exception {

	private static final long serialVersionUID = -6010950482595141978L;

	private String detailPropertyKey;
	
	private Class<? extends NAOException> clazz;
	
	public NAOException(Class<? extends NAOException> clazz) {
		super();
		this.setClazz(clazz);
	}
	public NAOException(Class<? extends NAOException> clazz, String message) {
		super(message);
		this.setClazz(clazz);
	}
	public NAOException(Class<? extends NAOException> clazz, Throwable cause) {
		super(cause);
		this.setClazz(clazz);
	}
	public NAOException(Class<? extends NAOException> clazz, String message, Throwable cause) {
		super(message, cause);
		this.setClazz(clazz);
	}
	public NAOException(Class<? extends NAOException> clazz, String message, Throwable cause, Boolean enableSuppresion, Boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);
		this.setClazz(clazz);
	}
	
	public String getDetailPropertyKey() {
		return detailPropertyKey;
	}
	public void setDetailPropertyKey(String detailPropertyKey) {
		this.detailPropertyKey = detailPropertyKey;
	}
	public Class<? extends NAOException> getClazz() {
		return clazz;
	}
	protected void setClazz(Class<? extends NAOException> clazz) {
		this.clazz = clazz;
	}
	
	public String getExceptionKey() {
		return StringHelper.getDefaultPropertyNameFrom(this.getClazz());
	}

}
