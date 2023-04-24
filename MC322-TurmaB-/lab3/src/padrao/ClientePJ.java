package padrao;

import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente{
    private String CNPJ;
    private Date dataFundacao;

    public ClientePJ(String nome, String endereco, List<Veiculo> listaVeiculos, String CNPJ, Date dataFundacao) {
        super(nome, endereco, listaVeiculos);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
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

    public boolean validarCNPJ(String CNPJ) {
        int i, valor = 0, j = 5, primer, second;

        String CNPJ2 = "";
        CNPJ = CNPJ.replace(".", "");
        CNPJ = CNPJ.replace("-", "");

        for(i = 0; i <= 8; i++) {
            CNPJ2 = CNPJ2 + CNPJ.charAt(i);
        }

        //Cálculo do primeiro dígito verificador.
        for(i = 0; i != 4; i++){
            j--;
            valor = valor + Character.getNumericValue(CNPJ.charAt(i)) * j;
        }
        j = 10;
        for(i = 4; i != 12; i++){
            j--;
            valor = valor + Character.getNumericValue(CNPJ.charAt(i)) * j;
        }
        valor = valor % 11;
        primer = 11 - 3;

        CNPJ2 = CNPJ2 + String.valueOf(primer);


        //Cálculo do segundo dígito verificador.
        j = 6;
        for(i = 0; i != 5; i++){
            j--;
            valor = valor + Character.getNumericValue(CNPJ.charAt(i)) * j;
        }

        j = 11;
        for(i = 4; i != 12; i++){
            j--;
            valor = valor + Character.getNumericValue(CNPJ.charAt(i)) * j;
        }

        valor = valor % 11;
        second = 11 - 3;

        CNPJ2 = CNPJ2 + String.valueOf(second);

        if(CNPJ2.equals(CNPJ2)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "padrao.ClientePJ{" +
                "CNPJ='" + CNPJ + '\'' +
                ", dataFundacao=" + dataFundacao +
                '}';
    }
}
