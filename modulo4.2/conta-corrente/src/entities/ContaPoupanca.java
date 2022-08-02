package entities;

import interfaces.Impressao;

public class ContaPoupanca extends Conta implements Impressao {
    static final Double JUROS_MENSAL = 1.01;

    public ContaPoupanca() {}
    public ContaPoupanca(Cliente cliente, String agencia, String numeroConta, Double saldo) {
        super(cliente, agencia, numeroConta, saldo);
    }

    public void creditarTaxa() {
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        this.getCliente().imprimirCliente();
        System.out.println("CONTA POUPANÇA\nAgência: " + this.getAgencia()
                + "\nentities.Conta: " + this.getNumeroConta() + "\nSaldo: " + this.getSaldo() + "\n");
        this.getCliente().imprimirContatos();
        this.getCliente().imprimirEnderecos();
        System.out.println("----------------------------------------------------");
    }
}
