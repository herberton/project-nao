package br.com.project_nao.jpa.entity.common;

import br.com.project_nao.jpa.entity.common.AEntity;
import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
public abstract class AEntityN<T extends AEntityN<T>> extends AEntity<T> implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Column
	private String name;
	
	
	public AEntityN() {
		super();
	}
	public AEntityN(String name) {
		this();
		this.setName(name);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
