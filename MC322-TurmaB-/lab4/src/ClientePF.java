package padrao;

import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente {
    private Date dataLicenca;
    private String educacao;
    private String classeEconomica;
    private String cpf ;
    private Date dataNascimento ;

    public ClientePF(String nome, String endereco, List<Veiculo> listaVeiculos, Date dataLicenca, String educacao, String classeEconomica, String cpf, Date dataNascimento) {
        super(nome, endereco, listaVeiculos);
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.classeEconomica = classeEconomica;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean validarCPF(String CPF){
        int i, soma = 0, result, primer_digito, second_digito;
        String cpf2 = "";
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        for(i = 0; i <= 8; i++) {
            cpf2 = cpf2 + cpf.charAt(i);
        }

        if(cpf.length() != 11){
            return false;
        }
        //Calcula primeiro digito verificador
        for(i = 0; i != 9; i++){
            soma  = soma + Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        result = soma % 11;

        if(result < 2) {
            primer_digito = 0;
        }
        else{
            primer_digito = 11 - result;
        }

        cpf2 = cpf2 + String.valueOf(primer_digito);
        soma = 0;

        //Calcula o segundo digito verificador
        for(i = 1; i != 10; i++){
            soma  = soma + Character.getNumericValue(cpf.charAt(i))*(11 - i);
        }
        result = soma % 11;

        if(result < 2){
            second_digito = 0;
        }
        else{
            second_digito = 11 - result;
        }
        cpf2 = cpf2 + String.valueOf(second_digito);

        if(cpf2.equals(cpf2)) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "padrao.ClientePF{" +
                "cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
