package isw.singleton;

public class SingletonMain {
	public static void main(String[] args) {
		
        ConfigurationSingleton singletonA = ConfigurationSingleton.getInstance();
        ConfigurationSingleton singletonB = ConfigurationSingleton.getInstance();
        
        System.out.println(singletonA);
        System.out.println(singletonB);
        System.out.println("Misma referencia ==> " + (singletonA == singletonB));
        
        singletonA.setAppName("Singleton Pattern");
        singletonB.setAppVersion("1.0x");
        
        System.out.println("SingletonA ==> " + singletonA);
        System.out.println("SingletonB ==> " + singletonB);
        
        singletonA = null;
        singletonB = null;
        
        singletonA = ConfigurationSingleton.getInstance();
        System.out.println("singletonA ==> " + singletonA);
    }
}
