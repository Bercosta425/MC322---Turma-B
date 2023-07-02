package Arquivos;

import Classes.Seguradora;

import java.util.List;

public class GravarArquivo {
    private static List<Seguradora> listaSeguradora;

    public static List<Seguradora> getListaSeguradora() {
        return listaSeguradora;
    }
    public static Seguradora getSeguradora(String CNPJ){
        for (Seguradora seguradora : listaSeguradora) {
            if (seguradora.getCNPJ().equals(CNPJ)) {
                return seguradora;
            }
        }
        return null;
    }
}
