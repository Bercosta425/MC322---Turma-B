package padrao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main{
        public static void main(String[] args) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Veiculo Gol_mil_branco = new Veiculo("BRA2019", "Volkswagen", "Gol mil Branco", 1980);
                Date dataLicenca = new Date(2002, Calendar.NOVEMBER, 9);
                Date dataNascimento = new Date(2010, Calendar.DECEMBER, 9);
                Date dataFundacao = new Date(2020, Calendar.DECEMBER, 18);
                List<Veiculo> listaVeiculos = new ArrayList<>();

                Cliente cliente = new Cliente("Jose", "Rua do Jose", listaVeiculos);
                ClientePF clientePf = new ClientePF("Pedro", "Rua do Pedro", listaVeiculos, dataLicenca, "Doutorado em Física", "Muito alta", "280.012.389-38", dataNascimento);
                ClientePJ clientePj = new ClientePJ("Empresa", "Rua da Empresa", listaVeiculos, "51.174.235/0001-30", dataFundacao);
                List<Cliente> listaClientes = new ArrayList<>();

                List<Sinistro> listaSinistros = new ArrayList<>();
                //Instanciação de Seguradora
                Seguradora seguradora1 = new Seguradora("Seguradora", "99999999", "segurado@novas.com", "Rua da seguradora", listaSinistros, listaClientes);
                Sinistro sinistro = new Sinistro(1234, "17/02/2010", "Rua do Sinistro", seguradora1, clientePf);
                listaClientes.add(clientePf);
                listaClientes.add(clientePj);
                listaSinistros.add(sinistro);

                //Cadastro e remoção de um clientePF
                if(seguradora1.cadastrarCliente(clientePf)){
                        System.out.println("Cadastrou");
                        System.out.println(seguradora1.getListaClientes());
                }
                else{
                        System.out.println("Não cadastrou");
                        System.out.println(seguradora1.getListaClientes());
                }

                if(seguradora1.removerCliente(clientePf)){
                        System.out.println("Removeu");
                        System.out.println(seguradora1.getListaClientes());
                }
                else{
                        System.out.println("Não removeu");
                        System.out.println(seguradora1.getListaClientes());
                }

                //Métodos para validar CPF e CNPJ
                if(clientePf.validarCPF(clientePf.getCpf())){
                        System.out.println("CPF validado");
                }
                else{
                        System.out.println("CPF não validado");
                }
                if(clientePj.validarCNPJ(clientePj.getCNPJ())){
                        System.out.println("CNPJ validado");
                }
                else{
                        System.out.println("CNPJ não validado");
                }

                //Adicionando um veiculo para cada cliente
                listaVeiculos.add(Gol_mil_branco);
                clientePj.setListaVeiculos(listaVeiculos);
                clientePf.setListaVeiculos(listaVeiculos);

                //Cadastrando ClientePF e Cliente PJ
                if(seguradora1.cadastrarCliente(clientePf) && seguradora1.cadastrarCliente(clientePj)){
                        System.out.println("Cadastrou");
                        System.out.println(seguradora1.getListaClientes());
                }
                else{
                        System.out.println("Não cadastrou");
                        System.out.println(seguradora1.getListaClientes());
                }

                //Print para método toString de cada classe
                System.out.println(Gol_mil_branco.toString());
                //System.out.println(seguradora1.toString());
                //System.out.println(clientePf.toString());
                //System.out.println(clientePj.toString());
                //System.out.println(sinistro.toString());
                //System.out.println(cliente.toString());

                //listarClientes, visualizarSinistro(cliente: String)
                // e listarSinistros();

                /*System.out.println(seguradora1.listarClientes("ClientePJ"));
                System.out.println(seguradora1.listarClientes("ClientePF"));
                System.out.println(seguradora1.visualizarSinistro(clientePj.getNome()));
                System.out.println(seguradora1.listarSinistros());*/


                //Implementação do método System.in para coleta de dados de um cliente:
                System.out.println("Digite o novo cliente");
                String nome = scanner.nextLine();
                System.out.println("Digite o endereco deste");
                String endereco = scanner.nextLine();
                System.out.println("Quantos veiculos este possue:");
                int j = scanner.nextInt();
                scanner.nextLine();
                for(int i = 1; i < j+1; i++){
                        System.out.println("Digite a placa do carro" + i);
                        String placa = scanner.nextLine();
                        System.out.println("Digite a marca do carro" + i);
                        String marca = scanner.nextLine();
                        System.out.println("Digite o modelo do carro" + i);
                        String modelo = scanner.nextLine();
                        System.out.println("Digite o ano de fabricação do carro" + i);
                        int anoFabricacao = scanner.nextInt();
                        scanner.nextLine();
                        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
                        listaVeiculos.add(veiculo);
                }
                System.out.println("Digite a data que a licenca foi tirada no formato dd/MM/yyyy:");
                Date dataLicenca2 = new Date(10, 10 , 2);
                try {
                        String dataLicenca1 = scanner.nextLine();
                        dataLicenca2 = formato.parse(dataLicenca1);
                } catch (ParseException e) {
                        System.out.println("Formato de data inválido. Por favor, insira a data no formato dd/MM/yyyy:");
                }
                System.out.println("Digite a educacao deste cliente:");
                String educacao = scanner.nextLine();
                System.out.println("Digite a classe economica deste pessoa:");
                String classeEconomica = scanner.nextLine();
                System.out.println("Digite o CPF deste cliente:");
                String cpf = scanner.nextLine() ;
                System.out.println("Digite a data de nascimento desta pessoa no formato dd/MM/yyyy:");
                String dataNascimento1 = scanner.nextLine();
                Date dataNascimento2 = formato.parse(dataNascimento1);

                ClientePF cliente_novo = new ClientePF(nome, endereco, listaVeiculos, dataLicenca2, educacao, classeEconomica, cpf, dataNascimento2);
                System.out.println("O cliente registrado foi:");
                System.out.println(cliente_novo.toString());

        }
}

