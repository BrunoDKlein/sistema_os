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
                + "telefone, "
                + "email, "
                + "endereco) "
                + "VALUES(?,?,?,?)";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, cliente.getNome());
            ppst.setString(2, cliente.getTelefone());
            ppst.setString(3, cliente.getEmail());
            ppst.setString(4, cliente.getEndereco());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return cliente;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public Cliente buscarClientePorID(int id) {
        conn = util.conexao();
        String sql = "SELECT * FROM clientes WHERE id = ?;";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, id);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                return new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            ppst.close();
            conn.close();
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public List< Cliente> buscarClientes(String nomeDoCliente) {
        conn = util.conexao();
        String sql = "SELECT * FROM clientes WHERE nome like ?;";
        List< Cliente> clientes = new ArrayList<>();
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, "%" + nomeDoCliente + "%");
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }
    public List< Cliente> buscarTodosClientes() {
        conn = util.conexao();
        String sql = "SELECT * FROM clientes;";
        List< Cliente> clientes = new ArrayList<>();
        try {
            ppst = conn.prepareStatement(sql);
                     ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }

    public Cliente editarCliente(Cliente cliente) {
        System.out.println("aqui");

        conn = util.conexao();
        String sql = "Update cliente set "
                + "endereco = ?, "
                + "telefone = ?, "
                + "email = ?, "
                + "nome = ? "
                + "where id = ?;";

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

    public boolean excluirCliente(String nomeDoCliente) {
        conn = util.conexao();
        String sql = "delete from cliente where id =?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, nomeDoCliente);
            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
