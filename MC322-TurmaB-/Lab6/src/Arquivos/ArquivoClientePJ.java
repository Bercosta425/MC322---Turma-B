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
    public String lerArquivo(List<ClientePJ> lista) throws IOException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        File file = new File("src/Arquivos/lab06-seguradora_arquivos_v2/clientesPJ.csv");
        String demilitador = ",";
        List<String[]> linhas = new ArrayList<>();
        List<Frota> listaFrotas = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha = br.readLine();
        while (linha != null) {
            if(linha.equals("CNPJ_CLIENTE,NOME_CLIENTE,TELEFONE,ENDERECO,EMAIL_CLIENTE,DATA_FUND,CODE_FROTA")){
                linha = br.readLine();
                continue;
            }
            String[] campos = linha.split(demilitador);
            linhas.add(campos);
            lista.add(new ClientePJ(campos[1], campos[3], campos[4], campos[2], campos[0], formato.parse(campos[5]),  listaFrotas));
            linha = br.readLine();
        }
        return "ClientePJ lido com sucesso!";
    }
}
