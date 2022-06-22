public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimirEndereco() {
        switch (tipo) {
            case 1 -> {
                System.out.println("Endereço residencial" +
                        "Logradouro: " + logradouro + "\n" +
                        "Número: " + numero + "\n" +
                        "Complemento: " + complemento + "\n" +
                        "Cep: " + cep + "\n" +
                        "Cidade: " + cidade + "\n" +
                        "Estado: " + estado + "\n" +
                        "País: " + pais + "\n");
            }
            case 2 -> {
                System.out.println("Endereço comercial" +
                        "Logradouro: " + logradouro + "\n" +
                        "Número: " + numero + "\n" +
                        "Complemento: " + complemento + "\n" +
                        "Cep: " + cep + "\n" +
                        "Cidade: " + cidade + "\n" +
                        "Estado: " + estado + "\n" +
                        "País: " + pais + "\n");
            }
        }
    }
}
