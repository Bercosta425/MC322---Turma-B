package Arquivos;

import Classes.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArquivoSeguro implements l_Arquivo<Seguro> {
    @Override
    public Boolean gravarArquivo() {
        return null;
    }

    @Override
    public String lerArquivo(List<Seguro> lista) throws IOException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        File file = new File("src/Arquivos/lab06-seguradora_arquivos_v2/seguros.csv");
        File file1 = new File("src/Arquivos/lab06-seguradora_arquivos_v2/segurosPF.csv");
        File file2 = new File("src/Arquivos/lab06-seguradora_arquivos_v2/segurosPJ.csv");

        String demilitador = ",";
        List<String[]> linhas = new ArrayList<>();
        List<Condutor> listaCondutor = new ArrayList<>();
        List<Sinistro> listaSinistro = new ArrayList<>();


        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha = br.readLine();
        while (linha != null) {
            if(linha.equals("DATA_INI,DATA_FIM,CNPJ_SEGURADORA,TIPO")){
                linha = br.readLine();
                continue;
            }
            String[] campos = linha.split(demilitador);
            linhas.add(campos);

            //Leitura para cliente PF
            if(campos[3].equals("PF")){
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                String linha1 = br.readLine();
                while (linha != null) {
                    if (linha.equals("CNPJ_SEGURADORA,PLACA_VEICULO,CPF_CLIENTE")) {
                        linha = br.readLine();
                        continue;
                    }
                    String[] campos1 = linha.split(demilitador);
                    linhas.add(campos1);
                    lista.add(new SeguroPf(formato.parse(campos[0]), formato.parse(campos[1]), GravarArquivo.getSeguradora(campos[2]), listaSinistro, listaCondutor, GravarArquivo.getSeguradora(campos[2]).getClientePF(campos1[2]).getVeiculo(campos1[1]), GravarArquivo.getSeguradora(campos[2]).getClientePF(campos1[2])));
                }
            }
            else if(campos[3].equals("PJ")){
                BufferedReader br1 = new BufferedReader(new FileReader(file2));
                String linha1 = br.readLine();
                while (linha != null) {
                    if (linha.equals("CNPJ_SEGURADORA,FROTA_CODE,CNPJ_CLIENTEPJ")) {
                        linha = br.readLine();
                        continue;
                    }
                    String[] campos1 = linha.split(demilitador);
                    linhas.add(campos1);
                    lista.add(new SeguroPj(formato.parse(campos[0]), formato.parse(campos[1]), GravarArquivo.getSeguradora(campos[2]), listaSinistro, listaCondutor, GravarArquivo.getSeguradora(campos[2]).getClientePJ(campos1[2]).getFrota(campos1[1]), GravarArquivo.getSeguradora(campos[2]).getClientePJ(campos1[2])));
                }
            }
        }
        return "Arquivo lido com sucesso!";
    }
}
