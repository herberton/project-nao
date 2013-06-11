package br.com.project_nao.jpa.entity;

import br.com.project_nao.jpa.entity.common.AEntity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class EView extends AEntity<EView> implements Serializable {

	private static final long serialVersionUID = 397738860925145388L;

	public EView() {
		super();
	}
   
}
