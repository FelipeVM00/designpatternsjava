package isw.observer.impl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class ConfigurationManager extends AbstractObservable{
	private SimpleDateFormat defaultDateFormat;
	private NumberFormat moneyFormat;

	private static ConfigurationManager configurationManager;

	private ConfigurationManager() {
	}

	public static ConfigurationManager getInstance() {
		if (configurationManager == null) {
			configurationManager = new ConfigurationManager();
		}
		return configurationManager;
		}
	public SimpleDateFormat getDefaultDateFormat() {
		return defaultDateFormat;
	}
	
	public void setDefaultDateFormat(SimpleDateFormat defaultDateFormat) {
		this.defaultDateFormat = defaultDateFormat;
		notifyAllObservers("defaultDateFormat", this);
		}
	
	public NumberFormat getMoneyFormat() {
		return moneyFormat;
	}
	
	public void setMoneyFormat(NumberFormat moneyFormat) {
		this.moneyFormat = moneyFormat;
		notifyAllObservers("moneyFormat", this);
	}

}
