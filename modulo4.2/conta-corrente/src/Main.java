import entities.*;

public class Main {
    public static void main(String[] args) {

        Contato emillyContato1 = new Contato("Celular pessoal para emergencia.", "(27) 98595-7443", 1);
        Contato emillyContato2 = new Contato("Telefone comercial, disponivel em horarios comerciais.", "(27) 2998-7413", 2);
        ArrayList<Contato> emillyContatos = new ArrayList<>();
        Collections.addAll(emillyContatos, emillyContato1, emillyContato2);

        Endereco emillyEndereco1 = new Endereco(1, "Rua Narciso Menelli", 99,
                "Apartamento 15", "01410030", "São Paulo", "São Paulo", "Brasil");
        Endereco emillyEndereco2 = new Endereco(2, "Jardim Boa Vista", 80,
                "17° Andar", "05205040", "São Paulo", "São Paulo", "Brasil");
        ArrayList<Endereco> emillyEnderecos = new ArrayList<>();
        Collections.addAll(emillyEnderecos, emillyEndereco1, emillyEndereco2);

        Cliente emilly = new Cliente("Emilly", "69061807034", emillyContatos, emillyEnderecos);

        ContaCorrente contaEmillyCorrente = new ContaCorrente(emilly, "9001", "001", 1000.00, 500.00);
        ContaPagamento contaEmillyPagamento =new ContaPagamento(emilly, "1001", "003", 620.00);

        Contato miguelContato1 = new Contato("Celular pessoal para emergencia.", "(98) 98922-2838", 1);
        Contato miguelContato2 = new Contato("Telefone comercial, disponivel em horarios comerciais.", "(98) 2677-0296", 2);
        ArrayList<Contato> miguelContatos = new ArrayList<>();
        Collections.addAll(miguelContatos, miguelContato1, miguelContato2);

        Endereco miguelEndereco1 = new Endereco(1, "Travessa da Elca", 50, "Fátima", "65030-530", "São Luís", "MA", "Brasil");
        Endereco miguelEndereco2 = new Endereco(2, "Travessa", 17, "Bloco 3", "65030-530", "São Luís", "MA", "Brasil");
        ArrayList<Endereco> miguelEnderecos = new ArrayList<>();
        Collections.addAll(miguelEnderecos, miguelEndereco1, miguelEndereco2);

        Cliente miguel = new Cliente("Miguel", "18647896712", miguelContatos, miguelEnderecos);

        ContaPoupanca contaMiguel = new ContaPoupanca(miguel, "8001", "002", 100.00);

        //Iniciando Testes

        //Testes Conta Corrente
        System.out.println("--------------------------------------");
        contaEmillyCorrente.imprimir();
        System.out.println("--------------------------------------");
        System.out.println("Teste de saque da Conta Corrente com valor 200 válido: ");
        contaEmillyCorrente.sacar(200);
        System.out.println("Saldo: R$ " + contaEmillyCorrente.getSaldo());
        System.out.println("--------------------------------------");
        System.out.println("Teste de saque da Conta Corrente com valor 10000, superior ao saldo: ");
        contaEmillyCorrente.sacar(10000);
        System.out.println("--------------------------------------");
        System.out.println("Teste de depósito da Conta Corrente com valor 20 válido: ");
        contaEmillyCorrente.depositar(20);
        System.out.println("Saldo: R$ " + contaEmillyCorrente.getSaldo());
        System.out.println("--------------------------------------");
        System.out.println("Teste de saque da Conta Corrente com valor -100 inválido: ");
        contaEmillyCorrente.depositar(-100);
        System.out.println("--------------------------------------");
        System.out.println("Teste de transferência de 500 da Conta Corrente para conta poupança: ");
        contaEmillyCorrente.transferir(contaMiguel, 500);
        System.out.println("Saldo: R$ " + contaEmillyCorrente.getSaldo());
        System.out.println("--------------------------------------");
        System.out.println("Saldo final da Conta Corrente");
        contaEmillyCorrente.imprimir();
        System.out.println("--------------------------------------");

        //Teste com Cheque Especial
        System.out.println("Saldo da Emilly sem cheque especial: R$ " + contaEmillyCorrente.getSaldo());
        System.out.println("Saldo da Emilly com cheque especial: R$ " + contaEmillyCorrente.retornarSaldoComChequeEspecial());
        //Alterando Cheque Especial
        contaEmillyCorrente.setChequeEspecial(1000.00);
        System.out.println("Novo saldo da Emilly com alteração no cheque especial: R$ " + contaEmillyCorrente.retornarSaldoComChequeEspecial());

        System.out.println("########################################");

        //Teste Conta Poupança
        contaMiguel.imprimir();
        System.out.println("--------------------------------------");
        System.out.println("Teste de depósito da Conta Poupança com valor 50 válido: ");
        contaMiguel.depositar(50);
        System.out.println("Saldo: R$ " + contaMiguel.getSaldo());
        System.out.println("--------------------------------------");
        System.out.println("Teste de saque da Conta Poupança com valor 30 válido: ");
        contaMiguel.sacar(30);
        System.out.println("Saldo: R$ " + contaMiguel.getSaldo());
        System.out.println("--------------------------------------");
        System.out.println("Teste de transferência de 100 da Conta Poupança para Conta Corrente com valor válido: ");
        contaMiguel.transferir(contaEmillyCorrente, 100);
        System.out.println("Saldo: R$ " + contaMiguel.getSaldo());
        System.out.println("--------------------------------------");
        System.out.println("Teste de creditar taxa de juros mensal da Conta Poupança: ");
        contaMiguel.creditarTaxa();
        System.out.println("Saldo após juros do mês: R$ " + contaMiguel.getSaldo());
        System.out.println("--------------------------------------");
        System.out.println("#######################################");

        //Teste com Conta Pagamento
        contaEmillyPagamento.imprimir();
        System.out.println("Teste de depósito de 500 da Conta Pagamento: ");
        contaEmillyPagamento.depositar(500);
        System.out.println("Saldo: R$ " + contaEmillyPagamento.getSaldo());
        System.out.println("--------------------------------------");
        System.out.println("Teste de saque de 100 da Conta Pagamento: ");
        contaEmillyPagamento.sacar(100);
        System.out.println("Saldo: R$ " + contaEmillyPagamento.getSaldo());
        System.out.println("--------------------------------------");
        System.out.println("Teste de transferência de 80 da Conta Pagamento para Conta Poupança: ");
        contaEmillyPagamento.transferir(contaMiguel, 80);
        System.out.println("Saldo: R$ " + contaEmillyPagamento.getSaldo());
        System.out.println("Teste de saque da Conta Pagamento: ");
        contaEmillyPagamento.sacar(900);
        System.out.println("Saldo: R$ " + contaEmillyPagamento.getSaldo());
        System.out.println("Teste de saque com mesmo valor do saldo da conta pagamento: ");
        contaEmillyPagamento.sacar(27.25);
    }
}
