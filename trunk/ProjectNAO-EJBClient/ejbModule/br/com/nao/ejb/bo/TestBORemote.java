package br.com.nao.ejb.bo;

import javax.ejb.Remote;

@Remote
public interface TestBORemote {
	String ping();
}
