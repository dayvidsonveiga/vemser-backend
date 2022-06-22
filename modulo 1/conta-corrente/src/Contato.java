public class Contato {
    String descricao;
    String telefone;
    int tipo;

    public void imprimirContato() {
        switch (tipo) {
            case 1 -> {
                System.out.println("Descrição: " + descricao + "\n" +
                        "Telefone residencial: " + telefone + "\n");
            }
            case 2 -> {
                System.out.println("Descrição: " + descricao + "\n" +
                        "Telefone comercial: " + telefone + "\n");
            }
        }

    }
}
