package entities;

import interfaces.Movimentacao;

public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String agencia, numeroConta;
    private Double saldo;

    public Conta() {}
    public Conta(Cliente cliente, String agencia, String numeroConta, Double saldo) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    @Override
    public boolean depositar(double valor) {
        if(valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(Conta conta, double valorDaTransferencia) {
        if(this.sacar(valorDaTransferencia)) {
            conta.depositar(valorDaTransferencia);
            return true;
        }
        return false;
    }

    @Override
    public boolean sacar(double valorDoSaque) {
        if(valorDoSaque <= this.getSaldo() && valorDoSaque > 0) {
            this.setSaldo(this.getSaldo() - valorDoSaque);
            return true;
        }
        return false;
    }
}
