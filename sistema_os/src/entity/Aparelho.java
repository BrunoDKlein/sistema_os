package entity;

public class Aparelho {

    private int id;
    private String marca;
    private String modelo;
    private String descricao;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Aparelho(int id, String marca, String modelo, String descricao) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
    }

    

}
