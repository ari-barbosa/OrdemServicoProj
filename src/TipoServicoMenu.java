import java.util.List;
import java.util.Scanner;

public class TipoServicoMenu {


    // Inicio Ordem Serv. Menu

    public void menu (Scanner sc) {
        while(true) {
            System.out.println("Cadastro de Tipo de Servico");
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
        TipoServicoDAO dao = new TipoServicoDAO();
        List<TipoServico> list = dao.getList();
        for (TipoServico ts : list) {
            System.out.println("Codigo:" + ts.getCodigo()
                    + " Nome:" + ts.getNome()
                    + " Valor:" + ts.getValor()
                   );
        }
    }

    private void incluir(Scanner sc) {
        System.out.println("Incluir um Tipo de Serviço:");
        System.out.println("Codigo:");
        String codigo = sc.nextLine();
        System.out.println("Nome:");
        String nome = sc.nextLine();
        System.out.println("Valor:");
        String valor = sc.nextLine();


        if (codigo == null
                || codigo.trim().length() == 0) {
            System.out.println("Código inválido.");
            return;
        }
        if (nome == null
                || nome.trim().length() == 0) {
            System.out.println("Nome inválido.");
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

        TipoServico ts = new TipoServico();
        ts.setCodigo(cod);
        ts.setNome(nome);
        ts.setValor(Float.parseFloat(valor));

        TipoServicoDAO dao = new TipoServicoDAO();
        dao.inserir(ts);
    }

    private void atualizar(Scanner sc) {
        System.out.println("Atualizar um tipo de serviço:");
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
        TipoServicoDAO dao = new TipoServicoDAO();
        TipoServico ts = dao.getTipoServico(cod);
        if (ts == null) {
            System.out.println("Tipo de Servico não encontrado:" + cod);
            return;
        }

        System.out.println("Codigo (" + ts.getCodigo() +"):");
        codigo = sc.nextLine();
        System.out.println("Nome (" + ts.getNome() +"):");
        String nome = sc.nextLine();
        System.out.println("Valor (" + ts.getValor() +"):");
        float valor = sc.nextFloat();

        ts.setNome(nome);
        ts.setCodigo(Integer.parseInt(codigo));
        ts.setValor(valor);

        dao.atualizar(ts);
    }

    private void excluir(Scanner sc) {
        System.out.println("Atualizar um tipo de serviço:");
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
        TipoServicoDAO dao = new TipoServicoDAO();
        TipoServico ts = dao.getTipoServico(cod);
        if (ts == null) {
            System.out.println("Tipo de serviço nao encontrado:" + cod);
            return;
        }
        dao.excluir(ts);
    }


}
