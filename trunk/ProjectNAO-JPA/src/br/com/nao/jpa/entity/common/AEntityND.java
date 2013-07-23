package br.com.nao.jpa.entity.common;

import br.com.nao.jpa.entity.common.AEntityN;

import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
public abstract class AEntityND<T extends AEntityND<T>> extends AEntityN<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Column
	private String description;
	
	
	public AEntityND() {
		super();
	}
	public AEntityND(String name) {
		super(name);
	}
	public AEntityND(String name, String description) {
		this(name);
		this.setDescription(description);
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
