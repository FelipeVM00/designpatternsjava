package isw.proxy;

import isw.proxy.impl.IProcessEjecutor;
import isw.proxy.impl.ServiceFactory;

public class ProxyMain {
	public static void main(String[] args) {
		String user = "pepe_perez";
		String password = "1234";
		int process = 1;
		IProcessEjecutor processEjecutor = ServiceFactory.createProcessEjecutor();
		try {
			processEjecutor.ejecuteProcess(process, user, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
