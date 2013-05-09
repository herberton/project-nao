package br.com.project_nao.ui.web.common.helper.jsf;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import br.com.project_nao.helper.exception.common.ProjectNAOException;
import br.com.project_nao.helper.string.StringHelper;

import com.sun.faces.component.visit.FullVisitContext;

public class JSFHelper implements Serializable {
	
	private static final long serialVersionUID = 5752811901404535296L;
	private static final Logger logger = Logger.getLogger(JSFHelper.class);
	
	public static String getDefaultParameters() {
		return "faces-redirect=true&windowId=false";
	}
	
	public static FacesContext getFacesContext() { 
		return FacesContext.getCurrentInstance(); 
	}
	public static Application getApplication() { 
		return JSFHelper.getFacesContext().getApplication(); 
	}
	public static NavigationHandler getNavigationHandler(){
		return JSFHelper.getApplication().getNavigationHandler();
	}
	public static void handleNavigation(String outcome){
		JSFHelper.handleNavigation(null, outcome);
	}
	public static void handleNavigation(String fromAction, String outcome){
		JSFHelper.getNavigationHandler().handleNavigation(JSFHelper.getFacesContext(), fromAction, outcome);
	}
	public static void handleNavigation(FacesContext facesContext, String fromAction, String outcome){
		facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, fromAction, outcome);
	}
	public static UIViewRoot getUIViewRoot(){ 
		return JSFHelper.getFacesContext().getViewRoot(); 
	}
	public static Locale getLocale(){ 
		return JSFHelper.getUIViewRoot().getLocale(); 
	}
	public static ExternalContext getExternalContext(){
		return JSFHelper.getFacesContext().getExternalContext();
	}
	public static ELContext getELContext(){
		return JSFHelper.getFacesContext().getELContext();
	}
	public static ExpressionFactory getExpressionFactory(){
		return JSFHelper.getApplication().getExpressionFactory();
	}
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest)JSFHelper.getExternalContext().getRequest();
	}
	
	public static MethodExpression createMethodExpression(String expression, Class<?> typeReturn, Class<?>[] typeParameters){
		return JSFHelper.getExpressionFactory().createMethodExpression(JSFHelper.getELContext(), expression, typeReturn, typeParameters);
	}
	
	public static void invalidateSession(){
		JSFHelper.getExternalContext().invalidateSession();
	}
	public static Map<String, Object> getSessionMap(){
		return JSFHelper.getExternalContext().getSessionMap();
	}
	public static void addSessionAttribute(Map<? extends String, ? extends Object> mapValues){
		JSFHelper.getSessionMap().putAll(mapValues);
	}
	public static void addSessionAttribute(String key, Object value){
		JSFHelper.getSessionMap().put(key, value);
	}
	public static void removeSessionAttribute(String key) {
		JSFHelper.getSessionMap().remove(key);
	}
	public static Object getSessionAtribute(String key){
		return JSFHelper.getSessionMap().get(key);
	}
	
	public static Map<String, Object> getApplicationMap(){
		return JSFHelper.getExternalContext().getApplicationMap();
	}
	public static void addApplicationAttribute(Map<? extends String, ? extends Object> mapValues){
		JSFHelper.getApplicationMap().putAll(mapValues);
	}
	public static void addApplicationAttribute(String key, Object value){
		JSFHelper.getApplicationMap().put(key, value);
	}
	public static void removeApplicationAttribute(String key) {
		JSFHelper.getApplicationMap().remove(key);
	}
	public static Object getApplicationAtribute(String key){
		return JSFHelper.getApplicationMap().get(key);
	}
	
	public static String getPropertiesFile(){
		return JSFHelper.class.getName().substring(0, JSFHelper.class.getName().lastIndexOf('.') + 1) + "application";
	}
	
	public static <T> String getManagedBeanExpression(Class<T> clazz) {
		return "#{" + StringHelper.getDefaultPropertyNameFrom(clazz) + "}";
	}
	@SafeVarargs
	public static <T extends ProjectNAOException> void addMessage(final T...exceptionArray){
		for (ProjectNAOException exception : exceptionArray) {
			JSFHelper.addMessage(FacesMessage.SEVERITY_ERROR, exception.getExceptionKey(), exception.getDetailPropertyKey());
		}
	}
	@SafeVarargs
	public static void addMessage(String clientId, ProjectNAOException...exceptionArray){
		for (ProjectNAOException exception : exceptionArray) {
			JSFHelper.addMessage(clientId, FacesMessage.SEVERITY_ERROR, exception.getExceptionKey(), exception.getDetailPropertyKey());
		}
	}
	public static void addMessage(Severity severity, String propertyKey) {
		JSFHelper.addMessage("", severity, propertyKey, "");
	}
	public static void addMessage(Severity severity, String propertyKey, String detailPropertyKey) {
		JSFHelper.addMessage("", severity, propertyKey, detailPropertyKey);
	}
	public static void addMessage(String clientId, Severity severity, String propertyKey, String detailPropertyKey) {
		FacesContext.getCurrentInstance().addMessage(clientId, JSFHelper.getFacesMessage(severity, propertyKey, detailPropertyKey));
	}
	public static FacesMessage getFacesMessage(Severity severity, String propertyKey) {
		return JSFHelper.getFacesMessage(severity, propertyKey, "");
	}
	public static FacesMessage getFacesMessage(Severity severity, String messagePropertyKey, String detailPropertyKey) {
		
		if (messagePropertyKey == null) { 
			messagePropertyKey = "null"; 
		}
		
		try {
			return new FacesMessage(severity, JSFHelper.getMessage(messagePropertyKey), JSFHelper.getMessage(detailPropertyKey));
		} catch (Exception e) {
			JSFHelper.logger.error(e.getMessage(), e);
		}
		
		return null;
	}
	public static String getMessage(String messageKey) {
		
		if (messageKey == null || messageKey.trim().isEmpty()) {
			return "";
		}
		
		try {
			return ResourceBundleHelper.getMessageBundle(JSFHelper.getPropertiesFile(), JSFHelper.getLocale(), messageKey);
		} catch (Exception e) {
			JSFHelper.logger.error(e.getMessage(), e);
		}
		
		return "";
	}
	
	public static void visitTree(VisitContext visitContext, VisitCallback visitCallback){
		JSFHelper.getUIViewRoot().visitTree(visitContext, visitCallback);
	}
	public static UIComponent findComponent(final String id) {
		
		final UIComponent[] found = new UIComponent[1];
		
	    JSFHelper
	    	.visitTree(
	    		new FullVisitContext(JSFHelper.getFacesContext()), 
				new VisitCallback() {     
			        @Override
			        public VisitResult visit(VisitContext context, UIComponent component) {
			            if(component.getId().equals(id)){
			                found[0] = component;
			                return VisitResult.COMPLETE;
			            }
			            return VisitResult.ACCEPT;              
			        }
    			}
    		);
	    
	    return found[0];
	}
	
	public static TreeNode newDefaultTreeNode(Object data){
		return JSFHelper.newDefaultTreeNode(null, data, null, true);
	}
	public static TreeNode newDefaultTreeNode(String type, Object data) {
		return JSFHelper.newDefaultTreeNode(type, data, null, true);
	}
	public static TreeNode newDefaultTreeNode(String type, Object data, TreeNode parent) {
		return JSFHelper.newDefaultTreeNode(type, data, parent, true);
	}
	public static TreeNode newDefaultTreeNode(String type, Object data, TreeNode parent, boolean expanded) {
		TreeNode root = new DefaultTreeNode(type, data, parent);
		root.setExpanded(expanded);
		return root;
	}

		
}
