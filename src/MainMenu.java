import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        menu();
    }
    private static void menu() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Controle de Ordem de Serviço");
            System.out.println("1 - Prestador");
            System.out.println("2 - Ordem de Serviço");
            System.out.println("3 - Tipo de Serviço");
            System.out.println("4 - Unidade Empresa");
            System.out.println("5 - Sair");
            String opcao = sc.nextLine();
            if (opcao.equals("1")) {
                PrestadorMenu p = new PrestadorMenu();
                p.menu(sc);
            } else if (opcao.equals("2")) {
                OrdemServicoMenu os = new OrdemServicoMenu();
                os.menu(sc);
            }
            else if (opcao.equals("3")) {
                TipoServicoMenu ts = new TipoServicoMenu();
                ts.menu(sc);
            }
            else if (opcao.equals("4")) {
                UnidadeEmpresaMenu ue = new UnidadeEmpresaMenu();
                ue.menu(sc);
            }
            else if (opcao.equals("5")) {
                break;
            } else {
                System.out.println("Opçao nao conhecida");
            }
        }
        sc.close();
        System.out.println("Programa encerrado.");
    }

}
