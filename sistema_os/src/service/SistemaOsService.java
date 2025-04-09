/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.OrdemServico;
import java.util.List;
import repository.SistemaOsRepository;

/**
 *
 * @author admin
 */
public class SistemaOsService {

    SistemaOsRepository sistemaOsRepository = new SistemaOsRepository();

    public boolean excluirOs(int id_os) {
        return sistemaOsRepository.excluirOs(id_os);
    }
    
    public OrdemServico buscarOsPorId(int id_Os) {
        return sistemaOsRepository.buscarOsPorId(id_Os);
    }
    
    public List<OrdemServico> buscarTodasAsOs() {
        return sistemaOsRepository.buscarTodasAsOs();
    }
}
