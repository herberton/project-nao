package br.com.project_nao.jpa.entity.common;

import br.com.project_nao.jpa.entity.common.AEntityND;
import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
public abstract class AEntityNDV<T extends AEntityNDV<T>> extends AEntityND<T> implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Column
	private String value;
	
	
	public AEntityNDV() {
		super();
	}
	public AEntityNDV(String name) {
		super(name);
	}
	public AEntityNDV(String name, String description) {
		super(name, description);
	}
	public AEntityNDV(String name, String description, String value) {
		this(name, description);
		this.setValue(value);
	}

	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
