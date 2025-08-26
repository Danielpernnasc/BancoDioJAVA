package banco;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class banco {

    public int agencia;
    private final List<Integer> numerosContas;                  // lista imutável dos números (ex.: 1..5)
    private final Map<Integer, contaCorrente> contasPorNumero = new HashMap<>(); // número -> conta
    
    public banco(int agencia) {
        this.agencia = agencia;
        this.numerosContas = List.of(0001, 0002, 0003, 0004, 0005);
    }
    
    public banco(int agencia, List<Integer> numerosContas) {
            this.agencia = agencia;
            this.numerosContas = (numerosContas == null || numerosContas.isEmpty())
                    ? java.util.Arrays.asList(0001, 0002, 0003, 0004, 0005)
                    : java.util.List.copyOf(numerosContas);
        
        }



    public int getAgencia() {
        return agencia;
        
    }

    public List<Integer> getNumerosContas() {
        return numerosContas;
    }

    public int getNumConta(int index) {
        if (index < 0 || index >= numerosContas.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds for account numbers list.");
        }
        return numerosContas.get(index);
    }

    public boolean existeNumeroConta(int numero) {
        return numerosContas.contains(numero);
    }

    public void associarConta(int numero, contaCorrente conta) {
        if (!existeNumeroConta(numero)) {
            throw new IllegalArgumentException("Número de conta não pertence ao banco: " + numero);
        }
        contasPorNumero.put(numero, conta);
    }

    public contaCorrente getContaPorNumero(int numero) {
        return contasPorNumero.get(numero); // pode retornar null se não associada
    }

}
