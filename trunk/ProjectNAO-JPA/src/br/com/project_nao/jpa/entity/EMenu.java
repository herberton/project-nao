package br.com.project_nao.jpa.entity;

import br.com.project_nao.jpa.entity.common.AEntityND;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class EMenu extends AEntityND<EMenu> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private EMenu parentMenu;
	@OneToMany(mappedBy="parentMenu")
	private List<EMenu> childMenuList;
	@OneToMany(mappedBy="menu")
	private List<EItemMenu> childItemMenuList;

	
	public EMenu() {
		super();
	}
	
	
	public EMenu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(EMenu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public List<EMenu> getChildMenuList() {
		return childMenuList;
	}
	public void setChildMenuList(List<EMenu> childMenuList) {
		this.childMenuList = childMenuList;
	}
	public List<EItemMenu> getChildItemMenuList() {
		return childItemMenuList;
	}
	public void setChildItemMenuList(List<EItemMenu> childItemMenuList) {
		this.childItemMenuList = childItemMenuList;
	}
}
