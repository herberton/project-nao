package br.com.project_nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.project_nao.jpa.entity.common.AEntity;

@Entity
public class UserEntity extends AEntity<UserEntity> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private String login;
	@Column(nullable=false)
	private String password;
	
	
	public UserEntity() {
		super();
	}
   
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
