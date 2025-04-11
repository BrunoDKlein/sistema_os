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
    
    public PecaUsada salvarPeca(PecaUsada pecasUsadas){
        System.out.println("A");
        return pecasUsadasRepository.salvarPeca(pecasUsadas);
    }
    
    public PecaUsada buscarPeca( int id){
        return pecasUsadasRepository.buscarPeca(id);
    }
    
}
