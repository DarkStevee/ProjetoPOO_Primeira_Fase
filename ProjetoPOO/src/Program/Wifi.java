package Program;

import Exceptions.ParedException;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Wifi, representa o wifi e suas ligações
 *
 */
public class Wifi implements Serializable{

    /**
     * Os indentificadores são guardados em pares para poder assim ser validados
     */
    private HashMap<Identifier, Identifier> connections;
    private String password;

    public Wifi(String password) {
        connections = new HashMap<>();
        this.password = password;
    }

    /**
     * Metodo que adiciona os identificadores nas conexoes
     *
     * @param identifier1
     * @param identifier2
     * @throws NullPointerException
     * @throws ParedException
     */
    public void addConnection(Identifier identifier1, Identifier identifier2) throws NullPointerException, ParedException {
        if (identifier1 == null || identifier2 == null) {
            throw new NullPointerException("One of the identifiers is null");
        }
        if (isPared(identifier1) || isPared(identifier2)) {
            throw new ParedException("One of the identifiers is already pared");
        }
        connections.put(identifier1, identifier2);
    }

    /**
     * Metodo para validaçãp do indenficador
     *
     * @param identifier
     * @return um booleano caso sejam pares
     */
    public boolean isPared(Identifier identifier) {
        return connections.containsKey(identifier) || connections.containsValue(identifier);
    }
/**
 * 
 * @return - senha salva na classe
 */
    public String getPassword() {
        return password;
    }
/**
 * Seta a senha 
 * @param password 
 */
    public void setPassword(String password) {
        this.password = password;
    }
}
