package Classes;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class ClientePJ extends Cliente{
    private String CNPJ;
    private Date dataFundacao;
    private  List<Frota> listaFrota;
    private int QtdFuncionarios;

    public ClientePJ(String nome, String endereco, String email, String telefone, String CNPJ, Date dataFundacao, List<Frota> listaFrota, int qtdFuncionarios) {
        super(nome, endereco, email, telefone);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.listaFrota = listaFrota;
        QtdFuncionarios = qtdFuncionarios;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    public Date getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    public List<Frota> getListaFrota() {
        return listaFrota;
    }
    public void setListaFrota(List<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }
    public int getQtdFuncionarios() {
        return QtdFuncionarios;
    }
    public void setQtdFuncionarios(int qtdFuncionarios) {
        QtdFuncionarios = qtdFuncionarios;
    }
    /*public double calculaScore(){
        return CalcSeguro.VALOR_BASE.getValor() * (1 + ( qtdeFuncionarios ) /100) * getListaVeiculos().size();
    }*/


    public boolean cadastrarfrota(Frota frota){
        if (listaFrota.contains(frota)) {
            return false;
        } else {
            listaFrota.add(frota);
            return true;
        }
    }

    public boolean removerfrota(Frota frota){
        if (listaFrota.contains(frota)) {
            listaFrota.remove(frota);
            return true;
        } else {
            return false;
        }
    }
    public boolean adicionarveiculo(Frota frota){
        Veiculo veiculo = Leitura.leVeiculo();
        return frota.addveiculo(veiculo);
    }
    public boolean removeveiculo(Frota frota){
        Veiculo veiculo = Leitura.leVeiculo();
        return frota.removeveiculo(veiculo);
    }
    public boolean atualizarFrota(Frota frota){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite qual ação tu queres tomar:\n" +
                            "1 - Cadastrar frota\n" +
                            "2 - Remover frota\n"   +
                            "3 - Adicionar veiculo\n" +
                            "4 - Remover veiculo");
        int acao = scanner.nextInt();
        if(acao == 1){
            return cadastrarfrota(frota);
        }
        else if(acao == 2){
            return removerfrota(frota);
        }
        else if(acao == 3){
            adicionarveiculo(frota);
        }
        else if(acao == 4){
            removeveiculo(frota);
        }
        System.out.println("Tu digitou um número inválido!");
        return false;
    }
    public boolean getVeiculosPorFrota(Frota frota){
        for(Frota frota2 : listaFrota){
            if(frota2.equals(frota)){
                frota.getListaveiculos().forEach(System.out::println);
                return true;
            }
        }
        return false;
    }

    public int QtdVeiculos(){
        int Qtd = 0;
        for(Frota frota : listaFrota){
            Qtd += frota.getListaveiculos().size();
        }
        return Qtd;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(super.toString());
        joiner.add("CNPJ: " + this.CNPJ);
        joiner.add("Data de fundação: " + this.dataFundacao);
        joiner.add("Quantidade de funcionários: " + this.QtdFuncionarios);
        joiner.add("Quantidade de veículos: " + QtdVeiculos());
        for(Frota frota : listaFrota){
            joiner.add(frota.toString());
        }
        return joiner.toString();
    }
}
