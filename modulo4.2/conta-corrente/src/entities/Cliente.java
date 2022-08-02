package entities;

import java.util.ArrayList;

public class Cliente {
    private String nome, cpf;
    private ArrayList <Contato> contatos = new ArrayList<>();
    private ArrayList <Endereco> enderecos = new ArrayList<>();

    public Cliente(String nome, String cpf, Contato contato1, Contato contato2,
                   Endereco endereco1, Endereco endereco2) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos.add(contato1);
        this.contatos.add(contato2);
        this.enderecos.add(endereco1);
        this.enderecos.add(endereco2);
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

    public void setContatos(ArrayList<Contato> contato) {
        this.contatos = contato;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> endereco) {
        this.enderecos = endereco;
    }

    public void imprimirContatos() {
        if (contatos != null) {
            for (int i = 0; i < contatos.size(); i++) {
                if (contatos.get(i) != null) {
                    contatos.get(i).imprimirContato();
                }
            }
        }
    }

    public void imprimirEnderecos() {
        if (enderecos != null) {
            for (int i = 0; i < enderecos.size(); i++) {
                if (enderecos.get(i) != null) {
                    enderecos.get(i).imprimirEndereco();
                }
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("CLIENTE\n" + this.nome + "\nCPF: " + this.cpf);
    }
}
