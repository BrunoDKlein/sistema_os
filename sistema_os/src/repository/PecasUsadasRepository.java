/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.PecasUsadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            ppst.setInt(4, pecasUsadas.getId());
            
            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return pecasUsadas;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public PecasUsadas buscarPeca(String descricao, int quantidade) throws Exception{
        conn = util.conexao();
         String sql = "SELECT * from pecas_usadas WHERE descricao = ? and quantidade = ?";
          try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, descricao);
            ppst.setInt(2, quantidade);
         
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
//                return new Contato(rs.getInt(1), rs.getString(2), rs.getString(3),
//                        rs.getString(4), rs.getString(5), rs.getString(6));
                throw new Exception("Essa peça já existe.");
            }
            
            ppst.close();
            conn.close();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
          return null;
    }
    
}
