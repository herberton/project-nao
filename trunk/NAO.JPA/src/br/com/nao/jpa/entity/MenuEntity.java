package br.com.nao.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import br.com.nao.jpa.entity.common.NameDescriptionEntity;

@Entity
public class MenuEntity extends NameDescriptionEntity<MenuEntity> {

	private static final long serialVersionUID = -254966210404674046L;

	@Getter
	@Setter
	@OneToMany(mappedBy="menu")
	private List<ItemMenuEntity> itemMenuList;
	
	@Getter
	@Setter
	@ManyToOne
	private MenuEntity parent;
	
	@Getter
	@Setter
	@OneToMany(mappedBy="parent")
	private List<MenuEntity> childList;
	
	public MenuEntity() {
		super();
	}
}
