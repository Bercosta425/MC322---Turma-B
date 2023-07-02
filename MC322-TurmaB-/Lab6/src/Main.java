import Classes.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Main{

private static void exibirMenuExterno(){
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
                System.out.println("Digite uma das opções de 0-7");
                UsuarioInt = scanner.nextInt();
        }while(UsuarioInt < 0 || UsuarioInt > 7);
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
private static void executarOpMenu(MenuOperacoes op, List<Seguradora> lista) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        switch(op){
                case LISTAR:
                        break;
                case CADASTROS:
                        break;
                case EXCLUIR:
                        break;
                case GERAR_SINISTRO:
                        Seguro seguro = Leitura.leSeguroPf(lista);
                        if(seguro.gerarsinistro()){
                                System.out.println("Classes.Sinistro foi gerado");
                        }
                        break;
                case GERAR_SEGUROPF:
                        lista = MetodosMenu.GERAR_SEGUROPF(lista);
                        break;
                case GERAR_SEGUROPJ:
                        lista = MetodosMenu.GERAR_SEGUROPJ(lista);
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
public static void executarOpcaoSubMenu(SubmenuOps subop, List<Seguradora> listaSeguradora) throws ExcecaoLeitura.ErroDeCNPJ, ExcecaoLeitura.ErroDeCPF, ParseException {
        switch(subop) {
                case CADASTRAR_CONDUTOR:
                        MetodosMenu.CADASTRAR_CONDUTOR(listaSeguradora);
                        break;
                case CADASTRAR_CLIENTE_PF:
                        listaSeguradora = MetodosMenu.CADASTRAR_CLIENTE_PF(listaSeguradora);
                        break;
                case CADASTRAR_CLIENTE_PJ:
                        listaSeguradora = MetodosMenu.CADASTRAR_CLIENTE_PJ(listaSeguradora);
                        break;
                case CADASTRAR_VEICULO:
                        if(MetodosMenu.cadastrarVeiculo(listaSeguradora)){
                                System.out.println("Classes.Veiculo cadastrado");
                        }
                        break;
                case CADASTRAR_SEGURADORA:
                        Seguradora seguradora = Leitura.leSeguradora();
                        listaSeguradora.add(seguradora);
                        System.out.println("Classes.Seguradora cadastrada");
                        break;
                case LISTAR_PF_SEGURADORA:
                        MetodosMenu.LISTAR_PF_SEGURADORA(listaSeguradora);
                        break;
                case LISTAR_CONDUTOR_SEGURO:
                        MetodosMenu.LISTAR_CONDUTOR_SEGURO(listaSeguradora);
                        break;
                case LISTAR_FROTA_CLIENTEPJ:
                        MetodosMenu.LISTAR_FROTA_CLIENTEPJ(listaSeguradora);
                        break;
                case LISTAR_SINISTRO_CONDUTOR:
                        MetodosMenu.LISTAR_SINISTRO_CONDUTOR(listaSeguradora);
                        break;
                case LISTAR_SINISTRO_SEGURO:
                        MetodosMenu.LISTAR_SINISTRO_SEGURO(listaSeguradora);
                        break;
                case LISTAR_VEICULO_CLIENTEPF:
                        MetodosMenu.LISTAR_VEICULO_CLIENTEPF(listaSeguradora);
                        break;
                case LISTAR_PJ_SEGURADORA:
                        MetodosMenu.LISTAR_PJ_SEGURADORA(listaSeguradora);
                        break;
                case LISTAR_SINISTRO_SEGURADORA:
                        MetodosMenu.LISTAR_SINISTRO_SEGURADORA(listaSeguradora);
                        break;
                case EXCLUIR_FROTA:
                        break;
                case EXCLUIR_CONDUTOR:
                        break;
                case EXCLUIR_SEGURO:
                        break;
                case EXCLUIR_CLIENTE:
                        listaSeguradora = MetodosMenu.EXCLUIR_CLIENTE(listaSeguradora);
                        break;
                case EXCLUIR_VEICULO_CLIENTEPF:
                        listaSeguradora = MetodosMenu.EXCLUIR_VEICULO_CLIENTEPF(listaSeguradora);
                        break;
                case EXCLUIR_VEICULO_FROTA:
                        listaSeguradora = MetodosMenu.EXCLUIR_VEICULO_FROTA(listaSeguradora);
                        break;
                case EXCLUIR_SINISTRO:
                        listaSeguradora = MetodosMenu.EXCLUIR_SINISTRO_SEGURO(listaSeguradora);
                        break;
                case VOLTAR:
                        break;
        }
}
public static void main(String[] args) throws ParseException, ExcecaoLeitura.ErroDeCNPJ, ExcecaoLeitura.ErroDeCPF, IOException {
   SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

   //Caminho para chegar nos arquivos a serem lidos.
   String path = "..\\..\\lab06-seguradora_arquivos\\lab06-seguradora_arquivos_v2\\";
   File file = new File(path);
   ArrayList<ClientePF> listaClientepf = new ArrayList<>();
   ArrayList<ClientePJ> listaClientepj = new ArrayList<>();
   ArrayList<Condutor> listaCondutor2 = new ArrayList<>();
   ArrayList<Veiculo> listaVeiculo = new ArrayList<>();
   ArrayList<Frota> listaFrota = new ArrayList<>();

    String demilitador = ",";
   List<String[]> linhas = new ArrayList<>();
  for(File f : file.listFiles()) {
       if (f.getName().endsWith("clientesPF.csv")) {
           BufferedReader br = new BufferedReader(new FileReader(f));
           String linha = br.readLine();
           while (linha != null) {
               String[] campos = linha.split(demilitador);
               linhas.add(campos);
               listaClientepf.add(new ClientePF(campos[1], campos[3], campos[4], campos[2], campos[6], campos[5], campos[0], formato.parse(campos[7]), listaVeiculo));
               linha = br.readLine();
           }
       } else if (f.getName().endsWith("clientesPJ.csv")) {

       } else if (f.getName().endsWith("condutores.csv")) {

       } else if (f.getName().endsWith("veiculos.csv")) {

       } else if (f.getName().endsWith("frotas.csv")) {

       }
   }

    // ######## Instanciação das classes: Classes.Veiculo, Classes.ClientePJ, Classes.ClientePF, Classes.Seguradora, Classes.Sinistro, Classes.Seguro, e condutor. Em seguida, é aplicado o menu de operações! ########### \\
    Veiculo Gol_mil_branco = new Veiculo("BRA2019", "Volkswagen", "Gol mil Branco", 1980);
    Date dataLicenca = new Date(2002, Calendar.NOVEMBER, 9);
    Date dataNascimento = new Date(2010, Calendar.DECEMBER, 9);
    Date dataFundacao = new Date(2020, Calendar.DECEMBER, 18);
    List<Veiculo> listaVeiculos = new ArrayList<>();
    List<Frota> listaFrota2 = new ArrayList<>();
    listaVeiculos.add(Gol_mil_branco);
    Frota frota = new Frota("0", listaVeiculos);


    ClientePF clientePf = new ClientePF("Pedro", "Rua do Pedro", "Pedro@Email.com", "99999999", "Ensino superior", "masculino", "280.012.389-38", dataNascimento, listaVeiculos);
    ClientePJ clientePj = new ClientePJ("Empresa", "Rua da Empresa", "Empresa@Email.com", "99999999","51.174.235/0001-30" , dataFundacao, listaFrota);
    List<Cliente> listaClientes = new ArrayList<>();
    List<Sinistro> listaSinistros = new ArrayList<>();
    List<Seguro> listaSeguros = new ArrayList<>();
    List<Condutor> listaCondutor = new ArrayList<>();

    listaClientes.add(clientePf);
    listaClientes.add(clientePj);
    Seguradora seguradora1 = new Seguradora("25.824.319/0001-62", "9999999", "Classes.Seguradora", "segurado@novas.com", "Rua da seguradora", listaClientes, listaSeguros);
    Date dataSinistro1 = new Date(2011, Calendar.DECEMBER, 8);
    Date dataSinistro2 = new Date(2013, Calendar.NOVEMBER, 4);

    Date dataNascimento2 = new Date(1999, Calendar.APRIL, 4);
    Condutor condutor = new Condutor("816.185.930-21", "Eduarda", "9999999", "Eduarda@gmail.com", "Rua da Eduarda", dataNascimento2, listaSinistros);
    listaCondutor.add(condutor);
    // ######## \\
    System.out.println("##################### Segue todas os toString das classes. #########################:\n");
    System.out.println("Veiculo: \n");
    System.out.println(Gol_mil_branco.toString() + "\n");
    System.out.println("ClientePF: \n");
    System.out.println(clientePf.toString() + "\n");
    System.out.println("ClientePJ: \n");
    System.out.println(clientePj.toString() + "\n");
    System.out.println("Seguradora: \n");
    System.out.println(seguradora1.toString() + "\n");
    System.out.println("Sinistro: \n");
    System.out.println(condutor.toString() + "\n");
    System.out.println("Seguro: \n");
    System.out.println(frota.toString() + "\n");


    // ####### Para gerar o seguro usa-se o método da seguradora. Deve-se usar o cpf do cliente instanciado acima! E também o ID 0 do seguro, dado que o id é dado pelo acumulo de seguros instanciados]
    // ######## \\
    Date dataInicio = new Date(2011, Calendar.DECEMBER, 8);
    Date dataFim = new Date(2020, Calendar.DECEMBER, 8);
    System.out.println("##################### Segue um exemplo de como gerar um seguro #########################:\n");
    System.out.println("Digite usando o seguinte CNPJ: 25.824.319/0001-62\n");
    seguradora1.gerarSeguro(seguradora1.getListaSeguros());
    Seguro seguro = (seguradora1.getListaSeguros()).get(0);


    System.out.println("##################### Segue um exemplo de como gerar um sinistro #########################:\n");
    if(seguro.gerarsinistro()){
            System.out.println("Classes.Sinistro gerado");
    }
    Sinistro sinistro2 = new Sinistro( dataSinistro2, "Rua do Sinistro2", seguro);
    listaSinistros.add(sinistro2);


    //############################################################################\\

    //####### Chamando os métodos, listarClientes(); visualizarSinistro(); listarSinistros(); e calcularReceita()

    seguradora1.listarClientes("Classes.ClientePF");
    seguradora1.listarClientes("Classes.ClientePJ");

    //############################################################################################################\\

    // ######## Mostrar na tela a receita total da seguradora utilizando o método calcularReceita(); ####### \\

    System.out.println("A receita total é de " + seguradora1.calcularReceita() + " reais\n");

    // ########################################################## \\

    // ####### Implementação do menu interativo ####### \\
    menu();
}
private static void menu() throws ParseException, ExcecaoLeitura.ErroDeCNPJ, ExcecaoLeitura.ErroDeCPF {

        MenuOperacoes op;
        SubmenuOps subop;
        List<Seguradora> listaSeguradora = new ArrayList<>();
        System.out.println("Deve-se primeiro cadastrar uma seguradora antes de cadastrar qualquer outro objeto!");
        Seguradora seguradora = Leitura.leSeguradora();
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

