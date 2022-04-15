import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = null; // ....
        new UserSqlDAo(conn);

    }
}
