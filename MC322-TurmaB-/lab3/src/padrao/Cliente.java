package padrao;

import java.util.Date;
import java.util.List;

public class Cliente {
    private String nome;
    private String endereco;
    private List<Veiculo> listaVeiculos;

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


    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", listaVeiculos=" + listaVeiculos +
                '}';
    }
}
