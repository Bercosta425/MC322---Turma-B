package Classes;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class SeguroPj extends Seguro{
    private Frota frota;
    ClientePJ clientepj;

    public SeguroPj(Date dataInicio, Date dataFim, Seguradora seguradora, List<Sinistro> listaSinistro, List<Condutor> listaCondutor, Frota frota, ClientePJ clientepj) {
        super(dataInicio, dataFim, seguradora, listaSinistro, listaCondutor);
        this.frota = frota;
        this.clientepj = clientepj;
        setValorMensal((int) calcularvalor()) ;
    }

    public Frota getFrota() {
        return frota;
    }
    public void setFrota(Frota frota) {
        this.frota = frota;
    }
    public ClientePJ getClientepj() {
        return clientepj;
    }
    public void setClientepj(ClientePJ clientepj) {
        this.clientepj = clientepj;
    }

    public double QtdSinistroCondutor(List<Condutor> listaCondutores){
        double Qtd = 0;
        for(Condutor condutor : listaCondutores){
            Qtd += condutor.getListasinistro().size();
        }
        return Qtd;
    }
    public double calcularvalor(){
        double QtdSinistroCliente = super.getSeguradora().GetSinistroPorCliente(clientepj).size();
        double QtdSinistroCondutor = QtdSinistroCondutor(super.getListaCondutor());
        return 10 * (10 + (clientepj.getQtdFuncionarios()/10)) *
                (1 + (1/( clientepj.QtdVeiculos() +2) )) *
                (1 + (1/( idadeCliente() +2)) ) *
                (2 + (QtdSinistroCliente /10)) *
                (5 + (QtdSinistroCondutor /10));
    }

    public int idadeCliente(){
        Date dataNascimento = clientepj.getDataFundacao();

        // Data atual
        LocalDate dataAtual = LocalDate.now();

        // Converter Date para LocalDate
        LocalDate localDateNascimento = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calcular diferença entre a data atual e a data de nascimento
        Period periodo = Period.between(localDateNascimento, dataAtual);

        // Obter a idade em anos
        int idade = periodo.getYears();

        return idade;
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(super.toString());
        joiner.add("Frota: \n" + frota.toString());
        joiner.add("Cliente: \n" + clientepj.toString());
        return joiner.toString();


    }
}
