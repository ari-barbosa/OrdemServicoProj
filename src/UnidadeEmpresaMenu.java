import java.util.List;
import java.util.Scanner;

public class UnidadeEmpresaMenu {


    // Inicio Ordem Serv. Menu

    public void menu (Scanner sc) {
        while(true) {
            System.out.println("Cadastro de Unidade Empresa");
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
        UnidadeEmpresaDAO dao = new UnidadeEmpresaDAO();
        List<UnidadeEmpresa> list = dao.getList();
        for (UnidadeEmpresa ue : list) {
            System.out.println("Codigo:" + ue.getCodigo()
                    + " Nome:" + ue.getNome()
                    + " Responsável:" + ue.getResponsaval()
                    + " Unidade: " + ue.getTipo()
                   );
        }
    }

    private void incluir(Scanner sc) {
        System.out.println("Incluir uma Ordem de Serviço:");
        System.out.println("Codigo:");
        String codigo = sc.nextLine();
        System.out.println("Nome:");
        String nome = sc.nextLine();
        System.out.println("Responsável:");
        String responsaval = sc.nextLine();
        System.out.println(" Tipo : ");
        String tipo = sc.nextLine();


        if (codigo == null
                || codigo.trim().length() == 0) {
            System.out.println("Código inválido.");
            return;
        }
        if (nome == null
                || nome.trim().length() == 0) {
            System.out.println("Nome inválida.");
            return;
        }
        if (responsaval == null
                || responsaval.trim().length() == 0) {
            System.out.println("Responsável inválido.");
            return;
        }
        if (tipo == null
                || tipo.trim().length() == 0) {
            System.out.println("Tipo inválido.");
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

        UnidadeEmpresa ue = new UnidadeEmpresa();
        ue.setCodigo(cod);
        ue.setNome(nome);
        ue.setResponsaval(responsaval);
        ue.setTipo(tipo);


        UnidadeEmpresaDAO dao = new UnidadeEmpresaDAO();
        dao.inserir(ue);
    }

    private void atualizar(Scanner sc) {
        System.out.println("Atualizar uma Unidade de empresa:");
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
        UnidadeEmpresaDAO dao = new UnidadeEmpresaDAO();
        UnidadeEmpresa ue = dao.getUnidadeEmpresa(cod);
        if (ue == null) {
            System.out.println("Unidade não encontrada:" + cod);
            return;
        }

        System.out.println("Codigo (" + ue.getCodigo() +"):");
        codigo = sc.nextLine();
        System.out.println("Nome (" + ue.getNome() +"):");
        String nome = sc.nextLine();
        System.out.println("Responsável (" + ue.getResponsaval() +"):");
        String responsaval = sc.nextLine();
        System.out.println("Tipo (" + ue.getTipo() +"):");
        String tipo = sc.nextLine();

        ue.setCodigo(Integer.parseInt(codigo));
        ue.setNome(nome);
        ue.setResponsaval(responsaval);
        ue.setTipo(tipo);

        dao.atualizar(ue);
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
        UnidadeEmpresaDAO dao = new UnidadeEmpresaDAO();
        UnidadeEmpresa ue = dao.getUnidadeEmpresa(cod);
        if (ue == null) {
            System.out.println("Prestador nao encontrado:" + cod);
            return;
        }
        dao.excluir(ue);
    }


}
