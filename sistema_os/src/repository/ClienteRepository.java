/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.UtilDb;

/**
 *
 * @author kelvin
 */
public class ClienteRepository {

    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;

    public Cliente cadastrarCliente(Cliente cliente) {
        conn = util.conexao();
        String sql = "INSERT INTO clientes("
                + "nome, "
                + "endereco, "
                + "telefone, "
                + "email)"
                + "id_agenda) "
                + "VALUES(?,?,?,?,?)";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, cliente.getNome());
            ppst.setString(2, cliente.getEndereco());
            ppst.setString(3, cliente.getTelefone());
            ppst.setString(4, cliente.getEmail());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return cliente;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    public Cliente BuscarClientePorNome(String nome) throws Exception {
        conn = util.conexao();
        String sql = "SELECT * FROM contato WHERE nome =? and nome =?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, nome);
            ppst.setString(2, nome);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {

                throw new Exception("Já existe um(a) cliente no banco com este nome");
            }
            ppst.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    
    public List< Cliente> buscarCliente(int id_cliente) {
        conn = util.conexao();
        String sql = "SELECT * FROM contato WHERE id_agenda = ?;";
        List< Cliente > clientes = new ArrayList<>();
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, id_cliente);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                Cliente contato = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                        
                clientes.add(contato);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }

    public Cliente editarCliente(Cliente cliente) {
        System.out.println("aqui");

        conn = util.conexao();
        String sql = "Update contato set "
                + "nome = ?, "
                + "endereco = ?, "
                + "telefone = ?, "
                + "email = ?, "
                + "where id = ?";

        try {

            ppst = conn.prepareStatement(sql);
            ppst.setString(1, cliente.getNome());
            ppst.setString(2, cliente.getEndereco());
            ppst.setString(3, cliente.getTelefone());
            ppst.setString(4, cliente.getEmail());
            ppst.setInt(5, cliente.getId());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return cliente;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean excluirContato(int id_cliente) {
        conn = util.conexao();
        String sql = "delete from contato where id =?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, id_cliente);
            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
    

