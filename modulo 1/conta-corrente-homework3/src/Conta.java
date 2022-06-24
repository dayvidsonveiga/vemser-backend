public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private Double saldo;

    public Conta(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Boolean sacar(double valor) {
        if (this.getSaldo() >= valor && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque de R$ " + valor + ".\n Seu saldo é insuficiente: R$ " + this.getSaldo());
            return false;
        }

    }

    public Boolean depositar(double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        } else {
            System.out.println("O valor de depósito deve ser maior que 0.");
            return false;
        }
    }

    public Boolean transferir(Conta conta, double valor) {
        if (this.sacar(valor)) {
            return conta.depositar(valor);
        } else {
            return false;
        }

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
