import java.util.Map;

public class Operacao {

    private char tipo;
    private double valor;

    private static final Map<Character, String> mapTipos = Map.of(
            'd', "Depósito",
            's', "Saque"
    );

    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return Operacao.mapTipos.get(this.tipo);
    }

    public String toString() {
        return this.getTipo() + ":\t" + this.valor;
    }
}
