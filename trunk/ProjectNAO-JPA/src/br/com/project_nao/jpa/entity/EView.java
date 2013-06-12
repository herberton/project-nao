package br.com.project_nao.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
public class EView extends AEntityND<EView> implements Serializable {

	private static final long serialVersionUID = 397738860925145388L;

	
	@OneToOne(mappedBy="view")
	private EItemMenu itemMenu;
	@ManyToOne
	private EView parentView;
	@OneToMany(mappedBy="parentView")
	private List<EView> childViewList;
	@OneToMany(mappedBy="view")
	private List<EFormulary> formularyList;
	
	
	public EView() {
		super();
	}
	
	
	public EItemMenu getItemMenu() {
		return itemMenu;
	}
	public void setItemMenu(EItemMenu itemMenu) {
		this.itemMenu = itemMenu;
	}
	public EView getParentView() {
		return parentView;
	}
	public void setParentView(EView parentView) {
		this.parentView = parentView;
	}
	public List<EView> getChildViewList() {
		return childViewList;
	}
	public void setChildViewList(List<EView> childViewList) {
		this.childViewList = childViewList;
	}
	public List<EFormulary> getFormularyList() {
		return formularyList;
	}
	public void setFormularyList(List<EFormulary> formularyList) {
		this.formularyList = formularyList;
	}
}
