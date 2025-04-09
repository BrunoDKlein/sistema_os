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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
         String db = "SELECT * from pecas_usadas WHERE descricao = ? and quantidade = ?";
          try {
            ppst = conn.prepareStatement(db);
            ppst.setString(1, descricao);
            ppst.setInt(2, quantidade);
         
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
//                return new Contato(rs.getInt(1), rs.getString(2), rs.getString(3),
//                        rs.getString(4), rs.getString(5), rs.getString(6));
                throw new Exception("Peça já existente no sistema.");
            }
            
            ppst.close();
            conn.close();
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
          return null;
    }
    
    public List<PecasUsadas> buscarPecaPorOrdemDeServico(int id_os){
        conn = util.conexao();
        String db = "select * from pecas_usadas where id_os = ? limit 10;";
         List<PecasUsadas> pecasDaLista = new ArrayList<>();
         
          try {
            ppst = conn.prepareStatement(db);
            ppst.setInt(1, id_os);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                PecasUsadas pecasUsadas = new PecasUsadas(rs.getString(2), rs.getInt(3), rs.getDouble(4),
                        rs.getInt(5));
                pecasDaLista.add(pecasUsadas);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(PecasUsadasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pecasDaLista;
    }
    
}
