/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.OrdemServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import resources.UtilDb;

/**
 *
 * @author admin
 */
public class OrdemServicoRepository {
    
    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;
    
    public OrdemServico salvarContato(OrdemServico ordemServico) {
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
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, ordemServico.getCliente().getId());
            ppst.setInt(2, ordemServico.getAparelho().getId());
            ppst.setInt(3, ordemServico.getTecnico().getId());
//            ppst.set(2, contato.getEndereco());
//            ppst.setString(3, contato.getTelefone());
//            ppst.setString(4, contato.getEmail());
//            ppst.setString(5, contato.getLinkedim());
//            ppst.setInt(6, contato.getAgenda().getId());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return ordemServico;
        } catch (SQLException ex) {
            return null;
        }
    }
}
