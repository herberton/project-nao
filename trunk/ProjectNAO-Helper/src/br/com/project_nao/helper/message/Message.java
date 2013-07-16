package br.com.project_nao.helper.message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.project_nao.helper.exception.common.NAOException;
import br.com.project_nao.helper.exception.common.NAOParametrizedException;

public class Message {
	
	private String text;
	private Map<Integer, Object> argumentMap;
	
	public Message() {
		super();
	}
	public Message(String text) {
		this();
		this.setText(text);
	}
	public Message(String text, Map<Integer, Object> argumentMap) {
		this(text);
		this.setArgumentMap(argumentMap);
	}
	public Message(NAOException exception) {
		this();
		this.setText(exception.getClazz().getSimpleName());
		if (exception instanceof NAOParametrizedException) {
			this.setArgumentMap(((NAOParametrizedException)exception).getArgumentMap());
		}
	}
	
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
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
	
	public int getArgumentCount() {
		return this.getArgumentMap().size();
	}
	
	public boolean haveArgument() {
		return !this.getArgumentMap().isEmpty();
	}
	
	public Object[] getArgumentArray() {
		
		List<Integer> positionList = new ArrayList<Integer>(this.getArgumentMap().keySet());
		
		Collections.sort(positionList);
		
		List<Object> parameterList = new ArrayList<Object>();
		
		for (Integer position : positionList) {
			
			Object argument = this.getArgument(position);
		
			if (this.isValidArgument(argument)) {
				
				parameterList.add(argument);
				
			}
			
		}
		
		return parameterList.toArray();
	}
}
