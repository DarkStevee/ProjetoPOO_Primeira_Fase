
package Program;

import Exceptions.ParedException;
import java.util.HashMap;

public class Wifi {
    private HashMap<Identifier,Identifier> connections;
    
    public Wifi() {
        connections = new HashMap<>();
    }
    
    public void addConnection(Identifier identifier1, Identifier identifier2) throws NullPointerException, ParedException {
        if(identifier1 == null || identifier2 == null) {
            throw new NullPointerException("One of the identifiers is null");
        }
        if(isPared(identifier1) || isPared(identifier2)) {
            throw new ParedException("One of the identifiers is already pared");
        }
        connections.put(identifier1, identifier2);
    }
    
    public boolean isPared(Identifier identifier) {
        return connections.containsKey(identifier) || connections.containsValue(identifier);
    }
}
