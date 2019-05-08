package isw.observer.impl.observers;

import isw.observer.impl.ConfigurationManager;
import isw.observer.impl.IObserver;

public class MoneyFormatObserver implements IObserver{
	
	@Override
	public void notifyObserver(String command, Object source) {
		if(command.equals("moneyFormat")){
			ConfigurationManager conf = (ConfigurationManager)source;
			System.out.println("Observer ==> MoneyFormatObserver.moneyFormatChange > "
				+ conf.getMoneyFormat().format(1.11));
		}
	}

}
