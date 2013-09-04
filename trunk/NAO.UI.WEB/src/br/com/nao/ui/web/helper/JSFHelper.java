package br.com.nao.ui.web.helper;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.nao.enumerator.Language;

public class JSFHelper implements Serializable {

	private static final long serialVersionUID = -835929172494155533L;
	
	public static FacesContext getFacesContext() { 
		return FacesContext.getCurrentInstance();
	}
	public static Application getApplication() { 
		FacesContext facesContext = JSFHelper.getFacesContext();
		if (facesContext == null) {
			return null;
		}
		return facesContext.getApplication(); 
	}
	public static NavigationHandler getNavigationHandler(){
		Application application = JSFHelper.getApplication();
		if (application == null) {
			return null;
		}
		return application.getNavigationHandler();
	}
	public static UIViewRoot getUIViewRoot(){ 
		FacesContext facesContext = JSFHelper.getFacesContext();
		if (facesContext == null) {
			return null;
		}
		return facesContext.getViewRoot(); 
	}
	public static ExternalContext getExternalContext(){
		FacesContext facesContext = JSFHelper.getFacesContext();
		if (facesContext == null) {
			return null;
		}
		return facesContext.getExternalContext();
	}
	public static HttpServletRequest getHttpServletRequest() {
		ExternalContext externalContext = JSFHelper.getExternalContext();
		if (externalContext == null) {
			return null;
		}
		return (HttpServletRequest)externalContext.getRequest();
	}
	public static Locale getLocale(){ 
		UIViewRoot uiViewRoot = JSFHelper.getUIViewRoot();
		if (uiViewRoot == null) {
			return Language.getDefault().getLocale();
		}
		return uiViewRoot.getLocale(); 
	}
	
	public static void handleNavigation(String outcome){
		JSFHelper.handleNavigation(null, outcome);
	}
	public static void handleNavigation(String fromAction, String outcome){
		JSFHelper.handleNavigation(JSFHelper.getFacesContext(), fromAction, outcome);
	}
	public static void handleNavigation(FacesContext facesContext, String fromAction, String outcome){
		try {
			if (facesContext == null) {
				return;
			}
			NavigationHandler navigationHandler = JSFHelper.getNavigationHandler();
			if (navigationHandler == null) {
				return;
			} 
			navigationHandler.handleNavigation(facesContext, fromAction, outcome);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
