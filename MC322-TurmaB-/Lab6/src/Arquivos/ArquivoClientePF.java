package Arquivos;

import Classes.ClientePF;

import java.io.File;
import java.util.List;

public class ArquivoClientePF implements l_Arquivo<ClientePF>{
    @Override
    public Boolean gravarArquivo() {
        return null;
    }

    @Override
    public String lerArquivo(List<ClientePF> lista) {
        File file = new File("C:\\Users\\Suporte\\Documents\\MC322\\lab06-seguradora_arquivos\\lab06-seguradora_arquivos_v2\\clientesPF.csv");

        return null;

    }
}
