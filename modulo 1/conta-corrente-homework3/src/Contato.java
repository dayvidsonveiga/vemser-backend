public class Contato {
    private String descricao;
    private String telefone;
    private Integer tipo;

    public Contato(String descricao, String telefone, Integer tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
