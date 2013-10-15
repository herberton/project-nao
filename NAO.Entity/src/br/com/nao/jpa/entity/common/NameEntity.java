package br.com.nao.jpa.entity.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class NameEntity<T extends NameEntity<T>> extends NAOEntity<T> {

	private static final long serialVersionUID = -1528509804969712225L;

	@Getter
	@Setter
	@Column
	private String name;
	
	public NameEntity() {
		super();
	}
   
}
