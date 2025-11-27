import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Cliente cliente;
    private Agencia agencia;
    private double valorConta;

    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double valor) {

        this.cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this.agencia = new Agencia(numAgencia, numConta, gerente);
        this.valorConta = valor;
        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    private void atualizarSaldo(char tipo, int valor) {

        if (tipo == 'd')
            this.valorConta += valor;
        else if(tipo == 's')
            this.valorConta -= valor;
    }

    public void realizarOperacao(char tipo, int valor) {

        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);

        this.atualizarSaldo(tipo, valor);
    }

    private String imprimeDadosExtrato() {

        String dadosExtrato = "";
        for(Operacao op : this.operacoes) {
            dadosExtrato += op.toString() + "\n";
        }
        
        return dadosExtrato;
    }

    public String toString() {

        String dadosCliente = this.cliente.toString();

        String dadosConta = String.format("%s\nSaldo: %.2f",
            this.agencia.toString(),this.valorConta);

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosConta +
                "\n\n" +
                "-----EXTRATO-----\n" +
                this.imprimeDadosExtrato() +
                "\n";
    }
}
