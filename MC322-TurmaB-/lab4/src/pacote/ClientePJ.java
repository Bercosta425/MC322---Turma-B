package pacote;

import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente{
    private String CNPJ;
    private Date dataFundacao;
    private  int qtdeFuncionarios;

    public ClientePJ(String nome, String endereco, List<Veiculo> listaVeiculos, String CNPJ, Date dataFundacao, int qtdeFuncionarios) {
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

    public double calculaScore(){
        return CalcSeguro.VALOR_BASE.getValor() * (1 + ( qtdeFuncionarios ) /100) * getListaVeiculos().size();
    }

    @Override
    public String toString() {
        return "padrao.pacote.ClientePJ{" +
                "CNPJ='" + CNPJ + '\'' +
                ", dataFundacao=" + dataFundacao +
                '}';
    }
}
