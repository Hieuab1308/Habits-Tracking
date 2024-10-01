
package manageSQL;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectDB {

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/yourdatabase";

        String user = "yourusername";

        String password = "yourpassword";

        return DriverManager.getConnection(url, user, password);

    }

}
