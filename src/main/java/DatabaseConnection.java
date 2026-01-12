import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private final String databaseName="student_management";
    private final String host="localhost";
    private final String port="3307";
    private final String user="root";
    private final String password="";
    
    // 私有构造方法，防止外部实例化
    private DatabaseConnection() {}
    
    // 获取单例实例
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    // 建立数据库连接
    public Connection getConnection() {
        if (connection == null) {
            try {
                // 加载 MySQL 驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 构建连接 URL
                String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC", host, port, databaseName);
                // 建立连接
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("成功建立数据库连接。");
            } catch (ClassNotFoundException e) {
                System.err.println("未找到 MySQL 驱动: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("连接数据库失败: " + e.getMessage());
            }
        }
        return connection;
    }
    
    // 关闭数据库连接
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("成功关闭数据库连接。");
            } catch (SQLException e) {
                System.err.println("关闭数据库连接失败: " + e.getMessage());
            }
        }
    }
}
