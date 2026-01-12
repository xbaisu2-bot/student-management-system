import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private DatabaseConnection dbConnection;
    private Connection connection;
    
    // 构造方法，初始化数据库连接
    public StudentManager() {
        dbConnection = DatabaseConnection.getInstance();
        connection = dbConnection.getConnection();
    }
    
    // 添加学生信息到数据库
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, gender, class_name, math_score, java_score) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getGender());
            pstmt.setString(3, student.getClassName());
            pstmt.setDouble(4, student.getMathScore());
            pstmt.setDouble(5, student.getJavaScore());
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("成功添加 " + rowsAffected + " 名学生");
        } catch (SQLException e) {
            System.err.println("添加学生失败: " + e.getMessage());
        }
    }
    
    // 根据ID查询学生信息
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        Student student = null;
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setClassName(rs.getString("class_name"));
                student.setMathScore(rs.getDouble("math_score"));
                student.setJavaScore(rs.getDouble("java_score"));
            }
        } catch (SQLException e) {
            System.err.println("查询学生失败: " + e.getMessage());
        }
        
        return student;
    }
    
    // 显示所有学生信息
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setClassName(rs.getString("class_name"));
                student.setMathScore(rs.getDouble("math_score"));
                student.setJavaScore(rs.getDouble("java_score"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println("查询所有学生失败: " + e.getMessage());
        }
        
        return students;
    }
    
    // 计算学生各科目的平均分数
    public double calculateAverageScore(int studentId) {
        String sql = "SELECT (math_score + java_score) / 2 AS average FROM students WHERE id = ?";
        double average = 0.0;
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                average = rs.getDouble("average");
            }
        } catch (SQLException e) {
            System.err.println("计算平均分数失败: " + e.getMessage());
        }
        
        return average;
    }
    
    // 关闭数据库连接
    public void close() {
        dbConnection.closeConnection();
    }
}