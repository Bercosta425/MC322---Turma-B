package padrao;

public class Main {
	public static void main(String[] args){
		//Teste de métodos para a classe "Cliente"
		Cliente teste1 = new Cliente("Pedro", "280.012.389-38", "17/02/2003", "Rua blablabla", 20);
		System.out.println(teste1.toString());
		
		//Teste de para verificar validação de CPF. No caso, ele deveria retonar true.
		System.out.println(teste1.validarCPF(teste1.getCpf()));
		
		//Teste de métodos para a classe "Seguradora"
		Seguradora teste2 = new Seguradora("Seguradora", "99999999", "Seguradora@tututu.com", "Rua tututu");
		System.out.println(teste2.toString());
		
		//Teste de métodos para a classe "Sinistro"
		Sinistro teste3 = new Sinistro("01/01/2001", "Rua blablabla");
		Sinistro teste4 = new Sinistro("01/01/2002", "Rua blablabla2");
		
		//Teste para verificar se realmente foram criados dois IDs únicos. 
		System.out.println(teste3.toString());
		System.out.println(teste4.toString());
		
		//Teste de métodos para a classe "Veiculo"
		Veiculo teste5 = new Veiculo("JEC2013", "Volkswagen", "Gol Mil Branco");
		System.out.println(teste5.toString());
	}
}
