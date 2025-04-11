/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.OrdemServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.UtilDb;

/**
 *
 * @author admin
 */
public class SistemaOsRepository {

    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;
    ClienteRepository clienteRepository = new ClienteRepository();
    AparelhoRepository aparelhoRepository = new AparelhoRepository();
    TecnicoRepository tecnicoRepository = new TecnicoRepository();

    public List<OrdemServico> buscarTodasAsOs() {
        conn = util.conexao();
        String sql = "SELECT * FROM ordens_servico";
        try {
            ppst = conn.prepareStatement(sql);

            List<OrdemServico> listaDeOs = new ArrayList<>();
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                listaDeOs.add(
                        new OrdemServico(rs.getInt(1),
                                clienteRepository.BuscarClientePorID(rs.getInt(2)),
                                aparelhoRepository.BuscarAparelhoPorID(rs.getInt(3)),
                                tecnicoRepository.BuscarTecnicoPorID(rs.getInt(4)),
                                (rs.getDate(5) != null ? rs.getDate(5).toLocalDate() : null),
                                (rs.getDate(6) != null ? rs.getDate(6).toLocalDate() : null),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getString(9),
                                rs.getDouble(10))
                );
            }
            ppst.close();
            conn.close();
            return listaDeOs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public OrdemServico buscarOsPorId(int id_Os) {
        conn = util.conexao();
        String sql = "SELECT * FROM ordens_servico WHERE id = ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, id_Os);

            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                return new OrdemServico(rs.getInt(1),
                        clienteRepository.BuscarClientePorID(rs.getInt(2)),
                        aparelhoRepository.BuscarAparelhoPorID(rs.getInt(3)),
                        tecnicoRepository.BuscarTecnicoPorID(rs.getInt(4)),
                        (rs.getDate(5) != null ? rs.getDate(5).toLocalDate() : null),
                        (rs.getDate(6) != null ? rs.getDate(6).toLocalDate() : null),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getDouble(10));
            }
            ppst.close();
            conn.close();
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }

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
