public class Main {
    public static void main(String[] args) {
        Contato emillyContato1 = new Contato("Celular pessoal para emergencia.", "(27) 98595-7443", 1);
        Contato emillyContato2 = new Contato("Telefone comercial, disponivel em horarios comerciais.", "(27) 2998-7413", 2);
        Contato[] emillyContatos = {emillyContato1, emillyContato2};

        Endereco emillyEndereco1 = new Endereco(1, "Rua Narciso Menelli", 99,
                "Apartamento 15", "01410030", "São Paulo", "São Paulo", "Brasil");
        Endereco emillyEndereco2 = new Endereco(2, "Jardim Boa Vista", 80,
                "17° Andar", "05205040", "São Paulo", "São Paulo", "Brasil");
        Endereco[] emillyEnderecos = {emillyEndereco1, emillyEndereco2};

        Cliente emilly = new Cliente("Emilly", "69061807034", emillyContatos, emillyEnderecos);

        ContaCorrente contaEmilly = new ContaCorrente(emilly, "9001", "001", 1000.00, 500.00);

        Contato miguelContato1 = new Contato("Celular pessoal para emergencia.", "(98) 98922-2838", 1);
        Contato miguelContato2 = new Contato("Telefone comercial, disponivel em horarios comerciais.", "(98) 2677-0296", 2);
        Contato[] miguelContatos = {miguelContato1, miguelContato2};

        Endereco miguelEndereco1 = new Endereco(1, "Travessa da Elca", 50, "Fátima", "65030-530", "São Luís", "MA", "Brasil");
        Endereco miguelEndereco2 = new Endereco(2, "Travessa", 17, "Bloco 3", "65030-530", "São Luís", "MA", "Brasil");
        Endereco[] miguelEnderecos = {miguelEndereco1, miguelEndereco2};

        Cliente miguel = new Cliente("Miguel", "18647896712", miguelContatos, miguelEnderecos);

        ContaPoupanca contaMiguel = new ContaPoupanca(miguel, "8001", "002", 100.00);

        //Iniciando Testes

        //Testes Conta Corrente
        System.out.println("--------------------------------------");
        contaEmilly.imprimir();
        System.out.println("--------------------------------------");
        contaEmilly.sacar(200);
        contaEmilly.sacar(10000);
        contaEmilly.depositar(20);
        contaEmilly.depositar(-100);
        contaEmilly.transferir(contaMiguel, 500);
        System.out.println("--------------------------------------");
        contaEmilly.imprimir();
        System.out.println("--------------------------------------");

        //Teste com Cheque Especial
        System.out.println("Saldo da Emilly sem cheque especial: R$ " + contaEmilly.getSaldo());
        System.out.println("Saldo da Emilly com cheque especial: R$ " + contaEmilly.retornarSaldoComChequeEspecial());
        //Alterando Cheque Especial
        contaEmilly.setChequeEspecial(1000.00);
        System.out.println("Novo saldo da Emilly com alteração no cheque especial: R$ " + contaEmilly.retornarSaldoComChequeEspecial());

        System.out.println("########################################");

        //Teste Conta Poupança
        contaMiguel.imprimir();
        System.out.println("--------------------------------------");
        contaMiguel.depositar(50);
        contaMiguel.sacar(30);
        contaMiguel.transferir(contaEmilly, 100);
        contaMiguel.creditarTaxa();
        System.out.println("Saldo após juros do mês: R$ " + contaMiguel.getSaldo());
        contaMiguel.creditarTaxa();

    }
}