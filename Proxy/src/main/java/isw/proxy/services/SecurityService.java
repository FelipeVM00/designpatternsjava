package isw.proxy.services;

public class SecurityService {
	public boolean authorization(String user,String password){
		if(user.equals("pepe_perez") && password.equals("1234")){
			System.out.println("Usuario " + user + " autorizado");
			return true;
		}else{
			System.out.println("Usuario " + user + " NO autorizado");
			return false;
		}
	}
}
