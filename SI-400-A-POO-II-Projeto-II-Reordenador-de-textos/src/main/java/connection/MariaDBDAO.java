package connection;

import reorderGUI.ConstantesGlobais;

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
    String usuario = "si400_2022";
    String senha = "si400_2022";
    private static Connection con = null;
    Integer groupId = 11;

    @Override
    public Connection getConnection(String usuario, String senha) {
        if (con == null && usuario.equals(this.usuario) && senha.equals(this.senha)) {
            try {
                con = DriverManager.getConnection(
                        "jdbc:mariadb://143.106.243.64:3306/SI400",
                        usuario, senha
                );
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MariaDBDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;
        }else{
        return null;
        }
    }

    @Override
    public List retrieve() {
        List<String> texto = new ArrayList();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Fragmentos WHERE groupId = " + groupId + "ORDER BY line");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                texto.add(rs.getString("text"));
                ConstantesGlobais.fileName = rs.getString("file");
            }
                    } catch (SQLException ex) {
            Logger.getLogger(MariaDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
    }
}
