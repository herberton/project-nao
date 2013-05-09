package br.com.project_nao.helper.exception.common;

import br.com.project_nao.helper.string.StringHelper;

public class ProjectNAOException extends Exception {

	private static final long serialVersionUID = 832901909136804451L;

private String detailPropertyKey;
	
	private Class<? extends ProjectNAOException> clazz;
	
	public ProjectNAOException(Class<? extends ProjectNAOException> clazz) {
		super();
		this.clazz = clazz;
	}
	
	public String getDetailPropertyKey() {
		return detailPropertyKey;
	}
	public void setDetailPropertyKey(String detailPropertyKey) {
		this.detailPropertyKey = detailPropertyKey;
	}
	public Class<? extends ProjectNAOException> getClazz() {
		return clazz;
	}
	protected void setClazz(Class<? extends ProjectNAOException> clazz) {
		this.clazz = clazz;
	}
	
	public String getExceptionKey() {
		return StringHelper.getDefaultPropertyNameFrom(this.getClazz());
	}
}
