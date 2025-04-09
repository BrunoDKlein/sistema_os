package entity;

// * @author Victor
import java.time.LocalDate;

public class Pagamento {

    private int id;
    private Cliente cliente;
    private OrdemServico ordemServico;
    private LocalDate data;
    private double valor;
    private String metodoPagamento;

    public Pagamento(int id, Cliente cliente, OrdemServico ordemServico, LocalDate data, double valor, String metodoPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.ordemServico = ordemServico;
        this.data = data;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    public Pagamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    
    
}
