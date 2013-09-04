package br.com.nao.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import br.com.nao.jpa.entity.common.NameDescriptionEntity;

@Entity
public class PermissionEntity extends NameDescriptionEntity<PermissionEntity> {

	private static final long serialVersionUID = -2804057138731381299L;
	
	
	@Getter
	@Setter
	@ManyToOne
	private ViewEntity view;
	
	
	public PermissionEntity() {
		super();
	}
}
