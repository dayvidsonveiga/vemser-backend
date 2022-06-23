public class ContaPoupanca extends Conta implements Impressao {
    static final Double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        this.setSaldo(this.getSaldo() + JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.println("Informações da conta: " +
                "Cliente: " + this.getCliente().getNome() + "\n" +
                "Agência: " + this.getAgencia() + "\n" +
                "Número da conta: " + this.getNumeroConta() + "\n" +
                "Saldo: R$ " + this.getSaldo() + "\n");
    }
}
