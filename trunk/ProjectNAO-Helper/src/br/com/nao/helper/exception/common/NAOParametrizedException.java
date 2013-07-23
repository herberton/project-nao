package br.com.nao.helper.exception.common;

import java.util.HashMap;
import java.util.Map;

import br.com.nao.helper.message.Message;

public class NAOParametrizedException extends NAOException {
	
	private static final long serialVersionUID = -781810048211007751L;
	
	
	private Map<Integer, Object> argumentMap;
		
	
	public <T extends NAOException> NAOParametrizedException(Class<T> clazz) {
		super(clazz);
	}
	public <T extends NAOException> NAOParametrizedException(Class<T> clazz, Message detailMessage) {
		super(clazz, detailMessage);
	}
	
	public <T extends NAOException> NAOParametrizedException(Throwable cause, Class<T> clazz) {
		super(cause, clazz);
	}
	public <T extends NAOException> NAOParametrizedException(Throwable cause, Class<T> clazz, Message detailMessage) {
		super(cause, clazz, detailMessage);
	}
	
	public Object getArgument(Integer position) {
		
		if(!this.isValidPosition(position)) {
			return null;
		}
		
		return this.getArgumentMap().get(position);
	}
	public void putArgument(Integer position, Object argument) {
		
		if(!this.isValidPosition(position)) {
			return;
		}
		
		if(!this.isValidArgument(argument)) {
			return;
		}
		
		this.getArgumentMap().put(position, argument);
		
	}
	public void deleteArgument(Integer position) {

		if (!this.isValidPosition(position)) {
			return;
		}
		
		this.getArgumentMap().remove(position);
	}

	
	public boolean isValidPosition(Integer position) {
		
		if (position == null) {
			return false;
		}
		
		if (position < 0) {
			return false;
		}
		
		return this.getArgumentMap().containsKey(position);
	}
	public boolean isValidArgument(Object argument) {
		return argument != null;
	}
	
	
	public Map<Integer, Object> getArgumentMap() {
		if (this.argumentMap == null) {
			this.setArgumentMap(new HashMap<Integer, Object>());
		}
		return this.argumentMap;
	}
	public void setArgumentMap(Map<Integer, Object> argumentMap) {
		this.argumentMap = argumentMap;
	}
}
