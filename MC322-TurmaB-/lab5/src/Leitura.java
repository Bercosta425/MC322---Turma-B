import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//Classe para leitura de objetos
public class Leitura {
    static Cliente leClientePf() throws ParseException {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Digite o nome do novo cliente");
        String nome = scanner.nextLine();
        while(!Validacao.validarNOME(nome)){
            System.out.println("Digite um nome apenas com letras, digite novamente o novo cliente:");
            nome = scanner.nextLine();
        }
        System.out.println("Digite o endereco deste");
        String endereco = scanner.nextLine();
        while(!Validacao.validarENDERECO(nome)){
            System.out.println("Digite um endereco apenas com letras, digite novamente o novo cliente:");
            endereco = scanner.nextLine();
        }
        System.out.println("Digite o email deste");
        String email = scanner.nextLine();
        while(!Validacao.validarENDERECO(nome)){
            System.out.println("Digite um email válido");
            email = scanner.nextLine();
        }
        System.out.println("Digite o telefone deste");
        String telefone = scanner.nextLine();
        while(!Validacao.validarENDERECO(nome)){
            System.out.println("Digite um telefone apenas com letras, digite novamente o novo cliente:");
            telefone = scanner.nextLine();
        }
        System.out.println("Quantos veiculos este possue:");
        int j = scanner.nextInt();
        for(int i = 1; i < j+1; i++){
            Veiculo veiculo = leVeiculo();
            listaVeiculos.add(veiculo);
        }
        System.out.println("Digite a educacao deste cliente:");
        String educacao = scanner.nextLine();
        while(!Validacao.validarEDUCACAO(nome)){
            System.out.println("Digite uma educacao apenas com letras, digite novamente a educacao:");
            educacao = scanner.nextLine();
        }
        System.out.println("Digite o genero deste cliente:");
        String genero = scanner.nextLine();
        while(!Validacao.validarPLACA(genero)){
            System.out.println("Digite um genero apenas com letras, digite novamente o genero:");
            genero = scanner.nextLine();
        }

        System.out.println("Digite o CPF deste cliente:");
        String cpf = scanner.nextLine();
        while(!Validacao.validarCPF(cpf)){
            System.out.println("Digite um CPF válido, digite novamente:");
            cpf = scanner.nextLine();
        }
        System.out.println("Digite a data de nascimento desta pessoa no formato dd/MM/yyyy:");
        String dataNascimento1 = scanner.nextLine();
        Date dataNascimento2 = formato.parse(dataNascimento1);

        ClientePF cliente_novo = new ClientePF (nome, endereco, email, telefone, educacao, genero, cpf, dataNascimento2, listaVeiculos);
        System.out.println("O cliente registrado foi:");
        System.out.println(cliente_novo.toString());
        return cliente_novo;
    }
    static Cliente leClientePj() throws ParseException {
        List<Frota> listaFrota = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Digite o nome do novo cliente PJ");
        String nome = scanner.nextLine();
        while(!Validacao.validarNOME(nome)){
            System.out.println("Digite um nome apenas com letras, digite novamente:");
            nome = scanner.nextLine();
        }
        System.out.println("Digite o email do novo cliente PJ");
        String email = scanner.nextLine();
        while(!Validacao.validarNOME(email)){
            System.out.println("Digite um email apenas com letras, digite novamente:");
            email = scanner.nextLine();
        }
        System.out.println("Digite o telefone do novo cliente PJ");
        String telefone = scanner.nextLine();
        while(!Validacao.validarNOME(telefone)){
            System.out.println("Digite um telefone apenas com letras, digite novamente:");
            telefone = scanner.nextLine();
        }
        System.out.println("Digite o endereco deste");
        String endereco = scanner.nextLine();
        while(!Validacao.validarENDERECO(endereco)){
            System.out.println("Digite um endereco apenas com letras, digite novamente o novo endereco:");
            endereco = scanner.nextLine();
        }
        System.out.println("Quantas frotas este possue:");
        int j = scanner.nextInt();
        scanner.nextLine();
        for(int i = 1; i < j+1; i++){
            Frota frota = leFrota();
            listaFrota.add(frota);
        }
        System.out.println("Digite a data de fundacao no formato dd/MM/yyyy:");
        String dataFundacao1 = scanner.nextLine();
        Date data = formato.parse(dataFundacao1);
        System.out.println("Digite o CNPJ deste cliente:");
        String CNPJ = scanner.nextLine();
        while(!Validacao.validarCNPJ(CNPJ)){
            System.out.println("Digite um CNPJ válido, digite novamente:");
            CNPJ = scanner.nextLine();
        }
        System.out.println("Digite a quantidade de funcionarios: ");
        int qtdfuncionarios = scanner.nextInt();


        ClientePJ cliente_novo = new ClientePJ (nome, endereco, email, telefone, CNPJ, data, listaFrota, qtdfuncionarios);
        System.out.println("O cliente registrado foi:");
        System.out.println(cliente_novo.toString());
        return cliente_novo;
    }
    static Frota leFrota(){
        Scanner scanner = new Scanner(System.in);
        List<Veiculo> listaVeiculos = new ArrayList<>();
        System.out.println("Digite o código da frota");
        String code = scanner.nextLine();
        while(!Validacao.validarPLACA(code)){
            System.out.println("Digite uma code com letras e números, digite novamente:");
            code = scanner.nextLine();
        }

        System.out.println("Quantos veículos estão na frota:");
        int j = scanner.nextInt();
        scanner.nextLine();
        for(int i = 1; i < j+1; i++){
            Veiculo veiculo = leVeiculo();
            listaVeiculos.add(veiculo);
        }
        Frota frota = new Frota(code, listaVeiculos);
        return frota;
    }
    static Veiculo leVeiculo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a placa do veiculo");
        String code = scanner.nextLine();
        while(!Validacao.validarPLACA(code)){
            System.out.println("Digite uma placa válida, digite novamente:");
            code = scanner.nextLine();
        }
        System.out.println("Digite a marca do veiculo");
        String marca = scanner.nextLine();
        while(!Validacao.validarMARCA(marca)){
            System.out.println("Digite uma marca válida, digite novamente:");
            marca = scanner.nextLine();
        }
        System.out.println("Digite o modelo do veiculo");
        String modelo = scanner.nextLine();
        while(!Validacao.validarMODELO(modelo)){
            System.out.println("Digite um modelo apenas com letras, digite novamente:");
            modelo = scanner.nextLine();
        }
        System.out.println("Digite o ano de fabricacao do veiculo");
        String ano1 = scanner.nextLine();
        int ano = Integer.parseInt(ano1);
        while(!Validacao.validarANOFABRICACAO(ano1)){
            System.out.println("Digite um ano de fabricação válido:");
            ano1 = scanner.nextLine();
            ano = Integer.parseInt(ano1);
        }
        Veiculo Gol_mil_branco = new Veiculo(code, marca, modelo, ano);
        return Gol_mil_branco;
    }
    static Sinistro leSinistro(List<Seguradora> listaSeguradora) throws ParseException {
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
                        Sinistro sinistro = new Sinistro (data2, endereco, seguro1);
                        return sinistro;
                    }
                }
            }
        }
        Sinistro nada = null;
        return nada;
    }
    static Sinistro leSinistro(Seguradora seguradora) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Digite o id do seguro Referente:");
        String seguro2 = scanner.nextLine();
        int seguro = Integer.parseInt(seguro2);

        System.out.println("Digite a data que ocorreu o sinistro");
        String data1 = scanner.nextLine();
        Date data2 = formato.parse(data1);

        System.out.println("Digite o endereco do sinistro");
        String endereco = scanner.nextLine();
        while(!Validacao.validarENDERECO(endereco)){
            System.out.println("Digite um endereco apenas com letras, digite novamente o endereço:");
            endereco = scanner.nextLine();
        }

        for(Seguro seguro1 : seguradora.getListaSeguros()){
            if(seguro1.getId() == seguro){
                return new Sinistro(data2, endereco, seguro1);
            }
            else{
                System.out.println("O Seguro não existe!");
                return null;
            }
        }

        return null;
    }
    static Seguradora leSeguradora(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CNPJ da seguradora");
        String cnpj = scanner.nextLine();
        while(!Validacao.validarCNPJ(cnpj)){
            System.out.println("Digite um cnpj válido:");
            cnpj = scanner.nextLine();
        }
        System.out.println("Digite o nome da seguradora");
        String nome = scanner.nextLine();
        while(!Validacao.validarNOME(nome)){
            System.out.println("Digite um nome apenas com letras, digite novamente:");
            nome = scanner.nextLine();
        }
        System.out.println("Digite o telefone da seguradora");
        String telefone = scanner.nextLine();
        while(!Validacao.validarTELEFONE(telefone)){
            System.out.println("Digite um telefone apenas com letras, digite novamente:");
            telefone = scanner.nextLine();
        }
        System.out.println("Digite o endereco da seguradora");
        String endereco = scanner.nextLine();
        while(!Validacao.validarENDERECO(endereco)){
            System.out.println("Digite um endereco apenas com letras, digite novamente:");
            endereco = scanner.nextLine();
        }
        System.out.println("Digite o email da seguradora");
        String email = scanner.nextLine();
        while(!Validacao.validarEMAIL(email)){
            System.out.println("Digite um email valido, digite novamente:");
            email = scanner.nextLine();
        }
        List<Cliente> listaClientes = new ArrayList<>();
        List<Seguro> listaSeguros = new ArrayList<>();
        Seguradora seguradora = new Seguradora(cnpj, nome, telefone, email, endereco, listaClientes, listaSeguros);

        return seguradora;
    }
    static SeguroPf leSeguroPf(List<Seguradora> listaSeguradora) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Seguradora seguradora1 = null;
        System.out.println("Digite o CNPJ da seguradora referente;");
        String cnpj = scanner.nextLine();
        while(!Validacao.validarCNPJ(cnpj)){
            System.out.println("Digite um cnpj válido:");
            cnpj = scanner.nextLine();
        }
        for(Seguradora seguradora : listaSeguradora){
            if(seguradora.getCNPJ().equals(cnpj)){
                seguradora1 = seguradora;
            }
        }


        System.out.println("Digite a data de inicio do seguro no formato dd/MM/yyyy:");
        String dataInicio = scanner.nextLine();
        Date datainicio = formato.parse(dataInicio);

        System.out.println("Digite a data de fim do seguro no formato dd/MM/yyyy:");
        String dataFim = scanner.nextLine();
        Date datafim = formato.parse(dataFim);

        System.out.println("Digite as informações do veiculo do seguro:");
        Veiculo veiculo = leVeiculo();

        ClientePF cliente1 = null;
        System.out.println("Digite o cpf do cliente:");
        String cpf = scanner.nextLine();
        for(Cliente cliente : seguradora1.getListaClientes()){
            while((cliente1 = Validacao.validarCPF2(cpf, seguradora1.getListaClientes())) == null){
                System.out.println("Digite um cpf válido de um cliente:");
                 cpf = scanner.nextLine();
            }
        }

        List<Sinistro> listaSinistro = new ArrayList<>();
        List<Condutor> listaCondutor = new ArrayList<>();

    return new SeguroPf(datainicio, datafim, seguradora1,  listaSinistro,  listaCondutor, veiculo, cliente1);

    }
    static SeguroPf leSeguroPf(Seguradora seguradora) throws ParseException {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite a data de inicio do seguro no formato dd/MM/yyyy:");
        String dataInicio = scanner.nextLine();
        Date datainicio = Validacao.converterStringParaData(dataInicio, "dd/MM/yyyy");

        System.out.println("Digite a data de fim do seguro no formato dd/MM/yyyy:");
        String dataFim = scanner.nextLine();
        Date datafim = Validacao.converterStringParaData(dataFim, "dd/MM/yyyy");

        System.out.println("Digite as informações do veiculo do seguro:");
        Veiculo veiculo = leVeiculo();


        System.out.println("Digite o cpf do cliente que receberá o seguro:");
        String cpf = scanner.nextLine();
        ClientePF cliente1;
        while((cliente1 = Validacao.validarCPF2(cpf, seguradora.getListaClientes())) == null){
            System.out.println("Digite um cpf válido de um cliente:");
             cpf = scanner.nextLine();
        }

        List<Sinistro> listaSinistro = new ArrayList<>();
        List<Condutor> listaCondutor = new ArrayList<>();

        return new SeguroPf(datainicio, datafim, seguradora,  listaSinistro,  listaCondutor, veiculo, cliente1);


    }
    static SeguroPj leSeguroPj(List<Seguradora> listaSeguradora) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Seguradora seguradora1 = null;
        System.out.println("Digite o CNPJ da seguradora referente;");
        String cnpj = scanner.nextLine();
        while(!Validacao.validarCNPJ(cnpj)){
            System.out.println("Digite um cnpj válido:");
            cnpj = scanner.nextLine();
        }
        for(Seguradora seguradora : listaSeguradora){
            if(seguradora.getCNPJ().equals(cnpj)){
                seguradora1 = seguradora;
            }
        }

        System.out.println("Digite a data de inicio do seguro no formato dd/MM/yyyy:");
        String dataInicio = scanner.nextLine();
        Date datainicio = formato.parse(dataInicio);

        System.out.println("Digite a data de fim do seguro no formato dd/MM/yyyy:");
        String dataFim = scanner.nextLine();
        Date datafim = formato.parse(dataFim);

        System.out.println("Digite as informações da frota do seguro:");
        Frota frota = leFrota();

        System.out.println("Digite o CNPJ do cliente:");
        ClientePJ cliente1;
        String cnpj1 = scanner.nextLine();
        while((cliente1 = Validacao.validarCNPJ2(cnpj, seguradora1.getListaClientes())) == null){
                   System.out.println("Digite um cnpj válido de um cliente:");
                    cnpj1 = scanner.nextLine();
        }

        List<Sinistro> listaSinistro = new ArrayList<>();
        List<Condutor> listaCondutor = new ArrayList<>();

        return new SeguroPj(datainicio, datafim, seguradora1,  listaSinistro,  listaCondutor, frota, cliente1);

    }
    static Condutor leCondutor() throws ParseException {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        List<Sinistro> listaSinistro = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Digite o nome do novo cliente");
        String nome = scanner.nextLine();
        while(!Validacao.validarNOME(nome)){
            System.out.println("Digite um nome apenas com letras, digite novamente o novo cliente:");
            nome = scanner.nextLine();
        }
        System.out.println("Digite o endereco deste");
        String endereco = scanner.nextLine();
        while(!Validacao.validarENDERECO(nome)){
            System.out.println("Digite um endereco apenas com letras, digite novamente o novo cliente:");
            endereco = scanner.nextLine();
        }
        System.out.println("Digite o email deste");
        String email = scanner.nextLine();
        while(!Validacao.validarENDERECO(nome)){
            System.out.println("Digite um email válido");
            email = scanner.nextLine();
        }
        System.out.println("Digite o telefone deste");
        String telefone = scanner.nextLine();
        while(!Validacao.validarENDERECO(nome)){
            System.out.println("Digite um telefone apenas com letras, digite novamente o novo cliente:");
            telefone = scanner.nextLine();
        }


        System.out.println("Digite o CPF deste cliente:");
        String cpf = scanner.nextLine();
        while(!Validacao.validarCPF(cpf)){
            System.out.println("Digite um CPF válido, digite novamente:");
            cpf = scanner.nextLine();
        }
        System.out.println("Digite a data de nascimento desta pessoa no formato dd/MM/yyyy:");
        String dataNascimento1 = scanner.nextLine();
        Date dataNascimento2 = formato.parse(dataNascimento1);

        Condutor condutor = new Condutor (cpf, nome, telefone, email, endereco, dataNascimento2, listaSinistro);
        System.out.println("O cliente registrado foi:");
        System.out.println(condutor.toString());
        return condutor;
    }

}
