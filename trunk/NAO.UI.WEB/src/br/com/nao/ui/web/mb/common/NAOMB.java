package br.com.nao.ui.web.mb.common;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;

import br.com.nao.ui.web.mb.session.SessionMB;

public abstract class NAOMB<T extends NAOMB<T>> implements Serializable {

	
	private static final long serialVersionUID = 3997670404725951348L;
	
	
	public abstract void init();
	
	
	private Class<T> clazz;
	
	
	public Class<T> getClazz() {
		return clazz;
	}
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	public String getCss() {
		return SessionMB.getInstance(SessionMB.class).getCss();
	}
	public Locale getLocale() {
		return SessionMB.getInstance(SessionMB.class).getLocale();
	}
	public String getTheme() {
		return SessionMB.getInstance(SessionMB.class).getTheme();
	}
	
	public NAOMB(Class<T> clazz){
		super();
		this.setClazz(clazz);
	}
	
	
	@PostConstruct
	public void preInit() {
		try {
			
			this.init();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public T getInstance() {
		return NAOMB.getInstance(this.getClazz());
	}
	
	
	
	public static <T extends NAOMB<T>> T getInstance(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
