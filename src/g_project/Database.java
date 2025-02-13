package g_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Database {

    public Connection con;
    public ResultSet resultSet;
    public PreparedStatement pre;

    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/g_db" + "?useUnicode=yes&characterEncoding=UTF-8";

    public static Connection getConnection() {

        try {

            Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            System.out.println("connected to the database.................");
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
