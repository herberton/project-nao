package br.com.project.nao.jpa;

import java.util.Collection;

import javax.persistence.*;

import br.com.project.nao.jpa.common.NAOEntity;

@Entity
public class TipoEntity extends NAOEntity<TipoEntity>{

	private static final long serialVersionUID = 1L;
	
	@Column
	private String descricao;
	@OneToMany
	private Collection<TipoEntity> pais;
	@OneToMany
	private Collection<TipoEntity> filhos;
	
	public TipoEntity() { super(); }
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Collection<TipoEntity> getPais() {
		return pais;
	}
	public void setPais(Collection<TipoEntity> pais) {
		this.pais = pais;
	}
	public Collection<TipoEntity> getFilhos() {
		return filhos;
	}
	public void setFilhos(Collection<TipoEntity> filhos) {
		this.filhos = filhos;
	}
}