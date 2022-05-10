import java.util.List;
import java.util.Scanner;

public class OrdemServicoMenu {


    // Inicio Ordem Serv. Menu

    public void menu (Scanner sc) {
        while(true) {
            System.out.println("Cadastro de Prestador de Servi�o");
            System.out.println("1 - Listar");
            System.out.println("2 - Incluir");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Voltar");
            String opcao = sc.nextLine();
            if (opcao.equals("1")) {
                listar();
            } else if (opcao.equals("2")) {
                incluir(sc);
            } else if (opcao.equals("3")) {
                atualizar(sc);
            } else if (opcao.equals("4")) {
                excluir(sc);
            } else if (opcao.equals("5")) {
                break;
            } else {
                System.out.println("Opção não conhecida" + opcao);
            }
        }

    }

    private void listar() {
        OrdemServicoDAO dao = new OrdemServicoDAO();
        List<OrdemServico> list = dao.getList();
        for (OrdemServico os : list) {
            System.out.println("Codigo:" + os.getCodigo()
                    + " Data:" + os.getData()
                    + " Prestador:" + os.getPrestador()
                    + " Unidade: " + os.getUnidade()
                    + " Valor: " + os.getValor()
                    + " Status: " + os.getStatus()
                    + " Data Fechamento: " + os.getDataFechamento());
        }
    }

    private void incluir(Scanner sc) {
        System.out.println("Incluir uma Ordem de Serviço:");
        System.out.println("Codigo:");
        String codigo = sc.nextLine();
        System.out.println("Data:");
        String data = sc.nextLine();
        System.out.println("Prestador:");
        String prestador = sc.nextLine();
        System.out.println(" Unidade : ");
        String unidade = sc.nextLine();
        System.out.println("Valor: ");
        int valor = sc.nextInt();
        System.out.println("Status: ");
        String status = sc.nextLine();
        System.out.println("Data Fechamento: ");
        String dataFechamento = sc.nextLine();


        if (codigo == null
                || codigo.trim().length() == 0) {
            System.out.println("Código inválido.");
            return;
        }
        if (data == null
                || data.trim().length() == 0) {
            System.out.println("Data inválida.");
            return;
        }
        if (prestador == null
                || prestador.trim().length() == 0) {
            System.out.println("Nome inválido.");
            return;
        }
        if (codigo == null
                || codigo.trim().length() == 0) {
            System.out.println("Código inválido.");
            return;
        }
        if (unidade == null
                || unidade.trim().length() == 0) {
            System.out.println("Código inválido.");
            return;
        }
        int cod = 0;
        try {
            cod = Integer.parseInt(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Codigo deve ser numérico");
            return;
        }

        OrdemServico os = new OrdemServico();
        os.setCodigo(cod);
        os.setData(data);
        os.setPrestador(prestador);
        os.setUnidade(unidade);
        os.setValor(valor);
        os.setStatus(status);
        os.setDataFechamento(dataFechamento);


        OrdemServicoDAO dao = new OrdemServicoDAO();
        dao.inserir(os);
    }

    private void atualizar(Scanner sc) {
        System.out.println("Atualizar uma ordem de Serviço:");
        System.out.println("Informe o código:");
        String codigo = sc.nextLine();

        if (codigo == null
                || codigo.trim().length() == 0) {
            System.out.println("Código inválido.");
            return;
        }
        int cod = 0;
        try {
            cod = Integer.parseInt(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Código deve ser numérico");
            return;
        }
        OrdemServicoDAO dao = new OrdemServicoDAO();
        OrdemServico os = dao.getOrdemServico(cod);
        if (os == null) {
            System.out.println("Prestador não encontrado:" + cod);
            return;
        }

        System.out.println("Codigo (" + os.getCodigo() +"):");
        codigo = sc.nextLine();
        System.out.println("Data (" + os.getData() +"):");
        String data = sc.nextLine();
        // CONTINUAR...
        System.out.println("Prestador (" + os.getPrestador() +"):");
        String prestador = sc.nextLine();
        System.out.println("Unidade (" + os.getUnidade() +"):");
        String unidade = sc.nextLine();
        System.out.println("Valor (" + os.getValor() +"):");
        float valor = sc.nextFloat();
        System.out.println("Status (" + os.getStatus() +"):");
        String status = sc.nextLine();
        System.out.println("Data Fechamento (" + os.getDataFechamento() +"):");
        String dataFechamento = sc.nextLine();

        os.setData(data);
        os.setPrestador(prestador);
        os.setUnidade(unidade);
        os.setValor(valor);
        os.setStatus(status);
        os.setDataFechamento(dataFechamento);

        dao.atualizar(os);
    }

    private void excluir(Scanner sc) {
        System.out.println("Atualizar um prestador:");
        System.out.println("Informe o Codigo:");
        String codigo = sc.nextLine();

        if (codigo == null
                || codigo.trim().length() == 0) {
            System.out.println("Codigo invalido.");
            return;
        }
        int cod = 0;
        try {
            cod = Integer.parseInt(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Codigo deve ser numerico");
            return;
        }
        OrdemServicoDAO dao = new OrdemServicoDAO();
        OrdemServico os = dao.getOrdemServico(cod);
        if (os == null) {
            System.out.println("Prestador nao encontrado:" + cod);
            return;
        }
        dao.excluir(os);
    }


}
