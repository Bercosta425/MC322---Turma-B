package Classes;

import Classes.Sinistro;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private Date dataNascimento;
    private List<Sinistro> listasinistro;

    public Condutor(String cpf, String nome, String telefone, String email, String endereco, Date dataNascimento, List<Sinistro> listasinistro) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.listasinistro = listasinistro;
    }

    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public List<Sinistro> getListasinistro() {
        return listasinistro;
    }
    public void setListasinistro(List<Sinistro> listasinistro) {
        this.listasinistro = listasinistro;
    }

    public boolean adicionarSinistro(Sinistro sinistro){
        if (listasinistro.contains(sinistro)) {
            return false;
        } else {
            listasinistro.add(sinistro);
            return true;
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Nome: " + this.nome);
        joiner.add("CPF: " + this.cpf);
        joiner.add("Telefone: " + this.telefone);
        joiner.add("Email: " + this.email);
        joiner.add("Endereço: " + this.endereco);
        joiner.add("Data de Nascimento: " + this.dataNascimento);
        return joiner.toString();
    }
}
