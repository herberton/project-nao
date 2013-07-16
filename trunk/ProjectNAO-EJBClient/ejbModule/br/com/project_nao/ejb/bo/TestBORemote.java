package br.com.project_nao.ejb.bo;

import javax.ejb.Remote;

@Remote
public interface TestBORemote {
	String ping();
}
