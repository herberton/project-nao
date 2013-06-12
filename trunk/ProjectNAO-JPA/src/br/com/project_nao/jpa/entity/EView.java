package br.com.project_nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
public class EView extends AEntityND<EView> implements Serializable {

	
	private static final long serialVersionUID = 397738860925145388L;

	
	public EView() {
		super();
	}
}
