import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TipoServicoDAO {

    /* Nome do arquivo comum a todas as operaçoes. */
    private static final String TIPOSERVICO_TXT = "TipoServico.txt";

    /*
     * Retorna todos os serviços em forma de lista.
     */
    public List<TipoServico> getList() {
        List<TipoServico> list = new ArrayList<TipoServico>();
        try {
            FileReader fr = new FileReader(TIPOSERVICO_TXT);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] var = line.split(";");
                TipoServico ts = new TipoServico();
                ts.setCodigo(Integer.parseInt(var[0]));
                ts.setNome(var[1]);
                ts.setValor(Float.parseFloat(var[2]));

                list.add(ts);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
     * Retorna um serviço para seu codigo.
     */
    public TipoServico getOrdemServico (int cod) {
        List<TipoServico> list = getList();
        for (TipoServico ts : list) {
            if (ts.getCodigo() == cod) {
                return ts;
            }
        }
        return null;
    }


    /*
     * Insere um serviço.
     */
    public void inserir(TipoServico ts) {
        try {
            FileWriter fw =
                    new FileWriter(TIPOSERVICO_TXT, true);
            String line = getLine(ts);
            fw.write(line);
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Metodo auxiliar para manter o padrao do arquivo.
     */
    private String getLine(TipoServico ts) {
        String line = ts.getCodigo()
                + ";" + ts.getNome()
                + ";" + ts.getValor()
                + "\r\n";
        return line;
    }


    /*
     * Atualiza um prestador.
     */
    public void atualizar(TipoServico tsAtualizar) {

        // Recupera todo os prestadores.
        List<TipoServico> list = getList();

        try {
            // Abrir o arquivo para escrita, reescrevendo tudo.
            FileWriter fw = new FileWriter(TIPOSERVICO_TXT, false);
            for (TipoServico ts : list) {
                String line = getLine(ts);
                if (ts.getCodigo() == tsAtualizar.getCodigo()) {
                    line = getLine(tsAtualizar);
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
    public void excluir(TipoServico tsExcluir) {

        // Recupera todo os prestadores.
        List<TipoServico> list = getList();

        try {
            // Abrir o arquivo para escrita, reescrevendo tudo.
            FileWriter fw = new FileWriter(TIPOSERVICO_TXT, false);
            for (TipoServico ts : list) {
                String line = getLine(ts);
                if (ts.getCodigo() == tsExcluir.getCodigo()) {
                    continue;  // Nada a fazer, somente n�o escreve no arquivo.
                }
                fw.write(line);
            }
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public TipoServico getTipoServico(int cod) {
        return null;
    }
}
