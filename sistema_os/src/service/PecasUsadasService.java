/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.PecasUsadas;
import repository.PecasUsadasRepository;

/**
 *
 * @author Escola
 */
public class PecasUsadasService {
    PecasUsadasRepository pecasUsadasRepository = new PecasUsadasRepository();
    
    public PecasUsadas salvarPeca(PecasUsadas pecasUsadas){
        return pecasUsadasRepository.salvarPeca(pecasUsadas);
    }
}
