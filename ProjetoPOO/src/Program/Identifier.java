
package Program;

import java.util.UUID;


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
