package conectabd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private static Connection connection = null;

    public Conexao() {
    }

    public static Connection getConnection() throws Exception {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/viajava", "root", "");
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new Exception("Driver do MySQL não encontrado.");
            }
        }
        return connection;
    }

    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

    public static void closeConnection(Connection conn, Statement stmt) throws Exception {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
}
