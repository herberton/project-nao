package br.com.nao.jpa.entity;

import br.com.nao.jpa.entity.common.AEntityND;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class EItemMenu extends AEntityND<EItemMenu> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private EMenu menu;
	@OneToOne
	private EView view;
	
	
	public EItemMenu() {
		super();
	}
   
	
	public EMenu getMenu() {
		return menu;
	}
	public void setMenu(EMenu menu) {
		this.menu = menu;
	}
	public EView getView() {
		return view;
	}
	public void setView(EView view) {
		this.view = view;
	}
}
