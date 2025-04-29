/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.OrdemServico;
import entity.PecaUsada;
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
public class PecaUsadaRepository {
    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;
    SistemaOsRepository osRepository = new SistemaOsRepository();
    
    public PecaUsada salvarPeca(PecaUsada pecasUsadas){
        System.out.println("e");
        conn = util.conexao();
        String db = "INSERT INTO pecas_usadas("
                + "id_os, "
                + "descricao, "
                + "quantidade, "
                + "preco_unitario, "
                + "preco_de_custo)"
                + "VALUES (?,?,?,?,?)";
        
        try {
            ppst = conn.prepareStatement(db);
            ppst.setString(1, pecasUsadas.getDescricao());
            ppst.setInt(2, pecasUsadas.getQuantidade());
            ppst.setDouble(3, pecasUsadas.getPrecoUnitario());
            ppst.setDouble(4, pecasUsadas.getPrecoDeCusto());
            ppst.setInt(5, pecasUsadas.getId());
            
            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return pecasUsadas;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public PecaUsada buscarPeca( int id){
        conn = util.conexao();
         String db = "SELECT * from pecas_usadas WHERE id = ? ";
          try {
            ppst = conn.prepareStatement(db);
            ppst.setInt(1, id);
         
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                return new PecaUsada(rs.getInt(1), osRepository.buscarOsPorId(rs.getInt(2)), rs.getString(3), rs.getInt(4), 
                        rs.getDouble(5), rs.getDouble(6));
            }
            
            ppst.close();
            conn.close();
            
            
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
          return null;
    }
    
    public List<PecaUsada> buscarPecaPorOrdemDeServico(int id_os){
        conn = util.conexao();
        String db = "select * from pecas_usadas where id_os = ?;";
         List<PecaUsada> pecasDaLista = new ArrayList<>();
         
          try {
            ppst = conn.prepareStatement(db);
            ppst.setInt(1, id_os);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                PecaUsada pecasUsadas = new PecaUsada(rs.getInt(1), osRepository.buscarOsPorId(rs.getInt(2)), rs.getString(3), rs.getInt(4),
                        rs.getDouble(5), rs.getDouble(6));
                pecasDaLista.add(pecasUsadas);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(PecaUsadaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pecasDaLista;
    }
    
    
    
}
