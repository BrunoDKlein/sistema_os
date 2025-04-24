/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.OrdemServico;
import repository.OrdemServicoRepository;

/**
 *
 * @author admin
 */
public class OrdemServicoService {
    OrdemServicoRepository ordemServicoRepository = new OrdemServicoRepository();
    public boolean salvarOrdemServico(OrdemServico ordemServico) {
        return ordemServicoRepository.salvarOrdemServico(ordemServico);
    }
}
