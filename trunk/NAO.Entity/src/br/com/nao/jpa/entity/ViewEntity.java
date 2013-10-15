package br.com.nao.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import br.com.nao.jpa.entity.common.NameDescriptionEntity;

@Entity
public class ViewEntity extends NameDescriptionEntity<ViewEntity> {

	
	private static final long serialVersionUID = 834266912265696518L;

	@Getter
	@Setter
	@OneToOne(mappedBy="view")
	private ItemMenuEntity itemMenu;
	
	@Getter
	@Setter
	@OneToMany(mappedBy="view")
	private List<PermissionEntity> permissionList;
	
	public ViewEntity() {
		super();
	}
   
}
