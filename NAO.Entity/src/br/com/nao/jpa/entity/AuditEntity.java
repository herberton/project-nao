package br.com.nao.jpa.entity;

import br.com.nao.annotation.Audited;
import br.com.nao.jpa.entity.common.NAOEntity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Audited(value=false)
@Entity
public class AuditEntity extends NAOEntity<AuditEntity> implements Serializable {
	
	private static final long serialVersionUID = 4444961675009133188L;
	
	@Getter
	@Setter
	@ManyToOne(optional=false, cascade={CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private UserEntity userCreation;
	
	@Getter
	@Setter
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar creationAt;
	
	@Getter
	@Setter
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private UserEntity userModification;
	
	@Getter
	@Setter
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modificationAt;
	
	public AuditEntity() {
		super();
	}
   
}