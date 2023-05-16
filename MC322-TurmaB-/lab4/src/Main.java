import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Main{

        private static Cliente leClientePf() throws ParseException {
                List<Veiculo> listaVeiculos = new ArrayList<>();
                Scanner scanner = new Scanner(System.in);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Digite o novo cliente");
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
                System.out.println("Quantos veiculos este possue:");
                int j = scanner.nextInt();
                for(int i = 1; i < j+1; i++){
                        System.out.println("Digite a placa do carro " + i);
                        String placa = scanner.nextLine();
                        while(!Validacao.validarPLACA(nome)){
                                System.out.println("Digite uma placa apenas com letras e numeros, digite novamente a nova placa:");
                                nome = scanner.nextLine();
                        }
                        System.out.println("Digite a marca do carro " + i);
                        String marca = scanner.nextLine();
                        while(!Validacao.validarMARCA(marca)){
                                System.out.println("Digite uma marca  apenas com letras, digite novamente a nova marca:");
                                marca = scanner.nextLine();
                        }
                        System.out.println("Digite o modelo do carro " + i);
                        String modelo = scanner.nextLine();
                        while(!Validacao.validarMODELO(modelo)){
                                System.out.println("Digite um modelo apenas com letras, digite novamente o novo modelo:");
                                modelo = scanner.nextLine();
                        }
                        System.out.println("Digite o ano de fabricação do carro " + i);
                        int anoFabricacao = scanner.nextInt();
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
                System.out.println("Digite a classe economica deste pessoa:");
                String classeEconomica = scanner.nextLine();
                while(!Validacao.validarCLASSE(classeEconomica)){
                        System.out.println("Digite uma classe economica apenas com letras, digite novamente a classe economica:");
                        classeEconomica = scanner.nextLine();
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

                ClientePF cliente_novo = new ClientePF(nome, endereco, listaVeiculos, dataLicenca2, educacao, classeEconomica, cpf, dataNascimento2, genero);
                System.out.println("O cliente registrado foi:");
                System.out.println(cliente_novo.toString());
                return cliente_novo;
        }
        private static Cliente leClientePj() throws ParseException {
                List<Veiculo> listaVeiculos = new ArrayList<>();
                Scanner scanner = new Scanner(System.in);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Digite o novo cliente");
                String nome = scanner.nextLine();
                while(!Validacao.validarNOME(nome)){
                        System.out.println("Digite um nome apenas com letras, digite novamente:");
                        nome = scanner.nextLine();
                }
                System.out.println("Digite o endereco deste");
                String endereco = scanner.nextLine();
                while(!Validacao.validarENDERECO(endereco)){
                        System.out.println("Digite um endereco apenas com letras, digite novamente o novo endereco:");
                        endereco = scanner.nextLine();
                }
                System.out.println("Quantos veiculos este possue:");
                int j = scanner.nextInt();
                scanner.nextLine();
                for(int i = 1; i < j+1; i++){
                        System.out.println("Digite a placa do carro " + i);
                        String placa = scanner.nextLine();
                        while(!Validacao.validarPLACA(placa)){
                                System.out.println("Digite uma placa apenas com letras, digite novamente:");
                                placa = scanner.nextLine();
                        }
                        System.out.println("Digite a marca do carro " + i);
                        String marca = scanner.nextLine();
                        while(!Validacao.validarMARCA(marca)){
                                System.out.println("Digite uma marca apenas com letras, digite novamente:");
                                marca = scanner.nextLine();
                        }
                        System.out.println("Digite o modelo do carro " + i);
                        String modelo = scanner.nextLine();
                        while(!Validacao.validarMODELO(modelo)){
                                System.out.println("Digite um modelo apenas com letras, digite novamente:");
                                modelo = scanner.nextLine();
                        }
                        System.out.println("Digite o ano de fabricação do carro " + i);
                        int anoFabricacao = scanner.nextInt();
                        scanner.nextLine();
                        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
                        listaVeiculos.add(veiculo);
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


                ClientePJ cliente_novo = new ClientePJ(nome, endereco, listaVeiculos, CNPJ, data, qtdfuncionarios);
                System.out.println("O cliente registrado foi:");
                System.out.println(cliente_novo.toString());
                return cliente_novo;
        }
        private static Veiculo leVeiculo(){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a placa do veiculo");
                String placa = scanner.nextLine();
                while(!Validacao.validarPLACA(placa)){
                        System.out.println("Digite uma placa com letras e números, digite novamente:");
                        placa = scanner.nextLine();
                }
                System.out.println("Digite a marca do veiculo");
                String marca = scanner.nextLine();
                while(!Validacao.validarMARCA(marca)){
                        System.out.println("Digite uma marca apenas com letras, digite novamente:");
                        marca = scanner.nextLine();
                }
                System.out.println("Digite o modelo do veiculo");
                String modelo = scanner.nextLine();
                while(!Validacao.validarMODELO(modelo)){
                        System.out.println("Digite um modelo apenas com letras, digite novamente:");
                        modelo = scanner.nextLine();
                }
                System.out.println("Digite o ano de fabricacao do veiculo");
                int ano = scanner.nextInt();
                Veiculo Gol_mil_branco = new Veiculo(placa, marca, modelo, ano);
                return Gol_mil_branco;
        }
        private static Sinistro leSinistro(List<Seguradora> listaSeguradora){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora2 = scanner.nextLine();
                System.out.println("Digite a qual cliente é Referente:");
                String cliente1 = scanner.nextLine();

                System.out.println("Digite a ID do sinistro");
                int ID = scanner.nextInt();
                System.out.println("Digite a data do sinistro");
                String data = scanner.nextLine();
                System.out.println("Digite o endereco do sinistro");
                String endereco = scanner.nextLine();
                while(!Validacao.validarENDERECO(endereco)){
                        System.out.println("Digite um endereco apenas com letras, digite novamente o novo cliente:");
                        endereco = scanner.nextLine();
                }

                for(Seguradora seguradora3 : listaSeguradora){
                        if(seguradora3.getNome().equals(seguradora2)){
                                for(Cliente cliente2 : seguradora3.getListaClientes()){
                                        if(cliente2.getNome().equals(cliente1)){
                                                Cliente cliente3 = cliente2;
                                                Seguradora seguradora4 = seguradora3;
                                                Sinistro sinistro = new Sinistro(ID, data, endereco, seguradora4, cliente3);
                                                return sinistro;
                                        }
                                }
                        }
                }
                Sinistro nada = null;
                return nada;
        }
        private static Seguradora leSeguradora(){
                Scanner scanner = new Scanner(System.in);
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
                List<Sinistro> listaSinistro = new ArrayList<>();
                Seguradora seguradora = new Seguradora(nome, telefone, endereco, email, listaSinistro, listaClientes);

                return seguradora;
        }
        private static List<Seguradora> TransfereSeguro(List<Seguradora> lista){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora2 = scanner.nextLine();
                System.out.println("Digite qual cliente deve receber o seguro:");
                String cliente1 = scanner.nextLine();
                System.out.println("Digite qual cliente deve fornecer o seguro:");
                String cliente2 = scanner.nextLine();
                for(Seguradora seguradora3 : lista){
                        if(seguradora3.getNome().equals(seguradora2)){
                                for(Cliente cliente3 : seguradora3.getListaClientes()){
                                        if(cliente3.getNome().equals(cliente1)){
                                                for(Cliente cliente4 : seguradora3.getListaClientes()){
                                                        if(cliente4.getNome().equals(cliente2)){
                                                                cliente4.setListaVeiculos(cliente3.getListaVeiculos());
                                                                cliente3.setListaVeiculos(null);
                                                                System.out.println("Transferido seguro");
                                                                return lista;
                                                        }
                                                        System.out.println("Não transferido seguro");
                                                        return lista;
                                                }
                                        }
                                        System.out.println("Não transferido seguro");
                                        return lista;
                                }
                        }
                        System.out.println("Não transferido seguro");
                        return lista;
                }
                System.out.println("Não transferido seguro");
                return lista;
        }
        private static boolean cadastrarVeiculo(List<Seguradora> listaSeguradora){
                Scanner scanner = new Scanner(System.in);
                Veiculo veiculo = leVeiculo();
                System.out.println("Digite a qual seguradora é Referente:");
                String cliente = scanner.nextLine();
                System.out.println("Digite a qual cliente é referente:");
                String seguradora = scanner.nextLine();
                for(Seguradora seguradora1 : listaSeguradora){
                        if(seguradora1.getNome().equals(seguradora)){
                                for(Cliente cliente1 : seguradora1.getListaClientes()){
                                        if(cliente1.getNome().equals(cliente)){
                                                cliente1.getListaVeiculos().add(veiculo);
                                                return true;
                                        }
                                }
                        }
                }
                return false;
        }
        private static List<Seguradora> CADASTRAR_CLIENTE_PF(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora1 = scanner.nextLine();
                for(Seguradora seguradora : listaSeguradora){
                        if(seguradora.getNome().equals(seguradora1)){
                                if(seguradora.cadastrarCliente(leClientePf())){
                                        System.out.println("Cliente cadastrado");
                                        return listaSeguradora;
                                }
                                else{
                                        System.out.println("Cliente não cadastrado");
                                        return listaSeguradora;
                                }
                        }
                        else{
                                System.out.println("Cliente não cadastrado");
                                return listaSeguradora;
                        }
                }
                return listaSeguradora;
        }
        private static List<Seguradora> CADASTRAR_CLIENTE_PJ(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora2 = scanner.nextLine();
                for(Seguradora seguradora : listaSeguradora){
                        if(seguradora.getNome().equals(seguradora2)){
                                if(seguradora.cadastrarCliente(leClientePj())){
                                        System.out.println("Cliente cadastrado!");
                                        return listaSeguradora;
                                }
                                else{
                                        System.out.println("Cliente não cadastrado!");
                                        return listaSeguradora;
                                }
                        }
                        else{
                                System.out.println("Seguradora não achada!");
                                return listaSeguradora;
                        }
                }
                return listaSeguradora;
        }
        private static void LISTAR_PF_SEGURADORA(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora2 = scanner.nextLine();
                for(Seguradora seguradora3 : listaSeguradora){
                        if(seguradora3.getNome().equals(seguradora2)){
                                for(Cliente cliente1 : seguradora3.getListaClientes()){
                                        if(cliente1 instanceof ClientePF){
                                                System.out.println(cliente1.toString());
                                        }
                                }
                        }
                }
        }
        private static void LISTAR_PJ_SEGURADORA(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                String seguradora2 = scanner.nextLine();
                for(Seguradora seguradora3 : listaSeguradora){
                        if(seguradora3.getNome().equals(seguradora2)){
                                for(Cliente cliente1 : seguradora3.getListaClientes()){
                                        if(cliente1 instanceof ClientePJ){
                                                System.out.println(cliente1.toString());
                                        }
                                }
                        }
                }
        }
        private static void LISTAR_SINISTRO_SEGURADORA(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                String seguradora2 = scanner.nextLine();
                for(Seguradora seguradora3 : listaSeguradora){
                        if(seguradora3.getNome().equals(seguradora2)){
                                for(Cliente cliente1 : seguradora3.getListaClientes()){
                                        if(cliente1 instanceof ClientePJ){
                                                System.out.println(cliente1.toString());
                                        }
                                }
                        }
                }
        }
        private static void LISTAR_SINISTRO_CLIENTE(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora2 = scanner.nextLine();
                System.out.println("Digite a qual cliente é Referente:");
                String cliente1 = scanner.nextLine();
                for(Seguradora seguradora3 : listaSeguradora){
                        if(seguradora3.getNome().equals(seguradora2)){
                                for(Sinistro sinistro1 : seguradora3.getListaSinistros()){
                                        if(sinistro1.getCliente().equals(cliente1)){
                                                System.out.println(sinistro1.toString());
                                        }
                                }
                        }
                }
        }
        private static void LISTAR_VEICULO_CLIENTE(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora2 = scanner.nextLine();
                System.out.println("Digite a qual cliente é Referente:");
                String cliente1 = scanner.nextLine();
                for (Seguradora seguradora3 : listaSeguradora) {
                        if (seguradora3.getNome().equals(seguradora2)) {
                                for (Cliente cliente2 : seguradora3.getListaClientes()) {
                                        if (cliente2.getNome().equals(cliente1)) {
                                                System.out.println(cliente2.getListaVeiculos());
                                        }
                                }
                        }
                }
        }
        private static void LISTAR_VEICULO_SEGURADORA(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora2 = scanner.nextLine();
                for(Seguradora seguradora3 : listaSeguradora) {
                        if(seguradora3.getNome().equals(seguradora2)){
                                for(Cliente cliente2 : seguradora3.getListaClientes()){
                                        System.out.println(cliente2.getListaVeiculos());
                                }
                        }
                }
        }
        private static List<Seguradora> EXCLUIR_CLIENTE(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora2 = scanner.nextLine();
                System.out.println("Digite a qual cliente é Referente:");
                String cliente1 = scanner.nextLine();
                for(Seguradora seguradora3 : listaSeguradora) {
                        if (seguradora3.getNome().equals(seguradora2)) {
                                for(Cliente cliente2 : seguradora3.getListaClientes()){
                                        if (cliente2.getNome().equals(cliente1)) {
                                                seguradora3.getListaClientes().remove(cliente2);
                                                System.out.println("Cliente removido");
                                                return listaSeguradora;
                                        }
                                        else{
                                                System.out.println("Cliente não removido");
                                                return listaSeguradora;
                                        }
                                }
                        }
                        else{
                                System.out.println("Cliente não removido");
                                return listaSeguradora;
                        }
                }
                return listaSeguradora;
        }
        private static List<Seguradora> EXCLUIR_VEICULO(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora2 = scanner.nextLine();
                System.out.println("Digite a qual cliente é Referente:");
                String cliente1 = scanner.nextLine();
                System.out.println("Digite a placa a qual o veiculo é Referente:");
                String veiculo1 = scanner.nextLine();
                for(Seguradora seguradora3 : listaSeguradora) {
                        if (seguradora3.getNome().equals(seguradora2)) {
                                for(Cliente cliente2 : seguradora3.getListaClientes()){
                                        if (cliente2.getNome().equals(cliente1)) {
                                                for(Veiculo veiculo : cliente2.getListaVeiculos()) {
                                                        if (veiculo.getPlaca().equals(veiculo)) {
                                                                cliente2.getListaVeiculos().remove(veiculo);
                                                                System.out.println("Veiculo removido");
                                                                return listaSeguradora;
                                                        }
                                                        else{
                                                                System.out.println("Veiculo não removido");
                                                                return listaSeguradora;
                                                        }
                                                }
                                        }
                                        else{
                                                System.out.println("Veiculo não removido");
                                                return listaSeguradora;
                                        }
                                }
                        }
                        else{
                                System.out.println("Veiculo não removido");
                                return listaSeguradora;
                        }
                }
                return listaSeguradora;
        }
        private static List<Seguradora> EXCLUIR_SINISTRO(List<Seguradora> listaSeguradora) throws ParseException {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a qual seguradora é Referente:");
                String seguradora2 = scanner.nextLine();
                System.out.println("Digite o id do sinistro referente:");
                int sinistro1 = scanner.nextInt();
                for(Seguradora seguradora3 : listaSeguradora) {
                        if (seguradora3.getNome().equals(seguradora2)) {
                                for(Sinistro sinistro2 : seguradora3.getListaSinistros()){
                                        if (sinistro2.getID() == (sinistro1)) {
                                                seguradora3.getListaClientes().remove(sinistro2);
                                                System.out.println("Sinistro removido");
                                                return listaSeguradora;
                                        }
                                        else{
                                                System.out.println("Sinistro não removido");
                                                return listaSeguradora;
                                        }
                                }
                        }
                        else{
                                System.out.println("Sinistro não removido");
                                return listaSeguradora;
                        }
                }
                return listaSeguradora;
        }
        private static void exibirMenuExterno() {
                MenuOperacoes menuOperacoes[] = MenuOperacoes.values();
                System.out.println("Menu principal");
                for(MenuOperacoes op: menuOperacoes) {
                        System.out.println(op.ordinal() + " - " + op.getDescricao());
                }
        }
        private static MenuOperacoes LerOpMenu(){
                Scanner scanner = new Scanner(System.in);
                int UsuarioInt;
                MenuOperacoes UsuarioIntConst;
                do{
                        System.out.println("Digite uma das opções de 0-6");
                        UsuarioInt = scanner.nextInt();
                }while(UsuarioInt < 0 || UsuarioInt > 6);
                UsuarioIntConst = MenuOperacoes.values()[UsuarioInt];
                return UsuarioIntConst;
        }
        private static void exibirSubMenu(MenuOperacoes op) {
                SubmenuOps[] submenu = op.getSubmenu();
                System.out.println("Submenu");
                for(int i = 0; i < submenu.length; i++) {
                        System.out.println(i + " - " + submenu[i].getDescricao());
                }
        }
        private static SubmenuOps lerSubmenu(MenuOperacoes op){
                if(op ==  MenuOperacoes.SAIR){
                        return SubmenuOps.VOLTAR;
                }
                Scanner scanner = new Scanner(System.in);
                int opUsuario;
                SubmenuOps opUsuarioConst;
                do{
                        System.out.println("Digite um opcao: ");
                        opUsuario = scanner.nextInt();
                }while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
                opUsuarioConst = op.getSubmenu()[opUsuario];
                return opUsuarioConst;
        }
        private static void executarOpMenu(MenuOperacoes op, List<Seguradora> lista){
                lista.add(leSeguradora());
                Scanner scanner = new Scanner(System.in);
                switch(op){
                        case LISTAR:
                                break;
                        case CADASTROS:
                                break;
                        case EXCLUIR:
                                break;
                        case GERAR_SINISTRO:
                                Sinistro sinistro = leSinistro(lista);
                                if(sinistro.getSeguradora().gerarSinistro(sinistro)) {
                                        System.out.println("Sinistro foi gerado");
                                }
                                break;
                        case TRANSFERIR:
                                lista = TransfereSeguro(lista);
                                break;
                        case CALCULAR:
                                System.out.println("Digite a qual seguradora é Referente:");
                                String seguradora2 = scanner.nextLine();
                                for(Seguradora seguradora3 : lista){
                                        if(seguradora3.getNome().equals(seguradora2)){
                                                System.out.println(seguradora3.calcularReceita());
                                        }
                                }
                                break;
                }
        }
        public static void executarOpcaoSubMenu(SubmenuOps subop, List<Seguradora> listaSeguradora) throws ParseException {
                switch(subop) {
                        case CADASTRAR_CLIENTE_PF:
                                listaSeguradora = CADASTRAR_CLIENTE_PF(listaSeguradora);
                                break;
                        case CADASTRAR_CLIENTE_PJ:
                                listaSeguradora = CADASTRAR_CLIENTE_PJ(listaSeguradora);
                                break;
                        case CADASTRAR_VEICULO:
                                if(cadastrarVeiculo(listaSeguradora)){
                                        System.out.println("Veiculo cadastrado");
                                }
                                break;
                        case CADASTRAR_SEGURADORA:
                                Seguradora seguradora = leSeguradora();
                                listaSeguradora.add(seguradora);
                                System.out.println("Seguradora cadastrada");
                                break;
                        case LISTAR_PF_SEGURADORA:
                                LISTAR_PF_SEGURADORA(listaSeguradora);
                                break;
                        case LISTAR_PJ_SEGURADORA:
                                LISTAR_PJ_SEGURADORA(listaSeguradora);
                                break;
                        case LISTAR_SINISTRO_SEGURADORA:
                                LISTAR_SINISTRO_SEGURADORA(listaSeguradora);
                                break;
                        case LISTAR_SINISTRO_CLIENTE:
                                LISTAR_SINISTRO_CLIENTE(listaSeguradora);
                                break;
                        case LISTAR_VEICULO_CLIENTE:
                                LISTAR_VEICULO_CLIENTE(listaSeguradora);
                                break;
                        case LISTAR_VEICULO_SEGURADORA:
                                LISTAR_VEICULO_SEGURADORA(listaSeguradora);
                                break;
                        case EXCLUIR_CLIENTE:
                                listaSeguradora = EXCLUIR_CLIENTE(listaSeguradora);
                                break;
                        case EXCLUIR_VEICULO:
                                listaSeguradora = EXCLUIR_VEICULO(listaSeguradora);
                                break;
                        case EXCLUIR_SINISTRO:
                                listaSeguradora = EXCLUIR_SINISTRO(listaSeguradora);
                                break;
                        case VOLTAR:
                                break;
                }
        }
        public static void main(String[] args) throws ParseException {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


                // ######## Instanciação das classes: Veiculo, ClientePJ, ClientePF, e Seguradora. ########### \\
                Veiculo Gol_mil_branco = new Veiculo("BRA2019", "Volkswagen", "Gol mil Branco", 1980);
                Date dataLicenca = new Date(2002, Calendar.NOVEMBER, 9);
                Date dataNascimento = new Date(2010, Calendar.DECEMBER, 9);
                Date dataFundacao = new Date(2020, Calendar.DECEMBER, 18);
                List<Veiculo> listaVeiculos = new ArrayList<>();


                ClientePF clientePf = new ClientePF("Pedro", "Rua do Pedro", listaVeiculos, dataLicenca, "Doutorado em Física", "Muito alta", "280.012.389-38", dataNascimento, "Masculino");
                ClientePJ clientePj = new ClientePJ("Empresa", "Rua da Empresa", listaVeiculos, "51.174.235/0001-30", dataFundacao, 88);
                List<Cliente> listaClientes = new ArrayList<>();
                List<Sinistro> listaSinistros = new ArrayList<>();

                listaClientes.add(clientePf);
                listaClientes.add(clientePj);
                Seguradora seguradora1 = new Seguradora("Seguradora", "99999999", "segurado@novas.com", "Rua da seguradora", listaSinistros, listaClientes);

                Sinistro sinistro1 = new Sinistro(1234, "17/02/2010", "Rua do Sinistro1", seguradora1, clientePf);
                listaSinistros.add(sinistro1);
                Sinistro sinistro2 = new Sinistro(5678, "17/02/2020", "Rua do Sinistro2", seguradora1, clientePf);
                listaSinistros.add(sinistro2);

                clientePj.getListaVeiculos().add(Gol_mil_branco);
                clientePf.getListaVeiculos().add(Gol_mil_branco);
                //############################################################################\\

                //####### Chamando os métodos, listarClientes(); visualizarSinistro(); listarSinistros(); e calcularReceita()

                seguradora1.listarClientes("ClientePF");
                seguradora1.listarClientes("ClientePJ");
                seguradora1.visualizarSinistro(clientePj);
                seguradora1.visualizarSinistro(clientePf);
                seguradora1.listarSinistros();

                //############################################################################################################\\

                // ##### Atualizar o atributo valorSeguro de cada cliente cadastrado na seguradora utilizando o método calcu-
                // #####  lar PrecoSeguroCliente() da classe Seguradora;

                clientePf.setValorSeguro(seguradora1.calcularPrecoSeguroCliente(clientePf));
                clientePj.setValorSeguro(seguradora1.calcularPrecoSeguroCliente(clientePj));

                // ######################################################

                // ######## Mostrar na tela a receita total da seguradora utilizando o método calcularReceita(); ####### \\

                System.out.println("A receita total é de " + seguradora1.calcularReceita() + " reais\n");

                // ########################################################## \\

                // ####### Implementação do menu interativo ####### \\
                menu();
        }
        private static void menu() throws ParseException {

                MenuOperacoes op;
                SubmenuOps subop;
                List<Seguradora> listaSeguradora = new ArrayList<>();
                System.out.println("Deve-se primeiro cadastrar uma seguradora antes de cadastrar qualquer outro objeto!");
                Seguradora seguradora = leSeguradora();
                listaSeguradora.add(seguradora);
                do {
                        exibirMenuExterno();
                        op = LerOpMenu();
                        executarOpMenu(op, listaSeguradora);
                        exibirSubMenu(op);
                        subop = lerSubmenu(op);
                        executarOpcaoSubMenu(subop, listaSeguradora);
                } while (op != MenuOperacoes.SAIR);
        }
}


