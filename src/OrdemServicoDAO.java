import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO {

    private static final String ORDEM_TXT = "OrdemServico.txt";

    /* Retorna as ordens de serviço em forma de lista
     */
    public List<OrdemServico> getList() {
        List<OrdemServico> list = new ArrayList<OrdemServico>();
        try {
            FileReader fr = new FileReader(ORDEM_TXT);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] var = line.split(";");
                OrdemServico os = new OrdemServico();
                os.setCodigo(Integer.parseInt(var[0]));
                os.setData(var[1]);
                os.setPrestador(var[2]);
                os.setUnidade(var[3]);
                os.setValor(Float.parseFloat(var[4]));
                os.setStatus(var[5]);
                os.setDataFechamento(var[6]);

                list.add(os);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
      Retorna uma ordem de serviço para o código
     */
    public OrdemServico getOrdemServico (int cod) {
        List<OrdemServico> list = getList();
        for (OrdemServico os : list) {
            if (os.getCodigo() == cod) {
                return os;
            }
        }
        return null;
    }


    /*
     * Insere uma ordem de serviço.
     * O arquivo é aberto para leitura, porém, com append=true
     * para escrever no final do arquivo.
     */
    public void inserir(OrdemServico os) {
        try {
            FileWriter fw =
                    new FileWriter(ORDEM_TXT, true);
            String line = getLine(os);
            fw.write(line);
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Método auxiliar para manter o padrão do arquivo.
     */
    private String getLine(OrdemServico os) {
        String line = os.getCodigo()
                + ";" + os.getData()
                + ";" + os.getPrestador()
                + ";" + os.getUnidade()
                + ";" + os.getValor()
                + ";" + os.getStatus()
                + ";" + os.getDataFechamento()
                + "\r\n";
        return line;
    }


    /*
     * Atualiza uma ordem de serviço.
     */
    public void atualizar(OrdemServico osAtualizar) {

        // Recupera todo os prestadores.
        List<OrdemServico> list = getList();

        try {
            // Abrir o arquivo para escrita, reescrevendo tudo.
            FileWriter fw = new FileWriter(ORDEM_TXT, false);
            for (OrdemServico os : list) {
                String line = getLine(os);
                if (os.getCodigo() == osAtualizar.getCodigo()) {
                    line = getLine(osAtualizar);
                }
                fw.write(line);
            }
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Excluir uma ordem de serviço.
     */
    public void excluir(OrdemServico osExcluir) {

        // Recupera todo os prestadores.
        List<OrdemServico> list = getList();

        try {
            // Abrir o arquivo para escrita, reescrevendo tudo.
            FileWriter fw = new FileWriter(ORDEM_TXT, false);
            for (OrdemServico os : list) {
                String line = getLine(os);
                if (os.getCodigo() == osExcluir.getCodigo()) {
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
