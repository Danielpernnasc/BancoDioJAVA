package domain;

public class contaCorrente {
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
 

    public void debitar(double valor){
        if(valor > 0  && valor <= this.saldo){
            this.saldo -= valor;
            System.out.println("Saque no valor de $" + valor +  " realizado com sucesso! Novo saldo: $" + this.saldo);
        } else {
            System.out.println(String.format(
                    "Saque de R$ %.2f realizado com sucesso! Novo saldo: R$ %.2f | Limite disponível: R$ %.2f",
                    valor, this.saldo, getLimiteDisponivel()));
        }

    }

    public void deposito(double valor){
        if(valor > 0 && valor <= this.saldo){
            this.saldo += valor;
            System.out.println("Depósito no valor de $" + valor +  " realizado com sucesso! Novo saldo: $" + this.saldo);
        } else {
            throw new IllegalArgumentException("Valor inválido para depósito.");
        }
    }

    public double render(double valor, int anos) {
        if (anos <= 0) anos = 1;
        double retorno = valor * (Math.pow(1.10, anos) - 1.0); // capitalização anual
        this.investimento += retorno;
        return retorno;
    }

    public double getLimiteDisponivel() {
        return (this.saldo < 0) ? (this.limite + this.saldo) : this.limite;
    }

    public void resgateInv(double valor) {
        if (valor > 0 && valor <= this.investimento) {
            this.investimento -= valor;
            this.saldo += valor;
            System.out.println(String.format(
                    "Resgate de R$ %.2f do investimento realizado! Saldo: R$ %.2f | Investimento restante: R$ %.2f",
                    valor, this.saldo, this.investimento));
        } else {
            if (valor <= 0)
                throw new IllegalArgumentException("Valor inválido para resgate.");
            if (valor > this.investimento)
                throw new IllegalArgumentException("Investimento insuficiente para resgate.");
        }

    }

    public void pagarCCredito(double valor) {
        if (valor > 0 && valor <= this.cartaoCredito) {
            this.cartaoCredito -= valor;
            System.out.println(String.format(
                    "Pagamento de R$ %.2f no cartão de crédito realizado! Saldo do cartão: R$ %.2f",
                    valor, this.cartaoCredito));
        } else {
            if (valor <= 0)
                throw new IllegalArgumentException("Valor inválido para pagamento.");
            if (valor > this.cartaoCredito)
                throw new IllegalArgumentException("Saldo insuficiente no cartão de crédito para pagamento.");
        }

    }
 


    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    private double getInvestimento(double investimento) {
        return investimento;
    }
    private void setInvestimento(int investimento) {
        this.investimento = investimento;
    }
    private double getLimite() {
        return limite;
    }
    private void setLimite(double limite) {
        this.limite = limite;
    }
    private double getCartaoCredito() {
        return cartaoCredito;
    }
    private void setCartaoCredito(double cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

}
