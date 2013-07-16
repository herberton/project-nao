package br.com.project_nao.ejb.bo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
