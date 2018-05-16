package Program;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Identifer, classe que gera um UUID random que sera usado pelo wifi
 *
 */
public class Identifier implements Serializable{

    private final UUID identifier;

    public Identifier(String name) {
        identifier = UUID.randomUUID();
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void printIdentifer() {
        System.out.println(identifier.toString());
    }
}
