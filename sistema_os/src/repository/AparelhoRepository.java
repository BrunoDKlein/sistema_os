package repository;

import entity.Aparelho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
