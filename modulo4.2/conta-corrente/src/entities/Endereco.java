package entities;

public class Endereco {
    private Integer tipo, numero;
    private String logradouro, complemento, cep, cidade, estado, pais;

    public Endereco(Integer tipo, Integer numero, String logradouro, String complemento,
                    String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.numero = numero;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void imprimirEndereco() {
        switch (this.tipo) {
            case 1 -> {
                System.out.println("ENDEREÇO \nTipo: Residencial" + "\nRua: " + this.logradouro
                        + "\nNúmero: " + this.numero + "\nComplemento: " + this.complemento
                        + "\nCEP: " + this.cep + "\nCidade: " + this.cidade
                        + "\nEstado: " + this.estado + "\nPaís: " + this.pais + "\n");
            }
            case 2 -> {
                System.out.println("ENDEREÇO \nTipo: Comercial" + "\nRua: " + this.logradouro
                        + "\nNúmero: " + this.numero + "\nComplemento: " + this.complemento
                        + "\nCEP: " + this.cep + "\nCidade: " + this.cidade
                        + "\nEstado: " + this.estado + "\nPaís: " + this.pais + "\n");
            }
            default -> {
                System.out.println("Endereço não encontrado.");
            }
        }
    }
}
