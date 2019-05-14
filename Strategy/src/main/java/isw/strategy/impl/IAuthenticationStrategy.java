package isw.strategy.impl;

public interface IAuthenticationStrategy {
    
    public Principal authenticate(String userName, String passwrd);
}