/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class UtilDb {

    private static final String url = "jdbc:postgresql://localhost:5432/os_tecnica";
    private static final String driver = "org.postgresql.Driver";
    private static final String usuario = "postgres";
    private static final String senha = "1234";
    Connection c;

    public Connection conexao() {
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não possivel "
                    + "estabelecer conexao com o banco");
        }
        return c;
    }

}
