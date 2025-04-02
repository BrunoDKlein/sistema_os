/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kelvin
 */
public class Cliente {

    private final UtilSql util = new UtilSql();
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
            ppst.setString(1, cliente.Nome);
            ppst.setString(2, cliente.Endereco());
            ppst.setString(3, cliente.Telefone());
            ppst.setString(4, cliente.Email());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return cliente;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    private String Endereco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String Telefone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String Email() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
