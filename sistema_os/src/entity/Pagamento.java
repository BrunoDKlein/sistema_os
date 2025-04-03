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

    public Pagamento(int id, String nomeDoPagador, OrdemServico ordemServico, LocalDate data, int valor, String metodoPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.ordemServico = ordemServico;
        this.data = data;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    public int getId() {
        return id;
    }

    public Cliente getNome() {
        return cliente;
    }

    public OrdemServico getIdOs() {
        return ordemServico;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
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

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

}
