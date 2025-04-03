/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.PecasUsadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import resources.UtilDb;



/**
 *
 * @author Escola
 */
public class PecasUsadasRepository {
    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;
    
    public PecasUsadas salvarPeca(PecasUsadas pecasUsadas){
        conn = util.conexao();
        String db = "INSERT INTO pecasUsadas("
                + "descricao, "
                + "quantidade, "
                + "preco_unitario, "
                + "id_os)"
                + "VALUES (?,?,?,?)";
        
        try {
            ppst = conn.prepareStatement(db);
            ppst.setString(1, pecasUsadas.getDescricao());
            ppst.setInt(2, pecasUsadas.getQuantidade());
            ppst.setDouble(3, pecasUsadas.getPrecoUnitario());
            ppst.setInt(4, pecasUsadas.getPecasUsadas().getId());
            
            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return pecasUsadas;
        } catch (Exception ex) {
            return null;
        }
    }
    
//    public PecasUsadas buscarPeca()
    
}
