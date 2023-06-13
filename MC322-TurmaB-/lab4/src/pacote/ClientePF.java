package pacote;

import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente {
    private Date dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private String cpf ;
    private Date dataNascimento ;

    public ClientePF(String nome, String endereco, List<Veiculo> listaVeiculos, Date dataLicenca, String educacao, String classeEconomica, String cpf, Date dataNascimento, String genero) {
        super(nome, endereco, listaVeiculos);
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.classeEconomica = classeEconomica;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    public String getCpf() {
        return cpf;
    }

    public String getGenero(){return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
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

    public double calculaScore(){
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
    }
    @Override
    public String toString() {
        return "padrao.pacote.ClientePF{" +
                "cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
