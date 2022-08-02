import entities.*;

public class Main {
    public static void main(String[] args) {

        Contato jeanContato1 = new Contato(1, "Disponível das 18h as 21h", "11948718672");
        Contato jeanContato2 = new Contato(2, "Disponível das 9h as 17h", "1133334444");
        Endereco jeanEndereco1 = new Endereco(1, 40, "Rua das Orquídeas",
                "Apartamento 15", "01410030", "São Paulo", "São Paulo", "Brasil");
        Endereco jeanEndereco2 = new Endereco(2, 1559, "Rua das Máquinas",
                "17° Andar", "05205040", "São Paulo", "São Paulo", "Brasil");
        Cliente jean = new Cliente("Jean", "69061807034", jeanContato1,
                null, jeanEndereco1, null);

        ContaCorrente contaJean = new ContaCorrente(jean, "1010", "1101", 5000.0, 200.0);
        ContaPagamento contaPagamentoJean = new ContaPagamento(jean, "1010", "1101-1", 25000.0);


        Contato heleniceContato1 = new Contato(1, "Disponível das 17h as 21h", "11999995555");
        Contato heleniceContato2 = new Contato(2, "Disponível das 8h as 16h", "1155553322");
        Endereco heleniceEndereco1 = new Endereco(1, 115, "Rua das Rosas",
                "Apartamento 45", "03447110", "São Paulo", "São Paulo", "Brasil");
        Endereco heleniceEndereco2 = new Endereco(2, 1559, "Rua das Máquinas",
                "35° Andar", "05205040", "São Paulo", "São Paulo", "Brasil");
        Cliente helenice = new Cliente("Helenice Accioly", "73150576091", heleniceContato1,
                heleniceContato2, heleniceEndereco1, heleniceEndereco2);
        ContaPoupanca contaHelenice = new ContaPoupanca(helenice, "1010", "2202", 200000.0);


        //TESTES entities.ContaCorrente:
        System.out.println("TESTES: \n");

        //Conferindo o estado das contas:
        contaJean.imprimir();
        contaPagamentoJean.imprimir();
        System.out.println();
        contaHelenice.imprimir();

        //Transferindo de entities.Conta Corrente para entities.Conta Poupança e entities.Conta Pagamento
        System.out.println("Transferindo 500 de entities.Conta Corrente para entities.Conta Poupança e entities.Conta Pagamento");
        contaJean.transferir(contaHelenice, 500);
        contaJean.transferir(contaPagamentoJean, 500);
        System.out.println("Saldo CC Jean: " + contaJean.getSaldo());
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());
        System.out.println("Saldo CPgto Jean: " + contaPagamentoJean.getSaldo());
        System.out.println("Transferencia inválida: " + contaJean.transferir(contaPagamentoJean,1500000.0) + "\n");

        //Transferindo 500 de entities.Conta Poupança para entities.Conta Corrente e entities.Conta Pagamento
        System.out.println("Transferindo 500 de entities.Conta Poupança para entities.Conta Corrente e entities.Conta Pagamento");
        contaHelenice.transferir(contaJean, 500);
        contaHelenice.transferir(contaPagamentoJean, 500);
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());
        System.out.println("Saldo CC Jean: " + contaJean.getSaldo());
        System.out.println("Saldo CPgto Jean: " + contaPagamentoJean.getSaldo());
        System.out.println("Transferencia inválida: " + contaHelenice.transferir(contaJean,-1500.0) + "\n");

        //Transferindo 1000 de entities.Conta Pagamento para entities.Conta Corrente e entities.Conta Poupança
        System.out.println("Transferindo 1000 de entities.Conta Pagamento para entities.Conta Corrente e entities.Conta Poupança");
        contaPagamentoJean.transferir(contaJean, 1000);
        contaPagamentoJean.transferir(contaHelenice, 1000);
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());
        System.out.println("Saldo CC Jean: " + contaJean.getSaldo());
        System.out.println("Saldo CPgto Jean: " + contaPagamentoJean.getSaldo());
        System.out.println("Transferencia inválida: " + contaPagamentoJean.transferir(contaHelenice,-1500.0) + "\n");

        //Saque
        System.out.println("Saque:");
        System.out.println("Saque 500 da CC: " + contaJean.sacar(500));
        System.out.println("CC inválido: " + contaJean.sacar(20000000));
        System.out.println("Saldo CC Jean: " + contaJean.getSaldo());
        System.out.println("Saque 500 da CP: " + contaHelenice.sacar(500));
        System.out.println("CP inválido: " + contaHelenice.sacar(20000000));
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());
        System.out.println("Saque 500 da CPgto: " + contaPagamentoJean.sacar(500));
        System.out.println("CPgto inválido: " + contaPagamentoJean.sacar(25000));
        System.out.println("Saldo CPgto Jean: " + contaPagamentoJean.getSaldo());

        //Deposito
        System.out.println("\nDepósito:");
        System.out.println("Depósito de 500 na CC: " + contaJean.depositar(500));
        System.out.println("CC inválido: " + contaJean.depositar(-2000));
        System.out.println("Saldo CC Jean: " + contaJean.getSaldo());
        System.out.println("Depósito de 500 na CP: " + contaHelenice.depositar(500));
        System.out.println("CP inválido: " + contaHelenice.depositar(-20000000));
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());
        System.out.println("Depósito de 500 na CPgto: " + contaPagamentoJean.depositar(500));
        System.out.println("CPgto inválido: " + contaPagamentoJean.depositar(-2000));
        System.out.println("Saldo CPgto Jean: " + contaPagamentoJean.getSaldo());

        //Teste de alteração do Cheque Especial:
        System.out.println("\nTeste de alteração do Cheque Especial");
        System.out.println("Saldo com Cheque Especial: " + contaJean.retornarSaldoComChequeEspecial());
        contaJean.setChequeEspecial(0.0);
        System.out.println("Após alterar Cheque Especial para 0: " + contaJean.retornarSaldoComChequeEspecial());

        //Creditando taxa na entities.Conta Poupança:
        System.out.println("\nCreditando taxa na entities.Conta Poupança:");
        System.out.println("Saldo CP Helenice: " + contaHelenice.getSaldo());
        contaHelenice.creditarTaxa();
        System.out.println("Saldo após creditar taxa: " + contaHelenice.getSaldo());
    }
}
