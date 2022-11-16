package connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class Local implements ConexaoDAO {

    public static final String DBURL = "jdbc:sqlite:ProjReord";
    private static Connection con;
    
    @Override
    public DAO novaConexao() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(DBURL);
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return new ConexaoLocal();
    }
}
