package client;



import banco.contaCorrente;

public class movimento {


    contaCorrente saldo = new contaCorrente(1000, 5000, 2000, 1500);
    public void sacar(double valor){
        this.saldo.debitar(valor);
    }

  

    public void depositar(double valor){
        this.saldo.deposito(valor);
        
    }

    public void rendimento(double valor, int anos) {
        int a = (anos <= 0) ? 1 : anos;
        if (a <= 0) a = 1; // garante mínimo de 1 ano
        double ganho = this.saldo.render(valor, 1);
        System.out.printf("Rendimento (%d ano(s)): R$ %.2f%n", 1, ganho);
    }


    public void limiteDisp(){
        double disp = this.saldo.getLimiteDisponivel(0.0); // Pass a default value or appropriate argument
        System.out.printf("Limite disponível: R$ %.2f%n", disp);
    }
 
    public void resgateValor(double valor){
        this.saldo.resgateInv(valor);
    }

    public void pagarBoleto(double valor){
        this.saldo.pagarCCredito(valor);
    }

  

}
