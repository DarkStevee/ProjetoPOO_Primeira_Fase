/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.HashMap;
/**
 *
 * @author AndreLaptop
 */
public class Wifi {
    private HashMap<Identifier,Identifier> connections;
    
    public Wifi() {
        connections = new HashMap<>();
    }
    
    public void addConnection(Identifier identifier1, Identifier identifier2) throws NullPointerException {
        if(identifier1 == null || identifier2 == null) {
            throw new NullPointerException("One of the identifiers is null");
        }
        
        connections.put(identifier1, identifier2);
    }
    
    public boolean isPared(Identifier identifer) {
        connections.containsKey(identifer);
    }
}
