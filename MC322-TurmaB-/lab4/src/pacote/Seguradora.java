package pacote;

import java.util.ArrayList;
import java.util.List;
public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Sinistro> listaSinistros;
    private List<Cliente> listaClientes;

    public Seguradora(String nome, String telefone, String email, String endereco, List<Sinistro> listaSinistros, List<Cliente> listaClientes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = listaSinistros;
        this.listaClientes = listaClientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaCLientes(List<Cliente> listaCLientes) {
        this.listaClientes = listaCLientes;
    }

    @Override
    public String toString() {
        return "padrao.pacote.Seguradora{" +
                "nome='" + nome  +
                ", telefone='" + telefone +
                ", email='" + email +
                ", endereco='" + endereco +
                ", listaSinistros=" + listaSinistros +
                ", listaCLientes=" + listaClientes +
                '}';
    }

    public boolean cadastrarCliente(Cliente cliente){
        if (cliente instanceof ClientePF){
            if(Validacao.validarCPF(((ClientePF) cliente).getCpf())){
                listaClientes.add(cliente);
                return true;
            }
            else{
                return false;
            }
        }
        else if(cliente instanceof ClientePJ){
            if(Validacao.validarCNPJ(((ClientePJ) cliente).getCNPJ())){
                listaClientes.add(cliente);
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public boolean removerCliente (Cliente cliente){
        if(listaClientes.contains(cliente)){
            listaClientes.remove(cliente);
            return true;
        }
        else{
            return false;
        }
    }

     public void listarClientes(String tipoCliente){
        List<Cliente> List_tipoCliente = new ArrayList<>();
        int i;
        if(tipoCliente == "pacote.ClientePF"){
            for(i = 0; i < listaClientes.size(); i++){
                if(listaClientes.get(i) instanceof ClientePF){
                    System.out.println(listaClientes.get(i));
                }
            }
        }
        else if(tipoCliente == "pacote.ClientePJ"){
            for(i = 0; i < listaClientes.size(); i++){
                if(listaClientes.get(i) instanceof ClientePJ){
                    System.out.println(listaClientes.get(i));
                }
            }
        }
    }

    public boolean gerarSinistro(Sinistro sinistro){
        if(listaSinistros.contains(sinistro)){
            return false;
        }
        else{
            listaSinistros.add(sinistro);
            return true;
        }
    }

    public boolean visualizarSinistro(Cliente cliente){
        for (int i = 0; i < listaSinistros.size(); i++){
            if(listaSinistros.get(i).getCliente().equals(cliente)){
                return true;
            }
        }
        return false;
    }

    public void listarSinistros(){
        for(Sinistro sinistro : listaSinistros){
            System.out.println(sinistro.toString());
        }
    }

    public double calcularPrecoSeguroCliente(Cliente cliente){
        return cliente.calculaScore () * (1 + listaSinistros.size() );
    }
    /*public double calcularPrecoSeguroClientePJ(pacote.ClientePJ cliente){
        return cliente.calculaScore () * (1 + listaSinistros.size() );
    }*/
    public double calcularReceita(){
        double total = 0;
        for(Cliente cliente : listaClientes){
            total += calcularPrecoSeguroCliente(cliente);
        }
        return total;
    }
}
