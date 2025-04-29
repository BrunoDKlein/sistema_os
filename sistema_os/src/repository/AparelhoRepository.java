package repository;

import entity.Aparelho;
import entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Debug.id;
import resources.UtilDb;

public class AparelhoRepository {

    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;

    public Aparelho salvarAparelho(Aparelho aparelho) {
        conn = util.conexao();
        String sql = "INSERT INTO aparelhos("
                + "descricao, "
                + "marca, "
                + "modelo) "
                + "VALUES(?,?,?)";

        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, aparelho.getDescricao());
            ppst.setString(2, aparelho.getMarca());
            ppst.setString(3, aparelho.getModelo());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return aparelho;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public Aparelho BuscarAparelhoPorID(int id) {
        conn = util.conexao();
        String sql = "SELECT * FROM aparelhos WHERE id = ?;";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, id);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                return new Aparelho(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            ppst.close();
            conn.close();
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public List<Aparelho> buscarAparelhosPorCliente(int id_Cliente) {
        conn = util.conexao();
        String sql = " select * from aparelhos where id_Clientes = ?";
        List<Aparelho> aparelhosDosClientes = new ArrayList<>();
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, id_Cliente);
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                Aparelho aparelho = new Aparelho(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );

                aparelhosDosClientes.add(aparelho);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AparelhoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aparelhosDosClientes;
    }

    public Aparelho editarAparelho(Aparelho aparelho) {
        conn = util.conexao();
        String sql = "update aparelhos set "
                + "modelo = ?, "
                + "descricao = ? "
                + "were id = ?;";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1, aparelho.getModelo());
            ppst.setString(2, aparelho.getDescricao());
            ppst.setInt(3, aparelho.getId());

            ppst.executeUpdate();
            ppst.close();
            conn.close();
            return aparelho;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
    }
    public Aparelho editarAparelhoPorId(int id_aparelho){
        conn = util.conexao();
        String sql = "SELECT * FROM aparelhos WHERE id = ?;";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, id_aparelho );
            ResultSet rs = ppst.executeQuery();
            while (rs.next()) {
                return new Aparelho(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            ppst.close();
            conn.close();
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }
    }

