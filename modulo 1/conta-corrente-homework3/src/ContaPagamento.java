public class ContaPagamento extends Conta implements Impressao {
    static Double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public Boolean sacar(double valor) {
        if (this.getSaldo() >= (valor + TAXA_SAQUE) && valor > 0) {
            this.setSaldo(this.getSaldo() - (valor + TAXA_SAQUE));
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque de R$ " + valor + ".\n Seu saldo é insuficiente: R$ " + this.getSaldo());
            return false;
        }
    }

    @Override
    public Boolean transferir(Conta conta, double valor) {
        if (valor <= this.getSaldo() && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
            return conta.depositar(valor);
        } else {
            return false;
        }

    }

    @Override
    public void imprimir() {
        System.out.println("Informações da conta: \n" +
                "Tipo: Conta Pagamento \n" +
                "Cliente: " + this.getCliente().getNome() + "\n" +
                "Agência: " + this.getAgencia() + "\n" +
                "Número da conta: " + this.getNumeroConta() + "\n" +
                "Saldo: R$ " + this.getSaldo() + "\n");
    }
}
