package br.com.nao.ui.web.mb.page.template.standard;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Getter;
import br.com.nao.ejb.sb.bo.crud.UserBORemote;
import br.com.nao.ui.web.mb.common.NAOMB;

@ViewScoped
@ManagedBean
public class StandardTemplateMB extends NAOMB<StandardTemplateMB> {

	private static final long serialVersionUID = -5865218374795064882L;

	
	@Getter
	@EJB
	private UserBORemote testBO;
	
	
	public StandardTemplateMB() {
		super(StandardTemplateMB.class);
	}
	
	@Override
	public void init() { 
		
		System.out.println(this.getTestBO().test("2222"));
		
	}
}
