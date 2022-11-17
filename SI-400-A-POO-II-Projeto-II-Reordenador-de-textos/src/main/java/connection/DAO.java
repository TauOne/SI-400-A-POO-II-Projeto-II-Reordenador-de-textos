package connection;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author 
 */
public interface DAO {
    public Connection getConnection(String usuario, String senha);
    public List<String> retrieve();
}
