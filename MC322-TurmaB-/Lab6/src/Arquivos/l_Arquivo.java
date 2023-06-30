package Arquivos;

import java.util.List;

public interface l_Arquivo<T> {
    Boolean gravarArquivo();
    String lerArquivo(List<T> lista);
}
