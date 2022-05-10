import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class UnidadeEmpresaDAO {

    /* Nome do arquivo comum a todas as operaçoes. */
    private static final String UNIDADE_TXT = "UnidadeEmpresa.txt";

    /*
     * Retorna todos as unidades em forma de lista.
     */
    public List<UnidadeEmpresa> getList() {
        List<UnidadeEmpresa> list = new ArrayList<UnidadeEmpresa>();
        try {
            FileReader fr = new FileReader(UNIDADE_TXT);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] var = line.split(";");
                UnidadeEmpresa ue = new UnidadeEmpresa();
                ue.setCodigo(Integer.parseInt(var[0]));
                ue.setNome(var[1]);
                ue.setResponsaval(var[2]);
                ue.setTipo(var[3]);

                list.add(ue);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
     * Retorna uma unidade para seu codigo.
     */
    public UnidadeEmpresa getUnidadeEmpresa (int cod) {
        List<UnidadeEmpresa> list = getList();
        for (UnidadeEmpresa ue : list) {
            if (ue.getCodigo() == cod) {
                return ue;
            }
        }
        return null;
    }


    /*
     * Insere uma unidade.
     */
    public void inserir(UnidadeEmpresa ue) {
        try {
            FileWriter fw =
                    new FileWriter(UNIDADE_TXT, true);
            String line = getLine(ue);
            fw.write(line);
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Metodo auxiliar para manter o padrao do arquivo.
     */
    private String getLine(UnidadeEmpresa ue) {
        String line = ue.getCodigo()
                + ";" + ue.getNome()
                + ";" + ue.getResponsaval()
                + ";" + ue.getTipo()
                + "\r\n";
        return line;
    }


    /*
     * Atualiza um prestador.
     */
    public void atualizar(UnidadeEmpresa ueAtualizar) {

        // Recupera todo os prestadores.
        List<UnidadeEmpresa> list = getList();

        try {
            // Abrir o arquivo para escrita, reescrevendo tudo.
            FileWriter fw = new FileWriter(UNIDADE_TXT, false);
            for (UnidadeEmpresa ue : list) {
                String line = getLine(ue);
                if (ue.getCodigo() == ueAtualizar.getCodigo()) {
                    line = getLine(ueAtualizar);
                }
                fw.write(line);
            }
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Excluir um prestador.
     */
    public void excluir(UnidadeEmpresa ueExcluir) {

        // Recupera todo os prestadores.
        List<UnidadeEmpresa> list = getList();

        try {
            // Abrir o arquivo para escrita, reescrevendo tudo.
            FileWriter fw = new FileWriter(UNIDADE_TXT, false);
            for (UnidadeEmpresa ue : list) {
                String line = getLine(ue);
                if (ue.getCodigo() == ueExcluir.getCodigo()) {
                    continue;  // Nada a fazer, somente n�o escreve no arquivo.
                }
                fw.write(line);
            }
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
