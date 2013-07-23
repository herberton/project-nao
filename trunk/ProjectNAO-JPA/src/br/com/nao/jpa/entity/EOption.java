package br.com.nao.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.nao.jpa.entity.common.AEntityND;

@Entity
public class EOption extends AEntityND<EOption> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="option")
	private List<EConfiguration> configurationList;
	
	public EOption() {
		super();
	}
   
	public List<EConfiguration> getConfigurationList() {
		return configurationList;
	}
	public void setConfigurationList(List<EConfiguration> configurationList) {
		this.configurationList = configurationList;
	}
}
