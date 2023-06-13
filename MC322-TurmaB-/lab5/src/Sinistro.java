import java.util.Date;

public class Sinistro {
    private int ID;
    private static int qtd = 0;
    private Date data;
    private String endereco;
    private Seguro seguro;

    public Sinistro(Date data, String endereco, Seguro seguro) {
        qtd += qtd;
        this.ID = qtd;
        this.data = data;
        this.endereco = endereco;
        this.seguro = seguro;
    }

    //
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Seguro getSeguro() {
        return seguro;
    }
    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    @Override
    public String toString() {
        return "Sinistro{" +
                "ID=" + ID +
                ", data=" + data +
                ", endereco='" + endereco + '\'' +
                ", seguro=" + seguro +
                '}';
    }
}
