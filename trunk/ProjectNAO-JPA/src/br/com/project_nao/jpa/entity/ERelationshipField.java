package br.com.project_nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class ERelationshipField extends EField implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	public ERelationshipField() {
		super();
	}
   
}