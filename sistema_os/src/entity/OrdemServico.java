/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class OrdemServico {

    private int id;
    private Cliente cliente;
    private Aparelho aparelho;
    private Tecnico tecnico;
    private LocalDate data_abertura;
    private LocalDate data_fechamento;
    private String status;
    private String descricao_problema;
    private String solucao;
    private Double custo_total;
    List<PecasUsadas> pecasUsadas;

    public OrdemServico() {
    }

    public OrdemServico(int id, Cliente cliente, Aparelho aparelho, Tecnico tecnico, LocalDate data_abertura, LocalDate data_fechamento, String status, String descricao_problema, String solucao, Double custo_total) {
        this.id = id;
        this.cliente = cliente;
        this.aparelho = aparelho;
        this.tecnico = tecnico;
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

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Aparelho getAparelho() {
        return aparelho;
    }

    public void setAparelho(Aparelho aparelho) {
        this.aparelho = aparelho;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public LocalDate getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(LocalDate data_abertura) {
        this.data_abertura = data_abertura;
    }

    public LocalDate getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(LocalDate data_fechamento) {
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

    public List<PecasUsadas> getPecasUsadas() {
        return pecasUsadas;
    }

    public void setPecasUsadas(List<PecasUsadas> pecasUsadas) {
        this.pecasUsadas = pecasUsadas;
    }
    

}
