package Classes;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class ClientePF extends Cliente {
    private String educacao;
    private String genero;
    private String cpf ;
    private Date dataNascimento ;
    private List<Veiculo> listaVeiculos;

    public ClientePF(String nome, String endereco, String email, String telefone, String educacao, String genero, String cpf, Date dataNascimento, List<Veiculo> listaVeiculos) {
        super(nome, endereco, email, telefone);

        this.educacao = educacao;
        this.genero = genero;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = listaVeiculos;
    }

    public String getEducacao() {
        return educacao;
    }
    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    /*public double calculaScore(){
        Date anos18 = new Date(2005, 05, 13);
        Date anos30 = new Date(1993, 05, 13);
        Date anos60 = new Date(1963, 05, 13);
        Date anos90 = new Date(1933, 05, 13);
        if(dataNascimento.before(anos18) && dataNascimento.after(anos30)){
            return CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.FATOR_18_30.getValor() * getListaVeiculos().size();
        }
        else if (dataNascimento.before(anos30) && dataNascimento.after(anos60)){
            return CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.FATOR_30_60.getValor() * getListaVeiculos().size();
        }
        else if (dataNascimento.before(anos60) && dataNascimento.after(anos90)){
            return CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.FATOR_60_90.getValor() * getListaVeiculos().size();
        }
        return 0.0;
    }*/

    public boolean cadastrarveiculo(Veiculo veiculo){
        if (listaVeiculos.contains(veiculo)) {
            return false;
        } else {
            listaVeiculos.add(veiculo);
            return true;
        }
    }
    public boolean removerveiculo(Veiculo veiculo){
        if (listaVeiculos.contains(veiculo)) {
            listaVeiculos.remove(veiculo);
            return true;

        } else {
            return false;
        }
    }

    public Veiculo getVeiculo(String placa){
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(super.toString());
        joiner.add("CPF: " + this.cpf);
        joiner.add("Data de Nascimento: " + this.dataNascimento);
        joiner.add("Genero: " + this.genero);
        joiner.add("Escolaridade: " + this.educacao);
        joiner.add("Lista de Veiculos: " + this.listaVeiculos);
        return joiner.toString();
    }
}
