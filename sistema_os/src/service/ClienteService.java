/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Cliente;
import java.util.List;
import repository.ClienteRepository;

/**
 *
 * @author kelvin
 */
public class ClienteService {

    ClienteRepository clienteRepository = new ClienteRepository();

    public Cliente cadastrarCliente(Cliente cliente) {

        if (cliente.getNome() == null || cliente.getNome().equals("")) {
            throw new NullPointerException("é necessário informar o nome do cliente");
        }
        return clienteRepository.cadastrarCliente(cliente);

    }

    public List< Cliente> buscarClientes(String nomeDoCliente) {
        return clienteRepository.buscarClientes(nomeDoCliente);
    }

    public Cliente editarCliente(Cliente cliente) {
        return clienteRepository.editarCliente(cliente);
    }

    public boolean excluirCliente(String cliente) {
        return clienteRepository.excluirCliente(cliente);
    }
}
