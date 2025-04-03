/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import resources.UtilDb;

/**
 *
 * @author kelvin
 */
public class ClienteRepository {

    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;
    String Nome;
    String Endereco;
    int Telefonte = 0;
    String Email;

    public Cliente cadastrarCliente(Cliente cliente) {
        conn = util.conexao();
        String sql = "INSERT INTO cliente("
                + "Nome,"
                + "endereco,"
                + "Telefone,"
                + "email"
                + "VALUES(?,?,?,?,?,?)";
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

   

   

}
