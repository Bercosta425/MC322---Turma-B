package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//Classe para leitura de objetos
public class Leitura {
    // Métodos com leitura de dados e suas exceções.
    public static ClientePF leClientePf(List<Cliente> listaClientes) {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        ClientePF cliente_novo = null;

        System.out.println("***** Lendo dados do novo cliente PF *****");
        while(cliente_novo == null){
            try {
                System.out.println("Entre com o nome do cliente, o endereço, o email, o telefone, a educação, o genero, o CPF, e a data de nascimento no formato dd/MM/AA");
                String nome = scanner.next();
                String endereco = scanner.next();
                String email = scanner.next();
                String telefone = scanner.next();
                String educacao = scanner.next();
                String genero = scanner.next();
                String cpf = scanner.next();
                String data_nascimento = scanner.next();
                Validacao.validarNOME(nome);
                Validacao.validarCPF(cpf);
                Validacao.validarCPF2(cpf, listaClientes);
                Validacao.validarENDERECO(endereco);
                Validacao.validarEMAIL(email);
                Validacao.validarTELEFONE(telefone);
                Validacao.validarEDUCACAO(educacao);
                Validacao.validarGENERO(genero);
                Validacao.validarDATA(data_nascimento);
                cliente_novo = new ClientePF(nome, endereco, email, telefone, educacao, genero, cpf, formato.parse(data_nascimento), listaVeiculos);
            }
            catch(ExcecaoLeitura.ErroDeNome erroDeNome){
                System.out.println(erroDeNome.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch(ExcecaoLeitura.ErroDeCPF erroDeCPF){
                System.out.println(erroDeCPF.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeEndereco erroDeEndereco){
                System.out.println(erroDeEndereco.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeEmail erroDeEmail){
                System.out.println(erroDeEmail.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeTelefone erroDeTelefone){
                System.out.println(erroDeTelefone.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeEducacao erroDeEducacao){
                System.out.println(erroDeEducacao.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeGenero erroDeGenero){
                System.out.println(erroDeGenero.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeData erroDeData){
                System.out.println(erroDeData.getMessage());
                System.out.println("Repita o processo de cadastro");
            }finally {
                scanner.close();
                System.out.println("Cliente cadastrado com sucesso!");
                return cliente_novo;
            }
        }
        return cliente_novo;
    }
    public static ClientePJ leClientePj(List<Cliente> listaClientes) {
        List<Frota> listaFrota = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        ClientePJ cliente_novo = null;
        System.out.println("***** Lendo dados do novo cliente PJ *****");
        while (cliente_novo == null){
            try{
                System.out.println("Entre com o nome do cliente, o endereço, o email, o telefone, o CNPJ,a data de fundação no formato dd/MM/AA, e a quantidade de funcionários");
                String nome = scanner.next();
                String endereco = scanner.next();
                String email = scanner.next();
                String telefone = scanner.next();
                String cnpj = scanner.next();
                String data_fundacao = scanner.next();
                int qtd_funcionarios = scanner.nextInt();
                Validacao.validarNOME(nome);
                Validacao.validarCNPJ(cnpj);
                Validacao.validarCNPJ2(cnpj, listaClientes);
                Validacao.validarENDERECO(endereco);
                Validacao.validarEMAIL(email);
                Validacao.validarTELEFONE(telefone);
                Validacao.validarDATA(data_fundacao);
            }
            catch (ExcecaoLeitura.ErroDeNome erroDeNome){
                System.out.println(erroDeNome.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeCNPJ erroDeCNPJ){
                System.out.println(erroDeCNPJ.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeEndereco erroDeEndereco){
                System.out.println(erroDeEndereco.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeEmail erroDeEmail){
                System.out.println(erroDeEmail.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeTelefone erroDeTelefone){
                System.out.println(erroDeTelefone.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeData erroDeData){
                System.out.println(erroDeData.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (InputMismatchException erroDeQTD_FUNCIONARIOS){
                System.out.println(erroDeQTD_FUNCIONARIOS.getMessage());
                System.out.println("Repita o processo de cadastro");
        }finally {
                scanner.close();
                System.out.println("Cliente cadastrado com sucesso!");
                return cliente_novo;
            }
        }
        return cliente_novo;
    }
    static Frota leFrota(){
        Scanner scanner = new Scanner(System.in);
        List<Veiculo> listaVeiculos = new ArrayList<>();
        Frota frota = null;
        System.out.println("***** Lendo dados da nova frota *****");
        while(frota == null){
            try{
                System.out.println("Entre com o código da frota");
                String codigo = scanner.next();
                Validacao.validarCODIGO(codigo);
                System.out.println("Você deseja cadastrar um veículo? (S/N)");
                String resposta = scanner.next();
                if(resposta.equals("S") || resposta.equals("s")){
                    System.out.println("Quantos veículos você deseja cadastrar?");
                    int qtd_veiculos = scanner.nextInt();
                    for(int i = 0; i < qtd_veiculos; i++){
                        Veiculo veiculo = leVeiculo();
                        listaVeiculos.add(veiculo);
                    }
                }
                else if(resposta.equals("N") || resposta.equals("n")){
                    System.out.println("Você não deseja cadastrar um veículo");
                }
                else{
                    System.out.println("Resposta inválida");
                }

                frota = new Frota(codigo, listaVeiculos);
            } catch (ExcecaoLeitura.ErroCodigoFrotas erroCodigoFrotas) {
                System.out.println(erroCodigoFrotas.getMessage());
                System.out.println("Repita o processo de cadastro");
            }finally {
                scanner.close();
                System.out.println("Frota cadastrada com sucesso!");
                return frota;
            }
        }
        return frota;
    }
    public static Veiculo leVeiculo(){
        Scanner scanner = new Scanner(System.in);
        Veiculo gol_mil_branco = null;
        System.out.println("***** Lendo dados do novo veículo *****");
        while (gol_mil_branco == null){
            try{
                System.out.println("Entre com o modelo do veículo, a marca, o ano de fabricação, a placa");
                String modelo = scanner.next();
                String marca = scanner.next();
                String ano_fabricacao = scanner.next();
                String placa = scanner.next();
                Validacao.validarMODELO(modelo);
                Validacao.validarMARCA(marca);
                Validacao.validarANOFABRICACAO(ano_fabricacao);
                Validacao.validarPLACA(placa);
                int numero = Integer.parseInt(ano_fabricacao);
                return gol_mil_branco = new Veiculo(modelo, marca, placa, numero);
            }
            catch(ExcecaoLeitura.ErroDeModelo erroDeModelo){
                System.out.println(erroDeModelo.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeMarca erroDeMarca){
                System.out.println(erroDeMarca.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDePlaca erroDePlaca){
                System.out.println(erroDePlaca.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeAno erroDeAnoFabricacao){
                System.out.println(erroDeAnoFabricacao.getMessage());
                System.out.println("Repita o processo de cadastro");
            }finally{
                scanner.close();
                System.out.println("Veículo cadastrado com sucesso!");
                return gol_mil_branco;
            }
        }
        return gol_mil_branco;
    }
    /*static Sinistro leSinistro(List<Seguradora> listaSeguradora) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Digite a qual seguradora é Referente:");
        String seguradora2 = scanner.nextLine();
        System.out.println("Digite o id do seguro Referente:");
        int seguro = scanner.nextInt();

        System.out.println("Digite a ID do sinistro");
        String ID = scanner.nextLine();
        
        System.out.println("Digite a data do sinistro");
        String data1 = scanner.nextLine();
        Date data2 = formato.parse(data1);
        System.out.println("Digite o endereco do sinistro");
        String endereco = scanner.nextLine();
        while(!Validacao.validarENDERECO(endereco)){
            System.out.println("Digite um endereco apenas com letras, digite novamente o novo cliente:");
            endereco = scanner.nextLine();
        }



        for(Seguradora seguradora3 : listaSeguradora){
            if(seguradora3.getNome().equals(seguradora2)){
                for(Seguro seguro1 : seguradora3.getListaSeguros()){
                    if(seguro1.getId() == seguro){
                        Sinistro sinistro = new Sinistro(data2, endereco, seguro1);
                        return sinistro;
                    }
                }
            }
        }
        Sinistro nada = null;
        return nada;
    }*/
    static Sinistro leSinistro(Seguradora seguradora){
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Sinistro sinistro = null;
        System.out.println("***** Lendo dados do novo sinistro *****");
        while(sinistro == null){
            try{
                System.out.println("Entre com o ID, a data do sinistro, o endereço do sinistro, e o seguro referente");
                String ID = scanner.next();
                String data1 = scanner.next();
                Date data2 = formato.parse(data1);
                String endereco = scanner.next();
                int seguro = scanner.nextInt();
                Validacao.validarDATA(data1);
                Validacao.validarENDERECO(endereco);
                Validacao.validarID(ID);
                int ID2 = Integer.parseInt(ID);

                //Verifica se o seguro realmente existe.
                for(Seguro seguro1 : seguradora.getListaSeguros()){
                    if(seguro1.getId() == seguro){
                        return new Sinistro(data2, endereco, seguro1);
                    }
                    else{
                        System.out.println("O Seguro não existe!");
                        return null;
                    }
                }


            }
            catch (ExcecaoLeitura.ErroDeData erroDeData){
                System.out.println(erroDeData.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeEndereco erroDeEndereco){
                System.out.println(erroDeEndereco.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroID erroID){
                System.out.println(erroID.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            finally{
                scanner.close();
                System.out.println("Sinistro cadastrado com sucesso!");
                return sinistro;
            }
        }
        return sinistro;
    }
    public static Seguradora leSeguradora(){
        Scanner scanner = new Scanner(System.in);
        Seguradora seguradora = null;
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        List<Seguro> listaSeguros = new ArrayList<Seguro>();



        System.out.println("***** Lendo dados da nova seguradora *****");
        while(seguradora == null){
            try{
                System.out.println("Entre com o nome da seguradora, o CNPJ, o endereço, o telefone e o email");
                String nome = scanner.next();
                String CNPJ = scanner.next();
                String endereco = scanner.next();
                String telefone = scanner.next();
                String email = scanner.next();
                Validacao.validarNOME(nome);
                Validacao.validarCNPJ(CNPJ);
                Validacao.validarENDERECO(endereco);
                Validacao.validarTELEFONE(telefone);
                Validacao.validarEMAIL(email);
                seguradora = new Seguradora(CNPJ, nome,telefone, email, endereco, listaClientes, listaSeguros);
            }
            catch (ExcecaoLeitura.ErroDeNome erroDeNome){
                System.out.println(erroDeNome.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeCNPJ erroDeCNPJ){
                System.out.println(erroDeCNPJ.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeEndereco erroDeEndereco){
                System.out.println(erroDeEndereco.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeTelefone erroDeTelefone){
                System.out.println(erroDeTelefone.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeEmail erroDeEmail){
                System.out.println(erroDeEmail.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            finally{
                scanner.close();
                System.out.println("Seguradora cadastrada com sucesso!");
                return seguradora;
            }
        }
        return seguradora;
    }
    public static SeguroPf leSeguroPf(List<Seguradora> listaSeguradora)  {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Seguradora seguradora1 = null;
        SeguroPf seguroPf = null;



        System.out.println("***** Lendo dados do novo seguro *****");
        while(seguroPf == null){
            try{
                System.out.println("Digite o CNPJ da seguradora referente, a data de inicio, a data de fim, e o o CPF do cliente que está gerando o seguro");
                String cnpj = scanner.nextLine();
                String dataInicio = scanner.nextLine();
                Date datainicio = Validacao.converterStringParaData(dataInicio, "dd/MM/yyyy");
                String dataFim = scanner.nextLine();
                Date datafim = Validacao.converterStringParaData(dataFim, "dd/MM/yyyy");
                String cpf = scanner.nextLine();
                Veiculo veiculo = null;
                ClientePF cliente1 = null;
                Validacao.validarCPF(cpf);
                Validacao.validarDATA(dataInicio);
                Validacao.validarDATA(dataFim);
                Validacao.validarCNPJ(cnpj);

                for(Seguradora seguradora : listaSeguradora){
                    if(seguradora.getCNPJ().equals(cnpj)){
                        seguradora1 = seguradora;
                    }
                }
                Validacao.validarCPF2(cpf, seguradora1.getListaClientes());
                Validacao.validarCNPJ2(cnpj, seguradora1.getListaClientes());
                for(Cliente cliente: seguradora1.getListaClientes()){
                    if(( (ClientePF) cliente).getCpf().equals(cpf)){
                        cliente1 = (ClientePF) cliente;
                    }
                    else{
                        throw new ExcecaoLeitura.ErroDeCPF("CPF já cadastrado");
                    }
                }

                List<Sinistro> listaSinistro = new ArrayList<>();
                List<Condutor> listaCondutor = new ArrayList<>();
                System.out.println("Você quer cadastrar um veiculo? (S/N)");
                String resposta = scanner.nextLine();
                if (resposta.equals("S")){
                    veiculo = leVeiculo();
                }
                else if(resposta.equals("N")){
                    veiculo = null;
                }
                System.out.println("Seguro cadastrado com sucesso!");
                seguroPf = new SeguroPf(datainicio, datafim, seguradora1,  listaSinistro,  listaCondutor, veiculo, cliente1);

                return seguroPf;
            }
            catch (ExcecaoLeitura.ErroDeCPF erroDeCPF){
                System.out.println(erroDeCPF.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeCNPJ erroDeCNPJ){
                System.out.println(erroDeCNPJ.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeData erroDeData){
                System.out.println(erroDeData.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            finally{
                scanner.close();

            }
        }
        return seguroPf;
    }
    static SeguroPf leSeguroPf(Seguradora seguradora) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Seguradora seguradora1 = null;
        SeguroPf seguroPf = null;



        System.out.println("***** Lendo dados do novo seguro *****");
        while(seguroPf == null){
            try{
                System.out.println("Digite o CNPJ da seguradora referente, a data de inicio, a data de fim, e o o CPF do cliente que está gerando o seguro");
                String cnpj = scanner.nextLine();
                String dataInicio = scanner.nextLine();
                Date datainicio = Validacao.converterStringParaData(dataInicio, "dd/MM/yyyy");
                String dataFim = scanner.nextLine();
                Date datafim = Validacao.converterStringParaData(dataFim, "dd/MM/yyyy");
                String cpf = scanner.nextLine();
                Veiculo veiculo = null;
                ClientePF cliente1 = null;
                Validacao.validarCPF(cpf);
                Validacao.validarDATA(dataInicio);
                Validacao.validarDATA(dataFim);
                Validacao.validarCNPJ(cnpj);

                Validacao.validarCPF2(cpf, seguradora1.getListaClientes());
                Validacao.validarCNPJ2(cnpj, seguradora1.getListaClientes());
                for(Cliente cliente: seguradora1.getListaClientes()){
                    if(( (ClientePF) cliente).getCpf().equals(cpf)){
                        cliente1 = (ClientePF) cliente;
                    }
                    else{
                        throw new ExcecaoLeitura.ErroDeCPF("CPF já cadastrado");
                    }
                }

                List<Sinistro> listaSinistro = new ArrayList<>();
                List<Condutor> listaCondutor = new ArrayList<>();
                System.out.println("Você quer cadastrar um veiculo? (S/N)");
                String resposta = scanner.nextLine();
                if (resposta.equals("S")){
                    veiculo = leVeiculo();
                }
                else if(resposta.equals("N")){
                    veiculo = null;
                }
                System.out.println("Seguro cadastrado com sucesso!");
                SeguroPf seguro = new SeguroPf(datainicio, datafim, seguradora1,  listaSinistro,  listaCondutor, veiculo, cliente1);
                seguro.toString();
                return seguro;
            }
            catch (ExcecaoLeitura.ErroDeCPF erroDeCPF){
                System.out.println(erroDeCPF.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeCNPJ erroDeCNPJ){
                System.out.println(erroDeCNPJ.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeData erroDeData){
                System.out.println(erroDeData.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            finally{
                scanner.close();
            }
        }
        return seguroPf;
    }
    public static SeguroPj leSeguroPj(List<Seguradora> listaSeguradora) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Seguradora seguradora1 = null;
        SeguroPj seguroPj = null;


        System.out.println("***** Lendo dados do novo seguro *****");
        while(seguroPj == null){
            try{
                System.out.println("Digite o CNPJ da seguradora referente, a data de inicio, a data de fim, e o o CPF do cliente que está gerando o seguro");
                String cnpj = scanner.nextLine();
                String dataInicio = scanner.nextLine();
                Date datainicio = Validacao.converterStringParaData(dataInicio, "dd/MM/yyyy");
                String dataFim = scanner.nextLine();
                Date datafim = Validacao.converterStringParaData(dataFim, "dd/MM/yyyy");
                String cpf = scanner.nextLine();
                Frota frota = null;
                ClientePJ cliente1 = null;
                Validacao.validarCPF(cpf);
                Validacao.validarDATA(dataInicio);
                Validacao.validarDATA(dataFim);
                Validacao.validarCNPJ(cnpj);

                for(Seguradora seguradora : listaSeguradora){
                    if(seguradora.getCNPJ().equals(cnpj)){
                        seguradora1 = seguradora;
                    }
                }
                Validacao.validarCPF2(cpf, seguradora1.getListaClientes());
                Validacao.validarCNPJ2(cnpj, seguradora1.getListaClientes());
                for(Cliente cliente: seguradora1.getListaClientes()){
                    if(( (ClientePJ) cliente).getCNPJ().equals(cpf)){
                        cliente1 = (ClientePJ) cliente;
                    }
                    else{
                        throw new ExcecaoLeitura.ErroDeCPF("CPF já cadastrado");
                    }
                }

                List<Sinistro> listaSinistro = new ArrayList<>();
                List<Condutor> listaCondutor = new ArrayList<>();
                System.out.println("Você quer cadastrar uma frota? (S/N)");
                String resposta = scanner.nextLine();
                if (resposta.equals("S")){
                    frota = leFrota();
                }
                else if(resposta.equals("N")){
                    frota = null;
                }
                SeguroPj seguro = new SeguroPj(datainicio, datafim, seguradora1,  listaSinistro,  listaCondutor, frota, cliente1);
                System.out.println("Seguro cadastrado com sucesso!");
                seguro.toString();
                return seguro;
            }
            catch (ExcecaoLeitura.ErroDeCPF erroDeCPF){
                System.out.println(erroDeCPF.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeCNPJ erroDeCNPJ){
                System.out.println(erroDeCNPJ.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeData erroDeData){
                System.out.println(erroDeData.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            finally{
                scanner.close();
            }
        }
        return seguroPj;
    }
    public static Condutor leCondutor(List<Seguradora> listaSeguradora) {
        List<Sinistro> listaSinistro = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Condutor condutor = null;



        System.out.println("***** Lendo dados do novo condutor *****");
        while(condutor == null){
            try{
                System.out.println("Digite o ID do seguro referente, o CNPJ da seguradora referente, CPF do condutor, o nome, o telefone, o email, o endereço e a data de nascimento");
                String idSeguro = scanner.nextLine();
                int id = Integer.parseInt(idSeguro);
                String cnpj = scanner.nextLine();
                String cpf = scanner.nextLine();
                String nome = scanner.nextLine();
                String telefone = scanner.nextLine();
                String email = scanner.nextLine();
                String endereco = scanner.nextLine();
                String dataNascimento = scanner.nextLine();
                Date dataNascimento2 = Validacao.converterStringParaData(dataNascimento, "dd/MM/yyyy");
                Validacao.validarCPF(cpf);
                Validacao.validarDATA(dataNascimento);
                Validacao.validarEMAIL(email);
                Validacao.validarTELEFONE(telefone);
                Validacao.validarNOME(nome);
                Validacao.validarENDERECO(endereco);
                Validacao.validarCNPJ(cnpj);

                //Verifica se o CPJ já foi cadastrado como condutor.
                for(Seguradora seguradora : listaSeguradora){
                    if(seguradora.getCNPJ().equals(cnpj)){
                        for(Seguro seguro : seguradora.getListaSeguros()){
                            if(seguro.getId() == id){
                                for(Condutor condutor1 : seguro.getListaCondutor()){
                                    if(condutor1.getCpf().equals(cpf)){
                                        throw new ExcecaoLeitura.ErroDeCPF("CPF já cadastrado");
                                    }
                                }
                            }
                        }
                    }
                }

                return new Condutor(cpf, nome, telefone, email, endereco, dataNascimento2, listaSinistro);
            }
            catch (ExcecaoLeitura.ErroDeCPF erroDeCPF){
                System.out.println(erroDeCPF.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeData erroDeData){
                System.out.println(erroDeData.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch(ExcecaoLeitura.ErroDeEmail erroDeEmail){
                System.out.println(erroDeEmail.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeTelefone erroDeTelefone){
                System.out.println(erroDeTelefone.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeNome erroDeNome){
                System.out.println(erroDeNome.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeEndereco erroDeEndereco){
                System.out.println(erroDeEndereco.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            catch (ExcecaoLeitura.ErroDeCNPJ erroDeCNPJ){
                System.out.println(erroDeCNPJ.getMessage());
                System.out.println("Repita o processo de cadastro");
            }
            finally{
                scanner.close();
                System.out.println("Condutor cadastrado com sucesso!");
                return condutor;
            }
        }
        return condutor;
    }

}
