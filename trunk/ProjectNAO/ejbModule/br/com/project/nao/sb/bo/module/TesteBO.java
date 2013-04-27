package br.com.project.nao.sb.bo.module;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.project.nao.jpa.MetadadoEntity;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class TesteBO implements TesteBORemote {

	@PersistenceContext
	private EntityManager em;
	
    public TesteBO() { }

	@Override
	public String metodoTeste() {
		MetadadoEntity metadado = new MetadadoEntity();
		metadado.setDescricao("teste");
		em.persist(metadado);
		return metadado.getDescricao();
	}

}
