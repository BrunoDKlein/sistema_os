/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Escola
 */
public class PecaUsada {

    private int id;
    private OrdemServico ordemServico;
    private String descricao;
    private int quantidade;
    private double precoUnitario;
    private double precoDeCusto;

    public PecaUsada() {
    }

    public PecaUsada(int id, OrdemServico ordemServico, String descricao, int quantidade, double precoUnitario, double precoDeCusto) {
        this.id = id;
        this.ordemServico = ordemServico;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoDeCusto = precoDeCusto;
    }
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(double precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    @Override
    public String toString() {
        return "PecaUsada{" + "id=" + id + ", ordemServico=" + ordemServico + ", descricao=" + descricao + ", quantidade=" + quantidade + ", precoUnitario=" + precoUnitario + ", precoDeCusto=" + precoDeCusto + '}';
    }
    
    
}
