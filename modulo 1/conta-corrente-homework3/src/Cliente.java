import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {
        if (contatos != null) {
            for (Contato contato:contatos) {
                if (contato != null) {
                    contato.imprimirContato();
                }
            }
        }
    }

    public void imprimirEnderecos() {
        if (enderecos != null) {
            for (Endereco endereco:enderecos) {
                if (endereco != null) {
                    endereco.imprimirEndereco();
                }
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("#################################" +
                "Cadastro do cliente: \n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "############################################\n");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
