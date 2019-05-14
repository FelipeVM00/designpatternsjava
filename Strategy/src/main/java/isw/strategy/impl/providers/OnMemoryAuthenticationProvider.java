package isw.strategy.impl.providers;

import isw.strategy.impl.IAuthenticationStrategy;
import isw.strategy.impl.Principal;
import isw.strategy.util.OnMemoryDataBase;
import isw.strategy.util.User;

public class OnMemoryAuthenticationProvider implements IAuthenticationStrategy{

    @Override
    public Principal authenticate(String userName, String passwrd) {
        User user = OnMemoryDataBase.findUserByName(userName);
        if(user!=null && user.getPassword().equals(passwrd)){
            return new Principal(user.getUserName(), user.getRol());
        }
        
        return null;
    }
}