package Arquivos;

import Classes.ClientePF;
import Classes.Veiculo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArquivoClientePF implements l_Arquivo<ClientePF>{
    @Override
    public Boolean gravarArquivo() {
        return null;
    }

    @Override
    public String lerArquivo(List<ClientePF> lista) throws IOException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        File file = new File("src/Arquivos/lab06-seguradora_arquivos_v2/clientesPF.csv");
        String demilitador = ",";
        List<String[]> linhas = new ArrayList<>();
        List<Veiculo> listaVeiculo = new ArrayList<>();

        //Cria lista complementar de veiculos para adicionar ao cliente
        for (File f : file.listFiles()) {
            if (f.getName().endsWith("veiculos.csv")) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String linha = br.readLine();
                while (linha != null) {
                    String[] campos = linha.split(demilitador);
                    linhas.add(campos);
                    listaVeiculo.add(new Veiculo(campos[0], campos[1], campos[2], Integer.parseInt(campos[3])));
                }
            }
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha = br.readLine();
        while (linha != null) {
            if(linha.equals("CPF_CLIENTE,NOME_CLIENTE,TELEFONE_CLIENTE,ENDERECO_CLIENTE,EMAIL_CLIENTE,SEXO,ENSINO,DATA_NASCIMENTO,PLACA_VEICULO_CLIENTE1")){
                linha = br.readLine();
                continue;
            }
            List<Veiculo> listaVeiculo2 = new ArrayList<>();
            String[] campos = linha.split(demilitador);
            linhas.add(campos);
            for(int i = 0; i < listaVeiculo.size(); i++){
                if(listaVeiculo.get(i).getPlaca().equals(campos[8])){
                    listaVeiculo2.add(listaVeiculo.get(i));
                }
            }
            lista.add(new ClientePF(campos[1], campos[3], campos[4], campos[2], campos[6], campos[5], campos[0], formato.parse(campos[7]), listaVeiculo2));
            linha = br.readLine();
        }
        return "ClientePF lido com sucesso!";
    }
}
