
package manageSQL;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectDB {

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/thoiquen";

        String user = "root";

        String password = "12345678";

        return DriverManager.getConnection(url, user, password);

    }

}
