package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class Remota implements ConexaoDAO {

    @Override
    public DAO novaConexao() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/SI400",
                    "si400_2022", "si400_2022"
            );
        } catch (SQLException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ConexaoLocal();
    }
}
