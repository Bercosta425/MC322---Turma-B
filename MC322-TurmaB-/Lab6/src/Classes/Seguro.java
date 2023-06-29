package Classes;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class Seguro {
    private final int id;
    private static int qtd = 0;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private List<Sinistro> listaSinistro;
    private List<Condutor> listaCondutor;
    private int ValorMensal;

    public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora, List<Sinistro> listaSinistro, List<Condutor> listaCondutor) {
        this.qtd += qtd;
        this.id = qtd;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistro = listaSinistro;
        this.listaCondutor = listaCondutor;
    }

    public int getId() {
        return id;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    public Seguradora getSeguradora() {
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    public List<Sinistro> getListaSinistro() {
        return listaSinistro;
    }
    public void setListaSinistro(List<Sinistro> listaSinistro) {
        this.listaSinistro = listaSinistro;
    }
    public List<Condutor> getListaCondutor() {
        return listaCondutor;
    }
    public void setListaCondutor(List<Condutor> listaCondutor) {
        this.listaCondutor = listaCondutor;
    }
    public int getValorMensal() {
        return ValorMensal;
    }
    public void setValorMensal(int valorMensal) {
        this.ValorMensal = valorMensal;
    }

    public boolean desautorizarCondutor(Condutor condutor){
        if (listaCondutor.contains(condutor)) {
            listaCondutor.remove(condutor);
            return true;
        } else {
            return false;
        }
    }
    public boolean autorizarCondutor(Condutor condutor){
        if (listaCondutor.contains(condutor)) {
            listaCondutor.add(condutor);
            return true;
        } else {
            return false;

        }
    }
    public boolean gerarsinistro() throws ParseException {
        Sinistro sinistro = Leitura.leSinistro(seguradora);
        listaSinistro.add(sinistro);
        return true;
    }
    public double calcularvalor(double fatorIdade){
        double valor = Double.parseDouble(null);
        return valor;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Seguro: " + this.id);
        joiner.add("Data de Inicio: " + this.dataInicio);
        joiner.add("Data de Fim: " + this.dataFim);
        joiner.add("Seguradora: " + this.seguradora);
        joiner.add("Lista de Sinistro: \n" + this.listaSinistro);
        joiner.add("Lista de Condutor: \n" + this.listaCondutor);
        joiner.add("Valor Mensal: " + this.ValorMensal);
        return joiner.toString();
    }

    // desautorizarCondutor();
    // autorizarCondutor();
    // calcularValor();
    // gerarSinistro();
}
