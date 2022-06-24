public class ContaCorrente extends Conta implements Impressao {
    private Double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, Double saldo, Double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public Double retornarSaldoComChequeEspecial() {
        return (this.getSaldo() + this.chequeEspecial);
    }

    @Override
    public Boolean sacar(double valor) {
        if (this.retornarSaldoComChequeEspecial() >= valor && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque de R$ " + valor + ".\n Seu saldo é insuficiente: R$ " + this.getSaldo());
            return false;
        }

    }

    @Override
    public void imprimir() {
        System.out.println("Informações da conta: \n" +
                "Tipo: Conta Corrente \n" +
                "Cliente: " + this.getCliente().getNome() + "\n" +
                "Agência: " + this.getAgencia() + "\n" +
                "Número da conta: " + this.getNumeroConta() + "\n" +
                "Saldo: R$ " + this.getSaldo() + "\n");
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

}
