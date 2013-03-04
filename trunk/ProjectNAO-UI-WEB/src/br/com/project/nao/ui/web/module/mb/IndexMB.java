package br.com.project.nao.ui.web.module.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.project.nao.sb.bo.module.TesteBORemote;

@ManagedBean
@SessionScoped
public class IndexMB {
	
	@EJB
	private TesteBORemote bo;
	
	public IndexMB(){ super(); }
	
	public void teste(){
		System.err.println(bo.metodoTeste());
	}
	
}
