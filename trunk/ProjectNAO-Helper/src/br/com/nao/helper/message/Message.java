package br.com.nao.helper.message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.nao.helper.exception.common.NAOException;
import br.com.nao.helper.exception.common.NAOParametrizedException;

public class Message {
	
	private ESeverity severity;
	private String text;
	private Map<Integer, Object> argumentMap;
	private Message detail;
	
	public Message() {
		super();
	}
	public Message(ESeverity severity) {
		this();
		this.setSeverity(severity);
	}
	public Message(ESeverity severity, String text) {
		this(severity);
		this.setText(text);
	}
	public Message(ESeverity severity, String text, Map<Integer, Object> argumentMap) {
		this(severity, text);
		this.setArgumentMap(argumentMap);
	}
	public Message(ESeverity severity, String text, Map<Integer, Object> argumentMap, Message detail) {
		this(severity, text, argumentMap);
		this.setDetail(detail);
	}
	public Message(NAOException exception) {
		this();
		this.setSeverity(ESeverity.ERROR);
		this.setText(exception.getClazz().getSimpleName());
		if (exception instanceof NAOParametrizedException) {
			this.setArgumentMap(((NAOParametrizedException)exception).getArgumentMap());
		}
		this.setDetail(exception.getDetailMessage());
	}
	
	public ESeverity getSeverity() {
		return this.severity;
	}
	public void setSeverity(ESeverity severity) {
		this.severity = severity;
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
	public Message getDetail() {
		return this.detail;
	}
	public void setDetail(Message detail) {
		this.detail = detail;
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
