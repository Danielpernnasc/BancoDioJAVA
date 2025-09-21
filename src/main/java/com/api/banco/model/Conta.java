package banco.model;

public interface Conta {
    void debitar(double valor);

    void deposito(double valor);

    double render(double valor, int anos);

    double getSaldo();

    double getInvestimento();

    double getLimiteDisponivel();

    double resgateInv(double valor);

    double pagarCCredito(double valor);

    double getLimite();

    double getCartaoCredito();
}