/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.OrdemServico;
import repository.SistemaOsRepository;

/**
 *
 * @author admin
 */
public class SistemaOsService {

    SistemaOsRepository sistemaOsRepository = new SistemaOsRepository();

    public OrdemServico criarOs(OrdemServico sistemaOs){
            return sistemaOsRepository.salvarContato(sistemaOs);
    }

    public Contato editarContato(Contato contato) {
        return contatoRepository.editarContato(contato);
    }

    public boolean excluirOs(int id_os) {
        return sistemaOsRepository.excluirOs(id_os);
    }
}
