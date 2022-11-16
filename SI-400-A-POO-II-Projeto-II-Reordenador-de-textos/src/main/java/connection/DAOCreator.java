package connection;

/**
 *
 * @author saina
 */
public class DAOCreator {
    public static DAO factoryDAO(String database){
        if(database.equals("LocalDAO")){
            return new LocalDAO();
        }else if(database.equals("MariaDBDAO")){
            return new MariaDBDAO();
        }
        throw new IllegalArgumentException("Banco não cadastrado");
    }
}
