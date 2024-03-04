package br.edu.fatecpg.consulta.cep.model;

public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String uf;

    @Override
    public String toString() {
        return "Endereço{ cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
