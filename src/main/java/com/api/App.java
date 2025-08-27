

import banco.banco;
import client.client;
import client.movimento;

public class App {
   public static void main(String[] args) throws Exception {
    movimento mov = new movimento();
    banco bank = new banco(1234); // use inteiros puros
    client cli = new client(bank, 0); // índice 0 -> conta 0001
    
    //Dados do cliente e sua conta antes de movimentar
    cli.setNome("Daniel Péricles do Nascimento");
    cli.setCpf(123456789);
    cli.setEmail("dpericles6@email.com");
    cli.clienteDados();


    //Movimentações na conta

    mov.sacar(100.0);
    mov.depositar(50.0);
    mov.rendimento(100.0, 1); 
    mov.limiteDisp(); // Ensure both arguments are provided
    mov.resgateValor(600.0);
    mov.pagarBoleto(1500.0);
    }
}
