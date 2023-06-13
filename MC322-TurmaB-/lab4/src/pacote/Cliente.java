package pacote;

import java.util.List;

public class Cliente {
    private String nome;
    private String endereco;
    private List<Veiculo> listaVeiculos;
    private double valorSeguro;

    public Cliente(String nome, String endereco, List<Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
    public void setValorSeguro(double valorSeguro){
        this.valorSeguro = valorSeguro;
    }
    public double getValorSeguro(){
        return valorSeguro;
    }

    public double calculaScore(){
        double i= 0;
        return i;
    }


    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", listaVeiculos=" + listaVeiculos +
                '}';
    }
}