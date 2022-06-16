package main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitListener implements ServletContextListener {
    private void createTables(Connection conn) throws SQLException {
        Statement stm = conn.createStatement();
        stm.execute("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(20), last_name VARCHAR(30), admission_year INTEGER);");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing context");
        try {
            Class.forName("com.mysql.cj.jdbc.MysqlDataSource");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/free_uni", "root", "rootroot");
            createTables(conn);
            StudentDao dao = new StudentSqlDao(conn);
            sce.getServletContext().setAttribute("student_dao", dao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
