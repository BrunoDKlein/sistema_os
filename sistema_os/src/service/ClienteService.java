/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Cliente;
import repository.ClienteRepository;

/**
 *
 * @author kelvin
 */
public class ClienteService {

    ClienteRepository clienteRepository = new ClienteRepository();

    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.cadastrarCliente(cliente);
    }

// public Cliente editarCliente(Cliente cliente) {
//        return clienteRepository.editarCliente(cliente);
//    }
//
//    public boolean excluirContato(int id_contato) {
//return contatoRepository.excluirContato(id_contato);
//    }

   
}