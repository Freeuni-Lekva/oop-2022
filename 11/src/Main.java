import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.plaf.nimbus.State;
import java.sql.*;


public class Main {
    private static String CREATE_DB = "CREATE DATABASE free_uni;";
    private static String CREATE_USERS = "CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(20), last_name VARCHAR(30));";
    private static String QUERY_USERS = "SELECT id, first_name, last_name FROM users";
    private static String DELETE_USERS = "DELETE FROM users WHERE first_name = 'Foo'";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.MysqlDataSource");
        // new MysqlDataSource();
        // Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test_db?user=root&password=rootroot");
        // Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "rootroot");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/free_uni", "root", "rootroot");
        System.out.println("Connected");
        // createDb(conn);
        // createTable(conn);
        // queryUsers(conn);
        // insertUsers(conn);
        // deleteUsers(conn);
        User user = new User("Foo", "'); DELETE users; SELECT ('*");
        insertUser(conn, user);
        queryUsers(conn);
        System.out.println(user.getId());
        conn.close();
    }

    private static void deleteUsers(Connection conn) throws SQLException {
        Statement stm = conn.createStatement();
        int count = stm.executeUpdate(DELETE_USERS);
        stm.close();
        System.out.printf("Deleted %d users\n", count);
    }

    private static void insertUser(Connection conn, User user) throws SQLException {
        String query = "INSERT INTO users (first_name, last_name) VALUES ('" +
                user.getFirstName() + "', '" +
                user.getLastName() + "');";
        System.out.println(query);
        Statement stm = conn.createStatement();
        int count = stm.executeUpdate(query);
//        // count += stm.executeUpdate("INSERT INTO users (first_name, last_name) VALUES ('Foo', 'Bar')");
        stm.close();
        System.out.printf("Inserted %d users\n", count);
    }

    private static void queryUsers(Connection conn) throws SQLException {
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(QUERY_USERS);
        int count = 0;
        while (rs.next()) {
            System.out.printf("user: %d %s %s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            count++;
        }
        stm.close();
        System.out.printf("Num users: %d\n", count);
    }

    private static void createTable(Connection conn) throws SQLException {
        Statement stm = conn.createStatement();
        stm.execute(CREATE_USERS);
        stm.close();
        System.out.println("Created users table");
    }

    private static void createDb(Connection conn) throws SQLException {
        Statement stm = conn.createStatement();
        stm.execute(CREATE_DB);
        System.out.println("Created DB");
        stm.close();
    }
}
