

public class Agencia {

    private int numAgencia;
    private int numConta;
    private String gerente;

    public Agencia(int numAgencia, int numConta, String gerente){
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.gerente = gerente;
    }

    public String toString(){
        return String.format("Ag.: %d\nConta: %d\nGerente: %s",
                this.numAgencia, this.numConta, this.gerente);
    }

}