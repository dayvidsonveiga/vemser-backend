package entities;

import interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao {

    private Double chequeEspecial;

    public ContaCorrente() {
    }
    public ContaCorrente(Cliente cliente, String agencia, String numeroConta, Double saldo, Double chequeEspecial) {
        super(cliente, agencia, numeroConta, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void imprimir() {
        this.getCliente().imprimirCliente();
        System.out.println("CONTA CORRENTE\nAgência: " + this.getAgencia()
                + "\nentities.Conta: " + this.getNumeroConta() + "\nSaldo: " + this.getSaldo()
                + "\nLimite de Cheque Especial: " + this.chequeEspecial + "\n");
        this.getCliente().imprimirContatos();
        this.getCliente().imprimirEnderecos();
        System.out.println("----------------------------------------------------");
    }

    @Override
    public boolean sacar(double valorDoSaque) {
        if(valorDoSaque <= this.retornarSaldoComChequeEspecial() && valorDoSaque > 0) {
            this.setSaldo(this.getSaldo() - valorDoSaque);
            return true;
        }
        return false;
    }

    public double retornarSaldoComChequeEspecial() {
        return this.getSaldo() + this.chequeEspecial;
    }
}
