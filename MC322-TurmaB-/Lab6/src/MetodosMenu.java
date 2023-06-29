import Classes.*;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MetodosMenu {
     /*static List<Seguradora> TransfereSeguro(List<Seguradora> lista){
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
    }*/
     static boolean cadastrarVeiculo(List<Seguradora> listaSeguradora){
        Scanner scanner = new Scanner(System.in);
        Veiculo veiculo = Leitura.leVeiculo();
        System.out.println("Digite a qual seguradora é Referente:");
        String cliente = scanner.nextLine();
        System.out.println("Digite a qual cliente é referente:");
        String seguradora = scanner.nextLine();
        for(Seguradora seguradora1 : listaSeguradora){
            if(seguradora1.getNome().equals(seguradora)){
                for(Cliente cliente1 : seguradora1.getListaClientes()){
                    if(cliente1.getNome().equals(cliente)){
                        if(cliente1 instanceof ClientePF)
                        ((ClientePF) cliente1).getListaVeiculos().add(veiculo);
                        return true;
                    }
                    else{
                        System.out.println("Digite o código da frota referente:");
                        String frota = scanner.nextLine();
                        for(Frota frota1 :((ClientePJ) cliente1).getListaFrota()){
                            if(frota.equals(frota1.getCode())){
                                frota1.getListaveiculos().add(veiculo);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
     static List<Seguradora> CADASTRAR_CLIENTE_PF(List<Seguradora> listaSeguradora) throws ExcecaoLeitura.ErroDeCNPJ, ExcecaoLeitura.ErroDeCPF, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a qual seguradora é Referente:");
        String seguradora1 = scanner.nextLine();
        for(Seguradora seguradora : listaSeguradora){
            if(seguradora.getNome().equals(seguradora1)){
                if(seguradora.cadastrarCliente(Leitura.leClientePf(seguradora.getListaClientes()))){
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
     static List<Seguradora> CADASTRAR_CLIENTE_PJ(List<Seguradora> listaSeguradora) throws ExcecaoLeitura.ErroDeCNPJ, ExcecaoLeitura.ErroDeCPF {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a qual seguradora é Referente:");
        String seguradora2 = scanner.nextLine();
        for(Seguradora seguradora : listaSeguradora){
            if(seguradora.getNome().equals(seguradora2)){
                if(seguradora.cadastrarCliente(Leitura.leClientePj(seguradora.getListaClientes()))){
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
     static List<Seguradora> CADASTRAR_CONDUTOR(List<Seguradora> listaSeguradora) throws ParseException {
         Scanner scanner = new Scanner(System.in);
         Condutor condutor = Leitura.leCondutor(listaSeguradora);
         System.out.println("Digite o CNPJ da seguradora referente:");
         String cnpj = scanner.nextLine();
         System.out.println("Digite o id do seguro referente:");
         int id = scanner.nextInt();
         for(Seguradora seguradora : listaSeguradora){
             for(Seguro seguro : seguradora.getListaSeguros()){
                 if(seguro.getId() == id){
                     seguro.getListaCondutor().add(condutor);
                     System.out.println("Condutor cadastrado!");
                 }
                 else{
                     System.out.println("Condutor não cadastrado");
                 }
             }
         }
         return listaSeguradora;
     }
     static List<Seguradora> CADASTRAR_SEGURADORA (List<Seguradora> listaSeguradora){
         Seguradora seguradora = Leitura.leSeguradora();
         listaSeguradora.add(seguradora);
         return listaSeguradora;
     }


     static void LISTAR_PF_SEGURADORA(List<Seguradora> listaSeguradora) throws ParseException {
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
     static void LISTAR_PJ_SEGURADORA(List<Seguradora> listaSeguradora) throws ParseException {
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
     static void LISTAR_SEGURO_SEGURADORA(List<Seguradora> listaSeguradora){
         for(Seguradora seguradora : listaSeguradora){
             for(Seguro seguro : seguradora.getListaSeguros()){
                 seguro.toString();
             }
         }
     }
     static void LISTAR_SINISTRO_CONDUTOR(List<Seguradora> listaSeguradora){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Digite o CPNJ da seguradora do condutor referente:");
         String seguradora = scanner.nextLine();
         System.out.println("Digite o CPF do condutor referente:");
         String cpf = scanner.nextLine();
         for(Seguradora seguradora1 : listaSeguradora){
             if(seguradora1.getCNPJ().equals(seguradora)){
                 for(Seguro seguro : seguradora1.getListaSeguros()){
                     for(Condutor condutor : seguro.getListaCondutor()){
                         if(condutor.getCpf().equals(cpf)){
                             for(Sinistro sinistro : condutor.getListasinistro()){
                                 sinistro.toString();
                             }
                         }
                     }
                 }
             }
         }
     }
     static void LISTAR_SINISTRO_SEGURO(List<Seguradora> listaSeguradora){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Digite o CNPJ do seguradora referente:");
         String cnpj = scanner.nextLine();
         System.out.println("Digite o id do seguro referente:");
         int id = scanner.nextInt();
         for(Seguradora seguradora : listaSeguradora){
            if(seguradora.getCNPJ().equals(cnpj)){
                for(Seguro seguro : seguradora.getListaSeguros()){
                    if(seguro.getId() == (id)){
                        for(Sinistro sinistro : seguro.getListaSinistro()){
                            sinistro.toString();
                        }
                    }
                }
            }
         }
     }
     static void LISTAR_CONDUTOR_SEGURO(List<Seguradora> listaSeguradora){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Digite o CNPJ do seguradora referente:");
         String cnpj = scanner.nextLine();
         System.out.println("Digite o id do seguro referente:");
         int id = scanner.nextInt();
         for(Seguradora seguradora : listaSeguradora){
             if(seguradora.getCNPJ().equals(cnpj)){
                 for(Seguro seguro : seguradora.getListaSeguros()){
                     if(seguro.getId() == (id)){
                         for(Condutor condutor : seguro.getListaCondutor()){
                             condutor.toString();
                         }
                     }
                 }
             }
         }
     }
     static void LISTAR_FROTA_CLIENTEPJ(List<Seguradora> listaSeguradora){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Digite o CNPJ do seguradora referente:");
         String cnpj = scanner.nextLine();
         System.out.println("Digite o CNPJ do cliente referente:");
         int cnpj1 = scanner.nextInt();
         for(Seguradora seguradora : listaSeguradora){
             if(seguradora.getCNPJ().equals(cnpj)){
                 for(Cliente cliente : seguradora.getListaClientes()){
                     if(cliente instanceof ClientePJ){
                         if(((ClientePJ) cliente).getCNPJ().equals(cnpj1)){
                             for(Frota frota : ((ClientePJ) cliente).getListaFrota()){
                                frota.toString();
                             }
                         }
                     }

                 }
             }
         }
     }
     static void LISTAR_VEICULO_CLIENTEPF(List<Seguradora> listaSeguradora){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Digite o CNPJ do seguradora referente:");
         String cnpj = scanner.nextLine();
         System.out.println("Digite o CPF do cliente referente:");
         int cpf = scanner.nextInt();
         for(Seguradora seguradora : listaSeguradora){
             if(seguradora.getCNPJ().equals(cnpj)){
                 for(Cliente cliente : seguradora.getListaClientes()){
                     if(cliente instanceof ClientePF){
                         if(((ClientePF) cliente).getCpf().equals(cpf)){
                             for(Veiculo veiculo : ((ClientePF) cliente).getListaVeiculos()){
                                 veiculo.toString();
                             }
                         }
                     }

                 }
             }
         }
     }
     static void LISTAR_SINISTRO_SEGURADORA(List<Seguradora> listaSeguradora) throws ParseException {
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
     /*static void LISTAR_SINISTRO_CLIENTE(List<Seguradora> listaSeguradora) throws ParseException {
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
    }*/
     /*static void LISTAR_VEICULO_SEGURADORA(List<Seguradora> listaSeguradora) throws ParseException {
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
    }*/


     static List<Seguradora> EXCLUIR_CLIENTE(List<Seguradora> listaSeguradora) throws ParseException {
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
     static List<Seguradora> EXCLUIR_VEICULO_FROTA(List<Seguradora> listaSeguradora) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a qual seguradora é Referente:");
        String seguradora2 = scanner.nextLine();
        System.out.println("Digite o CNPJ do cliente Referente:");
        String cnpj = scanner.nextLine();
        System.out.println("Digite o código da frota Referente:");
        String code = scanner.nextLine();
        System.out.println("Digite a placa a qual o veiculo é Referente:");
        String placa = scanner.nextLine();
        for(Seguradora seguradora3 : listaSeguradora) {
            if (seguradora3.getNome().equals(seguradora2)) {
                for(Cliente cliente2 : seguradora3.getListaClientes()){
                    if (((ClientePJ) cliente2).getCNPJ().equals(cnpj)) {
                        for(Frota frota : ((ClientePJ) cliente2).getListaFrota()) {
                            if (frota.getCode().equals(code)) {
                                for(Veiculo veiculo : frota.getListaveiculos()){
                                    if(veiculo.getPlaca().equals(placa)){
                                        frota.getListaveiculos().remove(veiculo);
                                        System.out.println("Veiculo removido");
                                        return listaSeguradora;
                                    }
                                    else{
                                        System.out.println("Veiculo não existe na frota");
                                        return listaSeguradora;
                                    }
                                }

                            }

                        }
                    }
                    else{
                        System.out.println("Veiculo não existe na frota");
                        return listaSeguradora;
                    }
                }
            }
            else{
                System.out.println("Veiculo não existe na frota");
                return listaSeguradora;
            }
        }
        return listaSeguradora;
    }
    static List<Seguradora> EXCLUIR_VEICULO_CLIENTEPF(List<Seguradora> listaSeguradora) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a qual seguradora é Referente:");
        String seguradora2 = scanner.nextLine();
        System.out.println("Digite o CPF do cliente Referente:");
        String cpf = scanner.nextLine();
        System.out.println("Digite a placa a qual o veiculo é Referente:");
        String placa = scanner.nextLine();
        for(Seguradora seguradora3 : listaSeguradora) {
            if (seguradora3.getNome().equals(seguradora2)) {
                for(Cliente cliente2 : seguradora3.getListaClientes()){
                    if (((ClientePF) cliente2).getCpf().equals(cpf)) {
                        for(Veiculo veiculo : ((ClientePF) cliente2).getListaVeiculos()){
                            if(veiculo.getPlaca().equals(placa)){
                                ((ClientePF) cliente2).getListaVeiculos().remove(veiculo);
                                System.out.println("Veiculo removido");
                                return listaSeguradora;
                            }
                            else{
                                System.out.println("Veiculo não existe com o cliente");
                                return listaSeguradora;
                            }


                        }
                    }
                    else{
                        System.out.println("Veiculo não existe com o cliente");
                        return listaSeguradora;
                    }
                }
            }
            else{
                System.out.println("Veiculo não existe com o cliente");
                return listaSeguradora;
            }
        }
        return listaSeguradora;
    }
     static List<Seguradora> EXCLUIR_SINISTRO_SEGURO(List<Seguradora> listaSeguradora) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CNPJ da seguradora Referente:");
        String cnpj = scanner.nextLine();
        System.out.println("Digite o id do seguro Referente:");
        int id = scanner.nextInt();
        System.out.println("Digite o id do sinistro referente:");
        int id1 = scanner.nextInt();
        for(Seguradora seguradora3 : listaSeguradora) {
            if (seguradora3.getCNPJ().equals(cnpj)) {
                for(Seguro seguro : seguradora3.getListaSeguros()){
                    if (seguro.getId() == (id)) {
                        for(Sinistro sinistro : seguro.getListaSinistro()){
                            if(sinistro.getID() == id1){
                                seguradora3.getListaClientes().remove(sinistro);
                                System.out.println("Sinistro removido");
                                return listaSeguradora;
                            }
                            else{
                                System.out.println("Sinistro não existe");
                                return listaSeguradora;
                        }

                    }

                    }
                }
            }
            else{
                System.out.println("Sinistro não existe");
                return listaSeguradora;
            }
        }
        return listaSeguradora;
    }

    static List<Seguradora> GERAR_SEGUROPF(List<Seguradora> listaSeguradora) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SeguroPf seguroPf = Leitura.leSeguroPf(listaSeguradora);
        System.out.println("Digite o CNPJ da seguradora referente:");
        String seguradora1 = scanner.nextLine();
        for(Seguradora seguradora : listaSeguradora){
            if(seguradora.getCNPJ().equals(seguradora1)){
                seguradora.getListaSeguros().add(seguroPf);
                System.out.println("Seguro gerado");
                return listaSeguradora;
            }
            else{
                System.out.println("Seguro não gerado");
            }
        }
        return listaSeguradora;
    }
    static List<Seguradora> GERAR_SEGUROPJ(List<Seguradora> listaSeguradora) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SeguroPj seguroPj = Leitura.leSeguroPj(listaSeguradora);
        System.out.println("Digite o CNPJ da seguradora referente:");
        String seguradora1 = scanner.nextLine();
        for(Seguradora seguradora : listaSeguradora){
            if(seguradora.getCNPJ().equals(seguradora1)){
                seguradora.getListaSeguros().add(seguroPj);
                System.out.println("Seguro gerado");
                return listaSeguradora;
            }
            else{
                System.out.println("Seguro não gerado");
            }
        }
        return listaSeguradora;
    }

}
