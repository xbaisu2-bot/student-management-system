import java.sql.*;

public class ConnectionTest {
    public static void main(String[] args) {
        System.out.println("开始测试 DatabaseConnection 类...");

        // 测试单例模式
        System.out.println("1. 测试单例模式获取实例：");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println("   实例1和实例2是否为同一对象：" + (db1 == db2));

        // 测试获取数据库连接
        System.out.println("\n2. 测试获取数据库连接：");
        Connection connection = db1.getConnection();
        System.out.println("   连接是否成功建立：" + (connection != null));

        // 测试再次获取连接（应该返回同一个连接）
        System.out.println("\n3. 测试再次获取连接：");
        Connection connection2 = db1.getConnection();
        System.out.println("   两次获取的连接是否为同一对象：" + (connection == connection2));

        // 测试关闭数据库连接
        System.out.println("\n4. 测试关闭数据库连接：");
        db1.closeConnection();

        // 测试关闭后重新获取连接（应该创建新连接）
        System.out.println("\n5. 测试关闭后重新获取连接：");
        Connection connection3 = db1.getConnection();
        System.out.println("   重新获取的连接是否成功：" + (connection3 != null));
        System.out.println("   新连接与原连接是否为同一对象：" + (connection == connection3));

        // 最后关闭连接
        db1.closeConnection();

        System.out.println("\nDatabaseConnection 类测试完成！");

    }
}
