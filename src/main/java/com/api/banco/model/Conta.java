package banco.model;

public interface Conta {
    void debitar(double valor);

    void deposito(double valor);

    double render(double valor, int anos);

    double getSaldo(double valor);

    double getInvestimento(double valor);

    double getLimiteDisponivel(double valor);
    
    double resgateInv(double valor);

    double pagarCCredito(double valor);
}