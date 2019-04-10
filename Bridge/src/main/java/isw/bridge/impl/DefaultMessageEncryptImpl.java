package isw.bridge.impl;

import isw.bridge.encript.IEncryptAlgorithm;

public class DefaultMessageEncryptImpl implements IMessageEncrypt{
    private IEncryptAlgorithm encryptAlgorith;
    
    public DefaultMessageEncryptImpl(IEncryptAlgorithm encryptAlgorith){
        this.encryptAlgorith = encryptAlgorith;
    }
    
    @Override
    public String encryptMessage(String message, String password)throws Exception {
        return encryptAlgorith.encrypt(message, password);
    }
}