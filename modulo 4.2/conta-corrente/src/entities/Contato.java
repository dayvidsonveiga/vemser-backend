package entities;

public class Contato {
    private Integer tipo;
    private String telefone, descricao;

    public Contato(Integer tipo, String descricao, String telefone) {
        this.tipo = tipo;
        this.telefone = telefone;
        this.descricao = descricao;
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

    public void imprimirContato() {
        switch (this.getTipo()) {
            case 1 -> {
                System.out.println("CONTATO\nTipo: Residencial \n" + "Telefone: " + this.telefone
                        + "\nDescrição: " + this.descricao + "\n");
            }
            case 2 -> {
                System.out.println("CONTATO\nTipo: Comercial \n" + "Telefone: " + this.telefone
                        + "\nDescrição: " + this.descricao + "\n");
            }
            default -> {
                System.out.println("entities.Contato não encontrado.");
            }
        }
    }
}
