/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class SistemaOs {

    private int id;
    private int id_cliente;
    private int id_aparelho;
    private int id_tecnico;
    private Date data_abertura;
    private Date data_fechamento;
    private String status;
    private String descricao_problema;
    private String solucao;
    private Double custo_total;

    public SistemaOs() {
    }

    public SistemaOs(int id, int id_cliente, int id_aparelho, int id_tecnico, Date data_abertura, Date data_fechamento, String status, String descricao_problema, String solucao, Double custo_total) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_aparelho = id_aparelho;
        this.id_tecnico = id_tecnico;
        this.data_abertura = data_abertura;
        this.data_fechamento = data_fechamento;
        this.status = status;
        this.descricao_problema = descricao_problema;
        this.solucao = solucao;
        this.custo_total = custo_total;
    }

    public int getId() {
        return id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_aparelho() {
        return id_aparelho;
    }

    public void setId_aparelho(int id_aparelho) {
        this.id_aparelho = id_aparelho;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Date getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(Date data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao_problema() {
        return descricao_problema;
    }

    public void setDescricao_problema(String descricao_problema) {
        this.descricao_problema = descricao_problema;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Double getCusto_total() {
        return custo_total;
    }

    public void setCusto_total(Double custo_total) {
        this.custo_total = custo_total;
    }

}
