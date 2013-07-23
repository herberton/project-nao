package br.com.nao.ui.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.nao.ejb.bo.TestBORemote;

@ManagedBean
@ViewScoped
public class TestMB {

	@EJB
	private TestBORemote testBO;
	
	private String result;
	
	public TestMB() {
		
	}
	
	public void click() {
		this.setResult(testBO.ping());
	}
	
	public String getResult() {
		return this.result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
