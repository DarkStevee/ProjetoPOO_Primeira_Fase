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
    private String name;
    
    public Identifier(String name) {
        identifier = UUID.randomUUID();
        this.name = name;
    }
    
    public UUID getIdentifier(){
        return identifier;
    }
    
    public void printIdentifer() {
        System.out.println(identifier.toString());
    }
}
