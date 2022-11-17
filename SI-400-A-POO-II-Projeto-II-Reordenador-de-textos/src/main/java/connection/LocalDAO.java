package connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reorderGUI.ConstantesGlobais;

/**
 *
 * @author
 */
public class LocalDAO implements DAO {

    public static final String DBURL = "jdbc:sqlite:SI400A.db";
    private static Connection con = null;
    Integer groupId = 11;

    @Override

    public Connection getConnection(String usuario, String senha) {
        if (con == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(DBURL);

                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    @Override
    public List retrieve() {
        List<String> texto = new ArrayList();
        try {
            Statement s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Fragmentos WHERE groupId = " + groupId + " ORDER BY line");
            while (rs.next()) {
                texto.add(rs.getString("text"));
                ConstantesGlobais.fileName = rs.getString("file");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return texto;
    }
}
