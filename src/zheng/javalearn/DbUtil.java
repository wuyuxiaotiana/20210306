package zheng.javalearn;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author Zheng
 */
public class DbUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try {
            Properties pro = new Properties();
            ClassLoader classLoader = DbUtil.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = null;
            if (res != null) {
                path = res.getPath();
            }
            if (path != null) {
                pro.load(new FileReader(path));
            }
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(PreparedStatement stmt, Connection conn) {
        close(null, stmt, conn);
    }

    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
