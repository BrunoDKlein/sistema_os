/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import resources.UtilDb;

/**
 *
 * @author admin
 */
public class SistemaOsRepository {

    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;

    public boolean excluirOs(int id_os) {
        conn = util.conexao();
        String sql = "DELETE FROM ordens_servico WHERE id = ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, id_os);

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
