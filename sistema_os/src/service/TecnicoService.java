/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tecnico;
import java.util.List;
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
    
     public List<Tecnico> buscarTecnicosPorNome(String nome) {
         System.out.println("service");
          return tecnicoRepository.buscarTecnicosPorNome(nome);
     }
public Tecnico buscarTecnicoPorID(int id) {
        return tecnicoRepository.BuscarTecnicoPorID(id);
}

public Tecnico editarTecnico(Tecnico tecnico) {
    return tecnicoRepository.editarTecnico(tecnico);
}
     
}
