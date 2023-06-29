package Classes;

import Classes.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Seguradora {
    private final String CNPJ;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Cliente> listaClientes;
    private List<Seguro> listaSeguros;

    public Seguradora(String CNPJ, String nome, String telefone, String email, String endereco, List<Cliente> listaClientes, List<Seguro> listaSeguros) {
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaClientes = listaClientes;
        this.listaSeguros = listaSeguros;
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

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaCLientes(List<Cliente> listaCLientes) {
        this.listaClientes = listaCLientes;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public List<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public void setListaSeguros(List<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public boolean cadastrarCliente(Cliente cliente) throws ExcecaoLeitura.ErroDeCPF, ExcecaoLeitura.ErroDeCNPJ {
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
        if(tipoCliente == "Classes.ClientePF"){
            for(i = 0; i < listaClientes.size(); i++){
                if(listaClientes.get(i) instanceof ClientePF){
                    System.out.println(listaClientes.get(i));
                }
            }
        }
        else if(tipoCliente == "Classes.ClientePJ"){
            for(i = 0; i < listaClientes.size(); i++){
                if(listaClientes.get(i) instanceof ClientePJ){
                    System.out.println(listaClientes.get(i));
                }
            }
        }
    }
    public boolean gerarSeguro(List<Seguro> listaSeguros) throws ParseException {
        Seguro seguro = Leitura.leSeguroPf(this);
        if (listaSeguros.contains(seguro)) {
            return false;
        } else {
            listaSeguros.add(seguro);
            return true;
        }
    }
    public boolean cancelarSeguro (Seguro seguro){
        if(listaSeguros.contains(seguro)){
            listaSeguros.remove(seguro);
            return true;
        }
        else{
            return false;
        }
    }
    public List<Seguro> GetSeguroPorCliente(Cliente cliente){
        List<Seguro> listaSeguros1 = new ArrayList<>();
        for(Seguro seguro : listaSeguros){
            if(seguro instanceof SeguroPf){
                if( (((SeguroPf) seguro).getClientepf()).equals(cliente));
                listaSeguros1.add(seguro);
            }
            if(seguro instanceof SeguroPj){
                if( (((SeguroPj) seguro).getClientepj()).equals(cliente));
                listaSeguros1.add(seguro);
            }
        }
        return listaSeguros1;
    }
    public List<Sinistro> GetSinistroPorCliente(Cliente cliente){
            List<Sinistro> listaSinistros = new ArrayList<>();
            List<Seguro> listaSeguros1 = GetSeguroPorCliente(cliente);
            for(Seguro seguro : listaSeguros1){
                for( Sinistro sinistro : seguro.getListaSinistro()){
                    listaSinistros.add(sinistro);
                }
            }
            return listaSinistros;
    }
    public double calcularReceita(){
        double receita = 0;
        for(Seguro seguro : listaSeguros){
            receita += seguro.getValorMensal();
        }
        return receita;
    }
    public void lerDados(){
    }
    public void gravarDados(){
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("CNPJ: " + this.CNPJ);
        joiner.add("Nome: " + this.nome);
        joiner.add("Telefone: " + this.telefone);
        joiner.add("Email: " + this.email);
        joiner.add("Endereco: " + this.endereco);

        joiner.add("Lista de Clientes: \n" + this.listaClientes);
        joiner.add("Lista de Seguros: \n" + this.listaSeguros);
        return joiner.toString();
    }


}



