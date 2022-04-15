import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserSqlDAoTest {
    public void create() throws SQLException {
        // Explicit dep injection
        Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
        UserSqlDAo users = new UserSqlDAo(conn);
        // ...
        //
    }
}