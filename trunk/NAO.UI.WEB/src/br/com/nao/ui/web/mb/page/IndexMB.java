package br.com.nao.ui.web.mb.page;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.nao.ui.web.mb.common.NAOMB;

@ViewScoped
@ManagedBean
public class IndexMB extends NAOMB<IndexMB> {

	private static final long serialVersionUID = -95650203654029480L;

	public IndexMB() {
		super(IndexMB.class);
	}

	@Override
	public void init() { }
	
	
}
