package Classes;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class SeguroPf extends Seguro {
    private Veiculo veiculo;
    private ClientePF clientepf;


    public SeguroPf(Date dataInicio, Date dataFim, Seguradora seguradora, List<Sinistro> listaSinistro, List<Condutor> listaCondutor, Veiculo veiculo, ClientePF clientepf) {
        super(dataInicio, dataFim, seguradora, listaSinistro, listaCondutor);
        this.veiculo = veiculo;
        this.clientepf = clientepf;
        setValorMensal((int)calcularvalor(fatorIdade()));
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public ClientePF getClientepf() {
        return clientepf;
    }
    public void setClientepf(ClientePF clientepf) {
        this.clientepf = clientepf;
    }

    public boolean desautorizarCondutor(Condutor condutor){
        if (getListaCondutor().contains(condutor)) {
            getListaCondutor().remove(condutor);
            return true;
        } else {
            return false;
        }
    }
    public boolean autorizarCondutor(Condutor condutor){
        if (getListaCondutor().contains(condutor)) {
            getListaCondutor().add(condutor);
            return true;
        } else {
            return false;

        }
    }

    public double QtdSinistroCondutor(List<Condutor> listaCondutores){
        double Qtd = 0;
        for(Condutor condutor : listaCondutores){
            Qtd += condutor.getListasinistro().size();
        }
        return Qtd;
    }

    public double calcularvalor(double fatorIdade){
        double QtdSinistroCliente = super.getSeguradora().GetSinistroPorCliente(clientepf).size();
        double QtdSinistroCondutor = QtdSinistroCondutor(super.getListaCondutor());
        double valor = 10 * fatorIdade + (1 + 1/( clientepf.getListaVeiculos().size() +2) ) *
                 (2 + QtdSinistroCliente /10) *
                 (5 + QtdSinistroCondutor /10) ;

        return valor;
    }

    public int idadeCliente(){
        Date dataNascimento = clientepf.getDataNascimento();

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

    public double fatorIdade(){
        int idade = idadeCliente();
        if(idade <= 30){
            return 1.25;
        }
        else if(idade > 30 && idade <= 60){
            return 1.00;
        }
        else if(idade > 60){
            return 1.5;
        }
        return 0.00;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(super.toString());
        joiner.add("Veiculo: " + veiculo);
        joiner.add("Cliente: " + clientepf);
        return joiner.toString();

    }


}
