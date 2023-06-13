package pacote;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {
        public static boolean validarCPF(String cpf){
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
                return false;
            }
        }
        public static boolean validarCNPJ(String CNPJ) {
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
            return false;
        }
    }
        public static boolean validarNOME(String nome){
            return (nome.matches("[a-zA-Z]+"));
        }
        public static boolean validarEDUCACAO(String educacao){
            return (educacao.matches("[a-zA-Z]+"));

        }
        public static boolean validarGENERO(String genero){
            return (genero.matches("[a-zA-Z]+"));
        }
        public static boolean validarCLASSE(String classe) {
            return (classe.matches("[a-zA-Z]+"));
        }
        public static boolean validarENDERECO(String endereco){
            return (endereco.matches("[a-zA-Z0-9]+"));
        }
        public static boolean validarMARCA(String marca){
            return (marca.matches("[a-zA-Z]+"));
        }
        public static boolean validarPLACA(String placa){
            return (placa.matches("[a-zA-Z]+"));
        }
        public static boolean validarMODELO(String modelo){
            return (modelo.matches("[a-zA-Z0-9]+"));
        }
        public static boolean validarANOFABRICACAO(String ano){
            return (ano.matches("[0-9]+"));
        }
        public static boolean validarTELEFONE(String telefone){
        return (telefone.matches("[0-9]+"));
    }

        public static boolean validarEMAIL(String email){
            // Expressão regular para verificar o formato do email
            String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

            // Compilar a expressão regular em um padrão
            Pattern pattern = Pattern.compile(regex);

            // Criar um objeto Matcher para fazer a correspondência
            Matcher matcher = pattern.matcher(email);

            // Verificar se o email corresponde ao padrão
            return matcher.matches();
    }

}

