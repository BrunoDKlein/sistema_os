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
        conn = util.conexao();
        String sql = "INSERT INTO aparelho("
                + "descricao, "
                + "marca, "
                + "modelo ) "
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
}
