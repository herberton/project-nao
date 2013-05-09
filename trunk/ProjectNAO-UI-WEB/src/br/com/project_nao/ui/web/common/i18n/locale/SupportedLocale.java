package br.com.project_nao.ui.web.common.i18n.locale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import org.apache.log4j.Logger;

import br.com.project_nao.ui.web.common.i18n.locale.enumerator.ELanguage;

public class SupportedLocale implements Serializable {
	
	private static final long serialVersionUID = 2279056191574387202L;

	private static Logger logger = Logger.getLogger(SupportedLocale.class);
	
	private ELanguage eLanguage;
	private String textlanguage;
	private String iconName;
	private Locale locale;

	public SupportedLocale(ELanguage eLanguage) { 
		this.setLanguage(eLanguage); 
	}

	public String getTextlanguage() {
		return textlanguage;
	}
	public void setFullTextlanguage(String fullTextlanguage) {
		this.textlanguage = fullTextlanguage;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String imgLanguage) {
		this.iconName = imgLanguage;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public ELanguage getLanguage() {
		return eLanguage;
	}
	public void setLanguage(ELanguage eLanguage) {
		this.eLanguage = eLanguage == null ? ELanguage.pt_BR : eLanguage;

		switch (this.eLanguage) {
			case es_ES:
				this.setFullTextlanguage("Español - ES");
				this.setIconName("icoES.png");
				this.setLocale(new Locale("es", "ES"));
				break;
			case en_US:
				this.setFullTextlanguage("English - US");
				this.setIconName("icoUS.png");
				this.setLocale(Locale.US);
				break;
			default:
				this.setFullTextlanguage("Português - Brasil");
				this.setIconName("icoBR.png");
				this.setLocale(new Locale("pt_BR"));
				break;
		}
	}
	
	
	public static Collection<SupportedLocale> getSupportedLocalecCollection() {
		Collection<SupportedLocale> supportedLocales = new ArrayList<SupportedLocale>();
		supportedLocales.add(new SupportedLocale(ELanguage.pt_BR));
		supportedLocales.add(new SupportedLocale(ELanguage.en_US));
		supportedLocales.add(new SupportedLocale(ELanguage.es_ES));
		return supportedLocales;
	}
	public static SupportedLocale getInstence(ELanguage eLanguage) {
		return new SupportedLocale(eLanguage);
	}
	
	@Override
	public boolean equals(Object object) {
		try {
			return eLanguage.equals(((SupportedLocale) object).getLanguage());
		} catch (Exception e) {
			SupportedLocale.logger.error(e.getMessage(), e);
		}		
		return super.equals(object);
	}
	@Override
	public int hashCode() {
		return eLanguage != null ? eLanguage.toString().hashCode() : super.hashCode(); 
	}
}