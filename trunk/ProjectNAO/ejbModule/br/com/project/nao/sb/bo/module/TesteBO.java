package br.com.project.nao.sb.bo.module;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TesteBO implements TesteBORemote {

    public TesteBO() { }

	@Override
	public String metodoTeste() {
		return "teste";
	}

}
