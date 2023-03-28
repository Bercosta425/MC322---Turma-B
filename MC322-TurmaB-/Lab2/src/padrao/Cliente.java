package padrao;

public class Cliente {
	private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private int idade;
    
    public Cliente(String nome, String cpf, String dataNascimento, String endereco, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.idade = idade;
    }

    
    // Métodos setters e getters
    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }
    
    public String getDataNascimento(){
        return dataNascimento;
    }

    public String getEndereco(){
        return endereco;
    }

    public int getIdade(){
        return idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String toString(){
        return "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nData de nascimento: " + getDataNascimento() + "\nIdade: " + getIdade();
    }

    public int length() {
		return 0;
	}
    
    //O método segue as instruções de verificação no documento do laboratório.
    public Boolean validarCPF(String cpf){
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
}
