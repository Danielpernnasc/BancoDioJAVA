package client;

import banco.banco;
import banco.contaCorrente;

public class client {
    private int numeroConta;
    public String nome;
    public int cpf;
    public String email;

    private final banco bank;
    private final contaCorrente conta = new contaCorrente(1000, 5000, 2000, 1500);

   
    public void cliente(String nome) {
        
        this.nome = nome;
        // this.cpf = cpf;
        // this.email = email;
        // this.conta = conta;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
        
    }     
    
    public client(banco bank, int indiceConta) {
        this.bank = bank;
        int numero = bank.getNumConta(indiceConta); // pega da lista do banco
        bank.associarConta(numero, this.conta); // associa no banco
        this.numeroConta = numero;
    }

    public void clienteDados(){ {
        System.out.println("Agência: " + bank.getAgencia());
        System.out.println("Conta Corrente: " + String.format("%04d", this.numeroConta));
        System.out.println("Client name: " + nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Email: " + this.email);
        System.out.println("Saldo: " + this.conta.saldo);
        System.out.println("Investimento: " + this.conta.investimento);
        System.out.println("Limite: " + this.conta.limite);
        System.out.println("Cartão de Crédito: " + this.conta.cartaoCredito);
    }

    }


}
