package Arquivos;

import Classes.ClientePF;
import Classes.ClientePJ;
import Classes.Frota;
import Classes.Veiculo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArquivoClientePJ implements l_Arquivo<ClientePJ> {
    @Override
    public Boolean gravarArquivo() {
        return null;
    }

    @Override
    public String lerArquivo(List<ClientePJ> lista, String path) throws IOException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        File file = new File(path);
        String demilitador = ",";
        List<String[]> linhas = new ArrayList<>();
        List<Frota> listaFrotas = new ArrayList<>();

        //Cria lista complementar de frota para adicionar ao cliente
        for (File f : file.listFiles()) {
            if (f.getName().endsWith("frotas.csv")) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String linha = br.readLine();
                while (linha != null) {
                    String[] campos = linha.split(demilitador);
                    linhas.add(campos);
                    listaFrotas.add(new Frota(campos[0], campos[1], campos[2], Integer.parseInt(campos[3])));
                }
            }
        }

        for (File f : file.listFiles()) {
            if (f.getName().endsWith("clientesPJ.csv")) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String linha = br.readLine();
                while (linha != null) {
                    List<Veiculo> listaVeiculo2 = new ArrayList<>();
                    String[] campos = linha.split(demilitador);
                    linhas.add(campos);
                    for(int i = 0; i < listaVeiculo.size(); i++){
                        if(listaVeiculo.get(i).getPlaca().equals(campos[8])){
                            listaVeiculo2.add(listaVeiculo.get(i));
                        }
                    }
                        lista.add(new ClientePJ(campos[1], campos[3], campos[4], campos[2], campos[0], formato.parse(campos[5]), campos[6], 0);
                    linha = br.readLine();
                }
            }
        }
        return "Arquivo lido com sucesso!";
    }
    }
}
