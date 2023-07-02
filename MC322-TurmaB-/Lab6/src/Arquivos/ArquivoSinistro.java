package Arquivos;

import Classes.Sinistro;
import Classes.Veiculo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArquivoSinistro implements l_Arquivo<Sinistro> {
    @Override
    public Boolean gravarArquivo() {
        return null;
    }

    @Override
    public String lerArquivo(List<Sinistro> lista) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        File file = new File("src/Arquivos/lab06-seguradora_arquivos_v2/veiculos.csv");
        String demilitador = ",";
        List<String[]> linhas = new ArrayList<>();

        //Cria lista complementar de veiculos para adicionar ao cliente
        for (File f : file.listFiles()) {
            if (f.getName().endsWith("veiculos.csv")) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String linha = br.readLine();
                while (linha != null) {
                    String[] campos = linha.split(demilitador);
                    linhas.add(campos);
                    lista.add(new Veiculo(campos[0], campos[1], campos[2], Integer.parseInt(campos[3])));
                }
            }
        }
        return "Arquivo lido com sucesso!";
    }
    }
}
