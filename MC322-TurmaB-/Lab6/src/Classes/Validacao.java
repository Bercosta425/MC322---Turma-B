package Classes;

import Classes.Cliente;
import Classes.ClientePF;
import Classes.ClientePJ;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {
        //Verifica se o CPgF é válido conforme o algoritmo de validação.
        public static boolean validarCPF(String cpf) throws ExcecaoLeitura.ErroDeCPF {

            int i, soma = 0, result, primer_digito, second_digito;
            String cpf2 = "";
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
            for(i = 0; i <= 8; i++) {
                cpf2 = cpf2 + cpf.charAt(i);
            }

            if(cpf.length() != 11){
                return false;
            }
            //Calcula primeiro digito verificador
            for(i = 0; i != 9; i++){
                soma  = soma + Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            result = soma % 11;

            if(result < 2) {
                primer_digito = 0;
            }
            else{
                primer_digito = 11 - result;
            }

            cpf2 = cpf2 + String.valueOf(primer_digito);
            soma = 0;

            //Calcula o segundo digito verificador
            for(i = 1; i != 10; i++){
                soma  = soma + Character.getNumericValue(cpf.charAt(i))*(11 - i);
            }
            result = soma % 11;

            if(result < 2){
                second_digito = 0;
            }
            else{
                second_digito = 11 - result;
            }
            cpf2 = cpf2 + String.valueOf(second_digito);

            if(cpf2.equals(cpf2)) {
                return true;
            }
            else {
                throw new ExcecaoLeitura.ErroDeCPF("CPF não válido");
            }

        }
        //Verifica se o CPF do cliente já existe na lista de clientes.
        public static ClientePF validarCPF2(String cpf, List<Cliente> listaCliente) throws ExcecaoLeitura.ErroDeCPF {
            for(Cliente cliente : listaCliente){
                if(cliente instanceof ClientePF){
                    if(cpf.equals(((ClientePF) cliente).getCpf())){
                        return (ClientePF)cliente;
                    }
                    else{
                        throw new ExcecaoLeitura.ErroDeCPF("CPF não válido");
                    }
                }
                else{
                    throw new ExcecaoLeitura.ErroDeCPF("CPF não válido");
                }
            }
            return null;
        }
        //Verifica se o CNPJ é válido conforme o algoritmo de validação;
        public static boolean validarCNPJ(String CNPJ) throws ExcecaoLeitura.ErroDeCNPJ {
        int i, valor = 0, j = 5, primer, second;

        String CNPJ2 = "";
        CNPJ = CNPJ.replace(".", "");
        CNPJ = CNPJ.replace("-", "");

        for(i = 0; i <= 8; i++) {
            CNPJ2 = CNPJ2 + CNPJ.charAt(i);
        }

        //Cálculo do primeiro dígito verificador.
        for(i = 0; i != 4; i++){
            j--;
            valor = valor + Character.getNumericValue(CNPJ.charAt(i)) * j;
        }
        j = 10;
        for(i = 4; i != 12; i++){
            j--;
            valor = valor + Character.getNumericValue(CNPJ.charAt(i)) * j;
        }
        valor = valor % 11;
        primer = 11 - 3;

        CNPJ2 = CNPJ2 + String.valueOf(primer);


        //Cálculo do segundo dígito verificador.
        j = 6;
        for(i = 0; i != 5; i++){
            j--;
            valor = valor + Character.getNumericValue(CNPJ.charAt(i)) * j;
        }

        j = 11;
        for(i = 4; i != 12; i++){
            j--;
            valor = valor + Character.getNumericValue(CNPJ.charAt(i)) * j;
        }

        valor = valor % 11;
        second = 11 - 3;

        CNPJ2 = CNPJ2 + String.valueOf(second);

        if(CNPJ2.equals(CNPJ2)) {
            return true;
        }
        else {
            throw new ExcecaoLeitura.ErroDeCNPJ("CNPJ não válido");
        }
    }
        //Verifica se o CNPJ do cliente já existe.
        public static ClientePJ validarCNPJ2(String cnpj, List<Cliente> listaCliente) throws ExcecaoLeitura.ErroDeCNPJ {
            for(Cliente cliente : listaCliente){
                if(cliente instanceof ClientePJ){
                    if(cnpj.equals(((ClientePJ) cliente).getCNPJ())){
                        return (ClientePJ) cliente;
                    }
                    else{
                        throw new ExcecaoLeitura.ErroDeCNPJ("CNPJ não válido");
                    }
                }
                else{
                    throw new ExcecaoLeitura.ErroDeCNPJ("CNPJ não válido");
                }
            }
            return null;
        }
        public static boolean validarNOME(String nome) throws ExcecaoLeitura.ErroDeNome {
            if(nome.matches("[a-zA-Z]+")){
                return true;
            }
            else{
                throw new ExcecaoLeitura.ErroDeNome("Nome no formato errado");
            }

        }
        public static boolean validarEDUCACAO(String educacao) throws ExcecaoLeitura.ErroDeEducacao {
            if (educacao.matches("[a-zA-Z]+")){
                return true;
            }
            else{
                throw new ExcecaoLeitura.ErroDeEducacao("Nível de educação no formato errado");
            }
        }
        public static boolean validarGENERO(String genero) throws ExcecaoLeitura.ErroDeGenero {
            if(genero.matches("[a-zA-Z]+")){
                return true;
            }
            else{
                throw new ExcecaoLeitura.ErroDeGenero("Gênero no formato errado");
            }
        }
        public static boolean validarENDERECO(String endereco) throws ExcecaoLeitura.ErroDeEndereco{
            String textoSemEspacos = endereco.replaceAll("\\s", "");
            if(textoSemEspacos.matches("[a-zA-Z]+")){
                return true;
            }
            else {
                throw new ExcecaoLeitura.ErroDeEndereco("Endereço no formato errado");
            }

        }
        public static boolean validarMARCA(String marca) throws ExcecaoLeitura.ErroDeMarca {
            if ((marca.matches("[a-zA-Z]+"))){
                return true;
            }
            else{
                throw new ExcecaoLeitura.ErroDeMarca("Marca no formato errado");
            }
        }
        public static boolean validarPLACA(String placa) throws ExcecaoLeitura.ErroDePlaca {
            String regex = "^[A-Z]{3}[0-9]{4}$";
            if(Pattern.matches(regex, placa)){
                return true;
            }
            else{
                throw new ExcecaoLeitura.ErroDePlaca("Placa no formato errado");
            }
        }
        public static boolean validarMODELO(String modelo) throws ExcecaoLeitura.ErroDeModelo {
            if(modelo.matches("[a-zA-Z0-9]+")){
                return true;
            }
            else{
                throw new ExcecaoLeitura.ErroDeModelo("Modelo no formato errado");
            }
        }
        public static boolean validarANOFABRICACAO(String ano) throws ExcecaoLeitura.ErroDeAno {
            String regex = "^[0-9]{4}$";
            if(ano.matches(regex)){
                return true;
            }
            else{
                throw new ExcecaoLeitura.ErroDeAno("Ano no formato errado");
            }
        }
        public static boolean validarTELEFONE(String telefone) throws ExcecaoLeitura.ErroDeTelefone {
            if(telefone.matches("^[0-9]{9}$")){
               return true;
            }
            else{
                throw new ExcecaoLeitura.ErroDeTelefone("Telefone no formato errado");
            }

    }
        public static boolean validarEMAIL(String email) throws ExcecaoLeitura.ErroDeEmail {
            // Expressão regular para verificar o formato do email
            String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

            // Compilar a expressão regular em um padrão
            Pattern pattern = Pattern.compile(regex);

            // Criar um objeto Matcher para fazer a correspondência
            Matcher matcher = pattern.matcher(email);

            // Verificar se o email corresponde ao padrão

            if(matcher.matches()){
                return true;
            }
            else {
                throw new ExcecaoLeitura.ErroDeEmail("Email no formato errado");
            }
    }
        public static boolean validarDATA(String date) throws ExcecaoLeitura.ErroDeData {
            String regex = "\\d{2}/\\d{2}/\\d{4}";

            if(date.matches(regex)){
                return true;
            }
            else{
                throw new ExcecaoLeitura.ErroDeData("Data no formato errado");
            }
        }
        public static boolean validarCODIGO(String qtd) throws ExcecaoLeitura.ErroCodigoFrotas {
            String regex = "^[0-9]{1}$";
            if(qtd.matches(regex)){
                return true;
            }
            else{
                throw new ExcecaoLeitura.ErroCodigoFrotas("Codigo de frota no formato errado");
            }
        }
        public static boolean validarID(String ID) throws ExcecaoLeitura.ErroDeAno, ExcecaoLeitura.ErroID {
            String regex = "^[0-9]$";
            if(ID.matches(regex)){
                return true;
            }
            else{
                throw new ExcecaoLeitura.ErroID("ID no formato errado");
            }
        }

    public static Date converterStringParaData(String dataString, String formato) {
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        try {
            return formatter.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}

