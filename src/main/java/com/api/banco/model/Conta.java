package banco.model;

public interface Conta {
    void debitar(double valor);

    void deposito(double valor);

    double render(double valor, int anos);

    double getSaldo();

    double getInvestimento();

    double getLimiteDisponivel();
}