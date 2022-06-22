public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos() {
        for (Contato contato:contatos) {
            contato.imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for (Endereco endereco:enderecos) {
            endereco.imprimirEndereco();
        }
    }

    public void imprimirCliente() {
        System.out.println("#################################" +
                "Cadastro do cliente: \n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Contato 1: " + contatos[0] + "\n" +
                "Contato 2: " + contatos[1] + "\n" +
                "Endereço 1: " + enderecos[0] + "\n" +
                "Endereço 2: " + enderecos[1] + "\n" +
                "############################################\n");
    }
}
