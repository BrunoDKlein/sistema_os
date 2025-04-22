/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.OrdemServico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import resources.UtilDb;

/**
 *
 * @author admin
 */
public class OrdemServicoRepository {
    
    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;
    
    public OrdemServico salvarOrdemServico(OrdemServico ordemServico) {
        conn = util.conexao();
        String sql = "INSERT INTO ordens_servico("
                + "id_cliente,"
                + "id_aparelho,"
                + "id_tecnico,"
                + "data_abertura,"
                + "status,"
                + "descricao_problema,"
                + "solucao,"
                + "custo_total)"
                + "VALUES(?,?,?,?,'Aberta',?,?,?)";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, ordemServico.getCliente().getId());
            ppst.setInt(2, ordemServico.getAparelho().getId());
            ppst.setInt(3, ordemServico.getTecnico().getId());
            ppst.setDate(4, Date.valueOf(ordemServico.getData_abertura()));
            ppst.setString(5, ordemServico.getDescricao_problema());
            ppst.setString(6, ordemServico.getSolucao());
            ppst.setDouble(7, ordemServico.getCusto_total());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return ordemServico;
        } catch (SQLException ex) {
            return null;
        }
    }
}
