package br.com.nao.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import br.com.nao.jpa.entity.common.NameEntity;

@Entity
public class UserEntity extends NameEntity<UserEntity> {

	
	private static final long serialVersionUID = 4226577378191382053L;

	@Getter
	@Setter
	@ManyToMany
	private List<RoleEntity> roleList;
	
	public UserEntity() {
		super();
	}
   
}
