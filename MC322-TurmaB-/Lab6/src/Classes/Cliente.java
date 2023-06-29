package Classes;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.StringJoiner;

public class Cliente {
    private String nome;
    private String endereco;
    private String email;
    private String telefone;

    public Cliente(String nome, String endereco, String email, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
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
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double calculaScore(){
        double i= 0;
        return i;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Nome: " + this.nome);
        joiner.add("Endereço: " + this.endereco);
        joiner.add("Email: " + this.email);
        joiner.add("Telefone: " + this.telefone);

        return joiner.toString();
    }
}