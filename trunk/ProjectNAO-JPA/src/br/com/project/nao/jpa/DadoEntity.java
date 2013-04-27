package br.com.project.nao.jpa;

import javax.persistence.*;

import br.com.project.nao.jpa.common.NAOEntity;

@Entity
public class DadoEntity extends NAOEntity<DadoEntity> {
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private TipoEntity tipo;
	@OneToOne
	private MetadadoEntity metadado;
	@Column
	private Object valor;
	
	public DadoEntity() { super(); }
	
	public TipoEntity getTipo() {
		return tipo;
	}
	public void setTipo(TipoEntity tipo) {
		this.tipo = tipo;
	}
	public MetadadoEntity getMetadado() {
		return metadado;
	}
	public void setMetadado(MetadadoEntity metadado) {
		this.metadado = metadado;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}
}