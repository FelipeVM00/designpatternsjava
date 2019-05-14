package isw.strategy.impl;

public class AuthenticationProvider {
    private IAuthenticationStrategy authenticationStrategy;
    
    public void setAuthenticationStrategy(IAuthenticationStrategy strategy){
        this.authenticationStrategy = strategy;
    }
    
    public Principal authenticate(String userName, String password){
        if(authenticationStrategy==null){
            throw new RuntimeException("Estrategia de autentificación no definida");
        }
        return authenticationStrategy.authenticate(userName, password);
    }
}