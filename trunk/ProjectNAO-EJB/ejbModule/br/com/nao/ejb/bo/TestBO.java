package br.com.nao.ejb.bo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.nao.ejb.bo.TestBORemote;

/**
 * Session Bean implementation class TestBO
 */
@Stateless
@LocalBean
public class TestBO implements TestBORemote {

    /**
     * Default constructor. 
     */
    public TestBO() {
        
    }

	@Override
	public String ping() {
		return "pong!";
	}

}
