package Program;

import java.util.ArrayList;

public class ConsolaCentral {
    private String nomeCliente;
    private int numeroCliente;
    private ArrayList<Divisao> divisoes;

    public ConsolaCentral(String nomeCliente, int numeroCliente) {
        this.nomeCliente = nomeCliente;
        this.numeroCliente = numeroCliente;
        divisoes = new ArrayList<>();
    }
}
