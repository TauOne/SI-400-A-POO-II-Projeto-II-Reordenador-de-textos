package connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class MariaDBDAO implements DAO {

    private static Connection con = null;
    Integer groupId = 11;

    @Override
    public Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/SI400",
                        "si400_2022", "si400_2022"
                );
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MariaDBDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }

    @Override
    public List retrieve() {
        List<String> texto = new ArrayList();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Fragmentos WHERE groupId = " + groupId + "ORDER BY line");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                texto.add(rs.getString("text"));
            }
                    } catch (SQLException ex) {
            Logger.getLogger(MariaDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
    }
}
