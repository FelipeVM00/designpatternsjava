package isw.observer.impl.observers;

import java.util.Date;

import isw.observer.impl.ConfigurationManager;
import isw.observer.impl.IObserver;

public class DateFormatObserver implements IObserver{
	
	@Override
	public void notifyObserver(String command, Object source) {
		if(command.equals("defaultDateFormat")){
			ConfigurationManager conf = (ConfigurationManager)source;
			System.out.println("Observer ==> DateFormatObserver.dateFormatChange > "
					+ conf.getDefaultDateFormat().format(new Date()));
		}
	}
	
}
