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
import java.sql.ResultSet;
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
    PecaUsadaRepository pecaUsadaRepository = new PecaUsadaRepository();

    public boolean salvarOrdemServico(OrdemServico ordemServico) {
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
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, ordemServico.getCliente().getId());
//            ppst.setInt(2, ordemServico.getAparelho().getId());
            ppst.setInt(2, 1);
            ppst.setInt(3, ordemServico.getTecnico().getId());
            ppst.setDate(4, Date.valueOf(ordemServico.getData_abertura()));
            ppst.setString(5, ordemServico.getStatus());
            ppst.setString(6, ordemServico.getDescricao_problema());
            ppst.setString(7, ordemServico.getSolucao());
            ppst.setDouble(8, ordemServico.getCusto_total());
            ppst.executeUpdate();
            pecaUsadaRepository.salvarPecas(ordemServico.getPecasUsadas(), 1);

//            int rowsAffected = ppst.executeUpdate();
//            System.out.println(rowsAffected);
//            System.out.println("aaa" + ordemServico.getPecasUsadas().size());
//            if (ordemServico.getPecasUsadas() != null) {
//                int generatedId = -1;
//                if (rowsAffected > 0) {
//                    try (ResultSet rs = ppst.getGeneratedKeys()) {
//                            System.out.println("gntk" + ppst.getGeneratedKeys());
//
//                            generatedId = rs.getInt(1);
//                            pecaUsadaRepository.salvarPecas(ordemServico.getPecasUsadas(), 1);
//                        
//                    }
//                }
//            }
            ppst.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
