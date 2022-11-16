package connection;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author 
 */
public interface DAO {
    public Connection getConnection();
    public List<String> retrieve();
}
