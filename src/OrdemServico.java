import java.util.List;
import java.util.Scanner;

public class OrdemServico {

    private int codigo;
    private String data;
    private String prestador;
    private List<Integer> tipoServico;
    private String unidade;
    private float valor;
    private String status;
    private String dataFechamento;

    public final int getCodigo() {
        return codigo;
    }
    public final void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public final String getData() {
        return data;
    }
    public final void setData(String data) {
        this.data = data;
    }
    public final String getPrestador() {
        return prestador;
    }
    public final void setPrestador(String prestador) {
        this.prestador = prestador;
    }
    public final List<Integer> getTipoServico() {
        return tipoServico;
    }
    public final void setTipoServico(List<Integer> tipoServico) {
        this.tipoServico = tipoServico;
    }
    public final String getUnidade() {
        return unidade;
    }
    public final void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    public final float getValor() {
        return valor;
    }
    public final void setValor(float valor) {
        this.valor = valor;
    }
    public final String getStatus() {
        return status;
    }
    public final void setStatus(String status) {
        this.status = status;
    }
    public final String getDataFechamento() {
        return dataFechamento;
    }
    public final void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public void menu(Scanner sc) {
    }
}
