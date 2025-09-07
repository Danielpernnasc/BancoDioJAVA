package banco;

import banco.model.Conta;

public class contaCorrente implements Conta {
    public double saldo;
    public double investimento;
    public double limite;
    public double cartaoCredito;

    public contaCorrente(double saldo, double investimento, double limite, double cartaoCredito) {
        this.saldo = saldo;
        this.investimento = investimento;
        this.limite = limite;
        this.cartaoCredito = cartaoCredito;

    }

    @Override
    public double getSaldo(double valor) {
        return this.saldo;
    }

    @Override
    public double getInvestimento(double valor) {
        return this.investimento;
    }

    @Override
    public double getLimiteDisponivel(double valor) {
        return (this.saldo < 0) ? (this.limite + this.saldo) : this.limite;
    }

 
    @Override
    public double debitar(double valor){
        if (valor <= 0)
            throw new IllegalArgumentException("Valor inválido para débito.");
        if (valor > (this.saldo + this.limite))
            throw new IllegalArgumentException("Sem saldo/limite suficiente.");
        this.saldo -= valor;
        return this.saldo; // Return the updated saldo
    } 

    

    @Override
    public double deposito(double valor){
        if(valor > 0){
            this.saldo += valor;
            System.out.println("Depósito no valor de $" + valor +  " realizado com sucesso! Novo saldo: $" + this.saldo);
            return this.saldo;
        } else {
            throw new IllegalArgumentException("Valor inválido para depósito.");
        }
    }

    @Override
    public double render(double valor, int anos) {
        if (anos <= 0) anos = 1;
        double retorno = valor * (Math.pow(1.10, anos) - 1.0); // capitalização anual
        this.investimento += retorno;
        return retorno;
    }

    @Override
    public double resgateInv(double valor) {
        if (valor > 0 && valor <= this.investimento) {
            this.investimento -= valor;
            this.saldo += valor;
            System.out.println(String.format(
                    "Resgate de R$ %.2f do investimento realizado! Saldo: R$ %.2f | Investimento restante: R$ %.2f",
                    valor, this.saldo, this.investimento));
            return valor; // Return the amount successfully withdrawn
        } else {
            if (valor <= 0)
                throw new IllegalArgumentException("Valor inválido para resgate.");
            if (valor > this.investimento)
                throw new IllegalArgumentException("Investimento insuficiente para resgate.");
        }
        return 0; // Return 0 as a fallback if no resgate is performed
    }

    @Override
    public double pagarCCredito(double valor) {
        if (valor > 0 && valor <= this.cartaoCredito) {
            this.cartaoCredito -= valor;
            System.out.println(String.format(
                    "Pagamento de R$ %.2f no cartão de crédito realizado! Saldo do cartão: R$ %.2f",
                    valor, this.cartaoCredito));
            return this.cartaoCredito;
        } else {
            if (valor <= 0)
                throw new IllegalArgumentException("Valor inválido para pagamento.");
            if (valor > this.cartaoCredito)
                throw new IllegalArgumentException("Saldo insuficiente no cartão de crédito para pagamento.");
        }
        return this.cartaoCredito; // Return the current cartaoCredito balance as a fallback
    }

    @Override
    public double getLimite(double valor) {
        return limite;
    }

    @Override
    public double getCartaoCredito(double valor) {
        return cartaoCredito;
    }

    @Override
    public String toString(){
        return String.format("Saldo: R$ %.2f | Investimento: R$ %.2f | Limite: R$ %.2f | Cartão de Crédito: R$ %.2f",
                this.saldo, this.investimento, this.limite, this.cartaoCredito);
    }
 


   

}
