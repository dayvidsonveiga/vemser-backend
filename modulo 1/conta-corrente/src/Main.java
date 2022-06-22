public class Main {
    public static void main(String[] args) {
        Cliente emilly = new Cliente();
        emilly.nome = "Emilly Stella da Silva";
        emilly.cpf = "216.457.989-50";
        emilly.contatos[0] = new Contato();
        emilly.contatos[0].tipo = 1;
        emilly.contatos[0].telefone = "(27) 98595-7443";
        emilly.contatos[0].descricao = "Celular pessoal para emergencia.";
        emilly.contatos[1] = new Contato();
        emilly.contatos[1].tipo = 2;
        emilly.contatos[1].telefone = "(27) 2998-7413";
        emilly.contatos[1].descricao = "Telefone comercial, disponivel em horarios comerciais.";
        emilly.enderecos[0] = new Endereco();
        emilly.enderecos[0].tipo = 1;
        emilly.enderecos[0].logradouro = "Rua Narciso Menelli";
        emilly.enderecos[0].numero = 766;
        emilly.enderecos[0].complemento = "Jardim Boa Vista";
        emilly.enderecos[0].cep = "29217-070";
        emilly.enderecos[0].cidade = "Guarapari";
        emilly.enderecos[0].estado = "ES";
        emilly.enderecos[0].pais = "Brasil";
        emilly.enderecos[1] = new Endereco();
        emilly.enderecos[1].tipo = 2;
        emilly.enderecos[1].logradouro = "Jardim Boa Vista";
        emilly.enderecos[1].numero = 766;
        emilly.enderecos[1].complemento = "Endereço comercial.";
        emilly.enderecos[1].cep = "29250-090";
        emilly.enderecos[1].cidade = "Guarapari";
        emilly.enderecos[1].estado = "ES";
        emilly.enderecos[1].pais = "Brasil";

        Cliente miguel = new Cliente();
        miguel.nome = "Miguel Samuel Vieira";
        miguel.cpf = "199.068.623-00";
        miguel.contatos[0] = new Contato();
        miguel.contatos[0].tipo = 1;
        miguel.contatos[0].telefone = "(98) 98922-2838";
        miguel.contatos[0].descricao = "Celular pessoal para emergencia.";
        miguel.contatos[1] = new Contato();
        miguel.contatos[1].tipo = 2;
        miguel.contatos[1].telefone = "(98) 2677-0296";
        miguel.contatos[1].descricao = "Telefone comercial, disponivel em horarios comerciais.";
        miguel.enderecos[0] = new Endereco();
        miguel.enderecos[0].tipo = 1;
        miguel.enderecos[0].logradouro = "Travessa da Elca";
        miguel.enderecos[0].numero = 969;
        miguel.enderecos[0].complemento = "Fátima";
        miguel.enderecos[0].cep = "65030-530";
        miguel.enderecos[0].cidade = "São Luís";
        miguel.enderecos[0].estado = "MA";
        miguel.enderecos[0].pais = "Brasil";
        miguel.enderecos[1] = new Endereco();
        miguel.enderecos[1].tipo = 1;
        miguel.enderecos[1].logradouro = "Jardim Boa Vista";
        miguel.enderecos[1].numero = 766;
        miguel.enderecos[1].complemento = "Endereço comercial.";
        miguel.enderecos[1].cep = "29250-090";
        miguel.enderecos[1].cidade = "Guarapari";
        miguel.enderecos[1].estado = "São Paulo";
        miguel.enderecos[1].pais = "Brasil";

        ContaCorrente contaEmillyStella = new ContaCorrente();
        contaEmillyStella.cliente = emilly;
        contaEmillyStella.agencia = 1001;
        contaEmillyStella.numeroConta = "90001";
        contaEmillyStella.saldo = 2000;
        contaEmillyStella.chequeEspecial = 500;

        ContaCorrente contaMiguelSamuel = new ContaCorrente();
        contaMiguelSamuel.cliente = miguel;
        contaMiguelSamuel.agencia = 1002;
        contaMiguelSamuel.numeroConta = "90002";
        contaMiguelSamuel.saldo = 1500;
        contaMiguelSamuel.chequeEspecial = 200;

        //Iniciando Testes

        contaEmillyStella.imprimirContaCorrente();
        System.out.println("-------------------------------------------");
        contaMiguelSamuel.imprimirContaCorrente();
        System.out.println("-------------------------------------------");
        System.out.println("Transferência válida: ");
        contaEmillyStella.transferir(contaMiguelSamuel, 1000);
        System.out.println("-------------------------------------------");
        System.out.println("Transferência inválida: ");
        contaEmillyStella.transferir(contaMiguelSamuel, 10000);
        System.out.println("-------------------------------------------");
        System.out.println("Saque válido: ");
        contaMiguelSamuel.sacar(80);
        System.out.println("-------------------------------------------");
        System.out.println("Saque inválido: ");
        contaMiguelSamuel.sacar(50000);
        System.out.println("-------------------------------------------");
        System.out.println("Depósito válido: ");
        contaEmillyStella.depositar(850);
        System.out.println("-------------------------------------------");
        System.out.println("Depósito inválido: ");
        contaEmillyStella.depositar(-20);
        System.out.println("-------------------------------------------");
        System.out.println("Consulta saldo + cheque especial: ");
        contaEmillyStella.retornarSaldoComChequeEspecial();
        System.out.println("-------------------------------------------");
        contaEmillyStella.imprimirContaCorrente();
        contaEmillyStella.cliente.imprimirContatos();
        contaEmillyStella.cliente.imprimirEnderecos();
        System.out.println("-------------------------------------------");
        contaMiguelSamuel.imprimirContaCorrente();
        contaMiguelSamuel.cliente.imprimirContatos();
        contaMiguelSamuel.cliente.imprimirEnderecos();

    }
}