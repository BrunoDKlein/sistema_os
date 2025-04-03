package entity;

// * @author Victor
import java.util.List;

public class Pagamento {

    private int id;
    private String nomeDoPagador;
    private int numeroNota;
    private String data;
    private int valor;
    private String metodoPagamento;

    public Pagamento(int id, String nomeDoPagador, int numeroNota, String data, int valor, String metodoPagamento) {
        this.id = id;
        this.nomeDoPagador = nomeDoPagador;
        this.numeroNota = numeroNota;
        this.data = data;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nomeDoPagador;
    }

    public int getNumeroPaginas() {
        return numeroNota;
    }

    public String getData() {
        return data;
    }

    public int getvalor() {
        return valor;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

}
