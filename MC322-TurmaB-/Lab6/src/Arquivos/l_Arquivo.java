package Arquivos;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface l_Arquivo<T> {
    Boolean gravarArquivo();
    String lerArquivo(List<T> lista, String path) throws IOException, ParseException;
}
