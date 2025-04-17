/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Cliente;
import entity.Tecnico;
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
public class TecnicoRepository {

    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;

    public Tecnico salvarTecnico(Tecnico tecnico) {
        conn = util.conexao();
        String sql = "INSERT INTO tecnicos ("
                + "nome, "
                + "telefone, "
                + "email) "
                + "VALUES(?,?,?)";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, tecnico.getNome());

            ppst.setString(2, tecnico.getTelefone());
            ppst.setString(3, tecnico.getEmail());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return tecnico;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Tecnico BuscarTecnicoPorID(int id) {
        conn = util.conexao();
        String sql = "SELECT * FROM tecnicos WHERE id = ?;";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, id);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                return new Tecnico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            ppst.close();
            conn.close();
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public List<Tecnico> buscarTecnicosPorNome(String nome) {
        System.out.println("repo");
        conn = util.conexao();
        String sql = "SELECT * FROM tecnicos WHERE nome like ?";

        List<Tecnico> listaDeTecnicos = new ArrayList<>();
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, nome + "%");
            ResultSet rs = ppst.executeQuery();

            while (rs.next()) {
                Tecnico tecnico = new Tecnico(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));

                listaDeTecnicos.add(tecnico);

            }

        } catch (SQLException ex) {
            Logger.getLogger(TecnicoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDeTecnicos;

    }

    public Tecnico editarTecnico(Tecnico tecnico) {
        conn = util.conexao();
        String sql = "update tecnicos set "
                + "nome = ?, "
                + "telefone = ?, "
                + "email=?, "
                + "where id = ?; ";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, tecnico.getNome());
            ppst.setString(2, tecnico.getTelefone());
            ppst.setString(3, tecnico.getEmail());
            ppst.setInt(4, tecnico.getId());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return tecnico;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;

        }
    }

}
