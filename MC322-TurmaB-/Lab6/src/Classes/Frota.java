package Classes;

import java.util.List;
import java.util.StringJoiner;

public class Frota {
    private String code;
    List<Veiculo> listaveiculos;

    public Frota(String code, List<Veiculo> listaveiculos) {
        this.code = code;
        this.listaveiculos = listaveiculos;
    }
    public String getCode() {
        return code;
    }
    public List<Veiculo> getListaveiculos() {
        return listaveiculos;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setListaveiculos(List<Veiculo> listaveiculos) {
        this.listaveiculos = listaveiculos;
    }

    public boolean addveiculo(Veiculo veiculo){
        if (listaveiculos.contains(veiculo)) {
            return false;
        } else {
            listaveiculos.add(veiculo);
            return true;
        }
    }

    public boolean removeveiculo(Veiculo veiculo){
        if (listaveiculos.contains(veiculo)) {
            listaveiculos.remove(veiculo);
            return true;

        } else {
            return false;
        }
    }
    @Override
    public String toString() {
       StringJoiner joiner = new StringJoiner("\n");
         joiner.add("Código da Frota: " + this.code);
         joiner.add("Lista de Veículos: " + this.listaveiculos);
            return joiner.toString();
    }
}
