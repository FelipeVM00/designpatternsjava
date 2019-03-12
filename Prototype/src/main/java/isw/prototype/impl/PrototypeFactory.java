package isw.prototype.impl;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {
    private static Map<String,IPrototype> prototypes = new HashMap<String, IPrototype>();
    
    public static IPrototype getPrototype(String prototypeName){
        return prototypes.get(prototypeName).deepClone();
    }
    
    public static void addPrototype(String prototypeName,IPrototype prototype){
        prototypes.put(prototypeName, prototype);
    }
}