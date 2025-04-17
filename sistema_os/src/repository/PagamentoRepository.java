package repository;

// * @author Victor
import entity.Pagamento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import resources.UtilDb;

public class PagamentoRepository {

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
}
