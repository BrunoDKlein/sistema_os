package repository;

// * @author Victor

import entity.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import resources.UtilDb;

public class PagamentoRepository {

    PagamentoRepository pagamentoRepository = new PagamentoRepository();

    private final UtilDb util = new UtilDb();
    Connection conn;
    PreparedStatement ppst;

    public Pagamento salvarPagamento(Pagamento pagamento) {
        conn = util.conexao();
        String sql = "INSERT INTO pagamento("
                + "id,"
                + "id_os,"
                + "data_pagamento,"
                + "valor,"
                + "metodo) "
                + "VALUES(?,?,?,?,?)";

        try {

            ppst = conn.prepareStatement(sql);
            ppst.setInt(1, pagamento.getId());
            ppst.setInt(2, pagamento.getOs());
            ppst.setString(3, pagamento.getData());
            ppst.setInt(4, pagamento.getValor());
            ppst.setString(5, pagamento.getMetodoPagamento());

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
