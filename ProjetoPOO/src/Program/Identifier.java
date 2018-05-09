/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.UUID;

/**
 *
 * @author AndreLaptop
 */
public class Identifier {
    
    private final UUID identifier;
    
    public Identifier() {
        identifier = UUID.randomUUID();
    }
    
    public UUID getIdentifier(){
        return identifier;
    }
    
    public void printIdentifer() {
        System.out.println(identifier.toString());
    }
}
