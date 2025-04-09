/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tecnico;
import repository.TecnicoRepository;

/**
 *
 * @author Escola
 */
public class TecnicoService {

    TecnicoRepository tecnicoRepository = new TecnicoRepository();

    public Tecnico salvarTecnico(Tecnico tecnico) {

        return tecnicoRepository.salvarTecnico(tecnico);

    }

}
