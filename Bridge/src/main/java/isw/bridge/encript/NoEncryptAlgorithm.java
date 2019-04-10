package isw.bridge.encript;

public class NoEncryptAlgorithm implements IEncryptAlgorithm{
    @Override
    public String encrypt(String message, String password) throws Exception {
        return message;
    }
}