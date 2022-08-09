package entities;

import interfaces.Impressao;

public class ContaPagamento extends Conta implements Impressao {
    static final double TAXA_SAQUE = 4.25;

    public ContaPagamento() {}
    public ContaPagamento(Cliente cliente, String agencia, String numeroConta, Double saldo) {
        super(cliente, agencia, numeroConta, saldo);
    }

    @Override
    public void imprimir() {
        this.getCliente().imprimirCliente();
        System.out.println("CONTA PAGAMENTO\nAgência: " + this.getAgencia()
                + "\nentities.Conta: " + this.getNumeroConta() + "\nSaldo: " + this.getSaldo()
                + "\n");
        this.getCliente().imprimirContatos();
        this.getCliente().imprimirEnderecos();
        System.out.println("----------------------------------------------------");
    }

    @Override
    public boolean sacar(double valorDoSaque) {
        if(this.getSaldo() > valorDoSaque + TAXA_SAQUE && valorDoSaque > 0){
            this.setSaldo(this.getSaldo() - valorDoSaque - TAXA_SAQUE);
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(Conta conta, double valorDaTransferencia) {
        if(valorDaTransferencia <= this.getSaldo() && valorDaTransferencia > 0) {
            this.setSaldo(this.getSaldo() - valorDaTransferencia);
            conta.depositar(valorDaTransferencia);
            return true;
        }
        return false;
    }
}
