package br.com.nao.ui.web.mb.page;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.nao.ui.web.mb.common.NAOMB;

@ViewScoped
@ManagedBean
public class LoginMB extends NAOMB<LoginMB> {

	private static final long serialVersionUID = -6188814102857690751L;

	public LoginMB() {
		super(LoginMB.class);
	}

	@Override
	public void init() { }

}