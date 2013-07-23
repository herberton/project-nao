package br.com.nao.helper.exception;

import br.com.nao.helper.exception.common.NAOParametrizedException;
import br.com.nao.helper.message.Message;

public class I18NNotFoundException extends NAOParametrizedException {
	
	private static final long serialVersionUID = -3489403855901204604L;
	

	public I18NNotFoundException(String i18n) {
		super(I18NNotFoundException.class);
		this.setI18N(i18n);
	}
	public I18NNotFoundException(String i18n, Message detailMessage) {
		super(I18NNotFoundException.class, detailMessage);
		this.setI18N(i18n);
	}
	public I18NNotFoundException(Throwable cause, String i18n) {
		super(cause, I18NNotFoundException.class);
		this.setI18N(i18n);
	}
	public I18NNotFoundException(Throwable cause, String i18n, Message detailMessage) {
		super(cause, I18NNotFoundException.class, detailMessage);
		this.setI18N(i18n);
	}
	
	
	public String getI18N() {
		return super.getArgument(0).toString();
	}
	private void setI18N(String i18n) {
		super.putArgument(0, i18n);
	}
}
