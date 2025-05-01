package repository;

// * @author Victor
import entity.OrdemServico;
import entity.Pagamento;
import entity.PagamentoDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.UtilDb;

public class PagamentoRepository {
    
    SistemaOsRepository sistemaOs = new SistemaOsRepository();
    
    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;
    
    public Pagamento salvarPagamento(Pagamento pagamento) {
        conn = util.conexao();
        String sql = "INSERT INTO pagamentos("
                + "id_os, "
                + "data_pagamento, "
                + "valor, "
                + "metodo) "
                + "VALUES(?,?,?,?)";
        
        try {
            
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, pagamento.getOrdemServico().getId());
            ppst.setDate(2, Date.valueOf(pagamento.getData()));
            ppst.setDouble(3, pagamento.getValor());
            ppst.setString(4, pagamento.getMetodoPagamento());
            
            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return pagamento;
            
        } catch (SQLException ex) {
            
            System.out.println(ex);
            return null;
            
        }
    }
    
    public List<Pagamento> buscarPagamentos() {
        conn = util.conexao();
        String sql = "SELECT * FROM pagamentos";
        
        List<Pagamento> pagamentos = new ArrayList<>();
        
        try {
            ppst = conn.prepareStatement(sql);
            ResultSet rs = ppst.executeQuery();
            
            while (rs.next()) {
                pagamentos.add(new Pagamento(
                        rs.getInt(1),
                        sistemaOs.buscarOsPorId(rs.getInt(2)),
                        rs.getDate(3).toLocalDate(),
                        rs.getDouble(4),
                        rs.getString(5)));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return pagamentos;
    }
}
