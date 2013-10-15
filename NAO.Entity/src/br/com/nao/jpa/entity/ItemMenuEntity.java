package br.com.nao.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import br.com.nao.jpa.entity.common.NameDescriptionEntity;

@Entity
public class ItemMenuEntity extends NameDescriptionEntity<ItemMenuEntity> {

	private static final long serialVersionUID = 6987473803498918793L;

	
	@Getter
	@Setter
	@ManyToOne
	private MenuEntity menu;
	
	@Getter
	@Setter
	@OneToOne
	private ViewEntity view;
	
	
	public ItemMenuEntity() {
		super();
	}
   
}
