public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    public void imprimirContaCorrente() {
        System.out.println("Informações da conta: " +
                "Cliente: " + this.cliente.nome + "\n" +
                "Agência: " + this.agencia + "\n" +
                "Número da conta: " + this.numeroConta + "\n" +
                "Saldo: " + this.saldo + "\n");
    }

    public boolean sacar(double valor) {
        if (this.saldo + this.chequeEspecial >= valor && valor > 0) {
            this.saldo -= valor;
            System.out.println("Saque efetuado com sucesso.\n Saldo atual: " + this.saldo);
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque.\n Saldo insuficiente.");
            return false;
        }

    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito efetuado com sucesso.\n Saldo atual: " + this.saldo);
            return true;
        } else {
            System.out.println("O valor de depósito deve ser maior que 0.");
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial() {
        System.out.println("Seu saldo é de: R$ " + this.saldo);
        System.out.println("Seu cheque especial é de: R$ " + this.chequeEspecial);
        double saldoTotal = this.saldo + this.chequeEspecial;
        System.out.println("Saldo total disponível é de: R$ " + saldoTotal);
        return (this.saldo + this.chequeEspecial);
    }

    public boolean transferir(ContaCorrente conta, double valor) {
        if (this.saldo + this.chequeEspecial >= valor && valor > 0) {
            this.saldo -= valor;
            conta.saldo += valor;
            System.out.println("Transferência realizado com sucesso.\n Saldo atual: " + this.saldo);
            return true;
        } else {
            System.out.println("Não foi possível realizar a transferência.\n Saldo insuficiente.");
            return false;
        }

    }

}
