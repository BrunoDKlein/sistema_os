package entity;

public class Aparelho {

    private int id;
    private Cliente cliente;
    private String marca;
    private String modelo;
    private String descricao;

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aparelho() {
    }

    public Aparelho(int id, Cliente cliente, String marca, String modelo, String descricao) {
        this.id = id;
        this.cliente = cliente;
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
    }

    


}
