public class UserDao {
    private Connection conn;
    public UserDao(Connection conn) {
        // conn = MyConnection.getInstance();
        this.conn = conn;
    }
}
