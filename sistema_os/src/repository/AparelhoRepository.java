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
import resources.UtilDb;

public class AparelhoRepository {

    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;

    public Aparelho salvarAparelho(Aparelho aparelho) {
        System.out.println(aparelho.getCliente().getId());
        conn = util.conexao();
        String sql = "INSERT INTO aparelhos("
                + "id_cliente, "
                + "descricao, "
                + "marca, "
                + "modelo) "
                + "VALUES(?,?,?,?)";

        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(2, aparelho.getDescricao());
            ppst.setString(3, aparelho.getMarca());
            ppst.setString(4, aparelho.getModelo());
            ppst.setInt(1, 1);

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
                return new Aparelho(rs.getInt(1), null, rs.getString(3), rs.getString(4), rs.getString(5));
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
                        //TODO
                       //Ajustar quando chegar a alteração do cliente
                        null, 
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );

                aparelhosDosClientes.add(aparelho);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AparelhoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aparelhosDosClientes;
    }
}
