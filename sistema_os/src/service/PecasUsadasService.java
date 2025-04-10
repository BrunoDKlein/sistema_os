/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.PecasUsadas;
import java.sql.ResultSet;
import repository.PecasUsadasRepository;

/**
 *
 * @author Escola
 */
public class PecasUsadasService {
    PecasUsadasRepository pecasUsadasRepository = new PecasUsadasRepository();
    
    public PecasUsadas salvarPeca(PecasUsadas pecasUsadas){
        System.out.println("A");
        return pecasUsadasRepository.salvarPeca(pecasUsadas);
    }
    
    public PecasUsadas buscarPeca( int id){
        return pecasUsadasRepository.buscarPeca(id);
    }
    
}
