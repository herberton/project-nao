package br.com.project.nao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.project.nao.jpa.common.NAOEntity;


@Entity
public class MetadadoEntity extends NAOEntity<MetadadoEntity> {
	
	private static final long serialVersionUID = 1L;
	
	@Column
	private String descricao;
	@OneToOne
	private MetadadoEntity pai;
	@OneToOne
	private MetadadoEntity filho;
	@OneToOne
	private TipoEntity tipo;
	
	public MetadadoEntity() { super(); }
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public MetadadoEntity getPai() {
		return pai;
	}
	public MetadadoEntity getFilho() {
		return filho;
	}
	public void setFilho(MetadadoEntity filho) {
		this.filho = filho;
	}
	public void setPai(MetadadoEntity pai) {
		this.pai = pai;
	}
	public TipoEntity getTipo() {
		return tipo;
	}
	public void setTipo(TipoEntity tipo) {
		this.tipo = tipo;
	}
}