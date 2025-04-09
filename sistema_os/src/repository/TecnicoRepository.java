/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Tecnico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import resources.UtilDb;

/**
 *
 * @author Escola
 */
public class TecnicoRepository {

    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;

    public Tecnico salvarTecnico(Tecnico tecnico) {
        conn = util.conexao();
        String sql = "INSERT INTO tecnicos ("
                + "nome, "
                + "telefone, "
                + "email) "
                + "VALUES(?,?,?)";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, tecnico.getNome());

            ppst.setString(2, tecnico.getTelefone());
            ppst.setString(3, tecnico.getEmail());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return tecnico;
        } catch (SQLException ex) {
            return null;
        }
    }
}
