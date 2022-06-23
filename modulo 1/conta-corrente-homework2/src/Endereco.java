public class Endereco {
    private Integer tipo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(Integer tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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
