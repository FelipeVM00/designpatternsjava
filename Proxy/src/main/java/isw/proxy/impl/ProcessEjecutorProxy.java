package isw.proxy.impl;

import isw.proxy.services.AuditService;
import isw.proxy.services.SecurityService;

public class ProcessEjecutorProxy implements IProcessEjecutor{
	@Override
	public void ejecuteProcess(int idProcess,String user,String password)
	throws Exception {
		SecurityService securityService = new SecurityService();
		if(!securityService.authorization(user, password)){
			throw new Exception("El usuario '"+user
					+"' no tiene privilegios para ejecutar el proceso");
		}

		DefaultProcessEjecutor ejecutorProcess = new DefaultProcessEjecutor();
		ejecutorProcess.ejecuteProcess(idProcess, user, password);
		AuditService audit = new AuditService();
		audit.auditServiceUsed(user, DefaultProcessEjecutor.class.getName());
	}
}


