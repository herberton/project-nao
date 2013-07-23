package br.com.nao.jpa.entity;

import br.com.nao.jpa.entity.common.AEntityND;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class EFormulary extends AEntityND<EFormulary> implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	private EView view;
	@OneToMany(mappedBy="formulary")
	private List<EField> fieldList;
	
	
	public EFormulary() {
		super();
	}
   
	
	public EView getView() {
		return view;
	}
	public void setView(EView view) {
		this.view = view;
	}
	public List<EField> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<EField> fieldList) {
		this.fieldList = fieldList;
	}
}
