public class Sinistro {
    private int ID;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Cliente cliente;

    public Sinistro(int ID, String data, String endereco, Seguradora seguradora, Cliente cliente) {
        this.ID = ID;
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.cliente = cliente;
    }

    //
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String toString() {
        return "padrao.Sinistro{" +
                "ID=" + ID +
                ", data='" + data + '\'' +
                ", endereco='" + endereco + '\'' +
                //", seguradora=" + seguradora +
                ", cliente=" + cliente +
                '}';
    }
}
