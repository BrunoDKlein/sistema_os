/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.PecaUsada;
import java.sql.ResultSet;
import repository.PecaUsadaRepository;

/**
 *
 * @author Escola
 */
public class PecaUsadaService {

    PecaUsadaRepository pecasUsadasRepository = new PecaUsadaRepository();

    public boolean pecaValida(PecaUsada pecasUsadas) throws NullPointerException {
        if (pecasUsadas.getDescricao() == null || pecasUsadas.getDescricao().equals("")) {
            throw new NullPointerException("É necessário informar uma descrição.");
        }
        if (pecasUsadas.getQuantidade() < 1) {
            throw new NullPointerException("É necessário informar uma quantidade.");
        }
        if (pecasUsadas.getPrecoUnitario() < 1) {
            throw new NullPointerException("É necessário informar um preço unitário.");
        }
        if (pecasUsadas.getPrecoDeCusto() < 1) {
            throw new NullPointerException("É necessário informar um preço de custo.");
        }
        return true;
    }

    public PecaUsada buscarPeca(int id) {
        return pecasUsadasRepository.buscarPeca(id);
    }
    
    

}
