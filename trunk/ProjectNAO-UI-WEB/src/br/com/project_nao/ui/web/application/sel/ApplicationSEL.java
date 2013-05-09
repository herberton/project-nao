package br.com.project_nao.ui.web.application.sel;

import java.io.Serializable;

import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

public class ApplicationSEL implements SystemEventListener, Serializable {

	private static final long serialVersionUID = 628334360190438177L;

	@Override
	public boolean isListenerForSource(Object source) {
		return (source instanceof Application);
	}
	
	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		if(event instanceof PostConstructApplicationEvent) {
			
		}
	}
}
