import java.sql.Connection;

public class UserSqlDAo implements UserDAO {
    private Connection conn;

    public UserSqlDAo(Connection conn) {
        this.conn = conn;
    }

    @Override
    public User getUserById(int id) {
        // SELECT
        return null;
    }

    @Override
    public int create(User user) {
        return 0;
    }
}
