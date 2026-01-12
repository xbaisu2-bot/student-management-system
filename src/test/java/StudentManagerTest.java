import java.util.List;

public class StudentManagerTest {
    public static void main(String[] args) {
        System.out.println("开始测试 StudentManager 类...");
        
        // 创建 StudentManager 实例
        StudentManager studentManager = new StudentManager();
        
        // 1. 测试添加学生信息
        System.out.println("\n1. 测试添加学生信息：");
        Student student1 = new Student();
        student1.setName("张三");
        student1.setGender("男");
        student1.setClassName("软件1班");
        student1.setMathScore(85.5);
        student1.setJavaScore(90.0);
        studentManager.addStudent(student1);
        
        Student student2 = new Student();
        student2.setName("李四");
        student2.setGender("女");
        student2.setClassName("软件2班");
        student2.setMathScore(88.0);
        student2.setJavaScore(92.5);
        studentManager.addStudent(student2);
        
        // 2. 测试根据ID查询学生信息
        System.out.println("\n2. 测试根据ID查询学生信息：");
        Student foundStudent = studentManager.getStudentById(1);
        if (foundStudent != null) {
            System.out.println("   查询到学生：" + foundStudent);
        } else {
            System.out.println("   未查询到ID为1的学生");
        }
        
        // 3. 测试显示所有学生信息
        System.out.println("\n3. 测试显示所有学生信息：");
        List<Student> allStudents = studentManager.getAllStudents();
        System.out.println("   共查询到 " + allStudents.size() + " 名学生：");
        for (Student student : allStudents) {
            System.out.println("   " + student);
        }
        
        // 4. 测试计算学生各科目的平均分数
        System.out.println("\n4. 测试计算学生各科目的平均分数：");
        double average1 = studentManager.calculateAverageScore(1);
        System.out.println("   ID为1的学生平均分数：" + average1);
        
        double average2 = studentManager.calculateAverageScore(2);
        System.out.println("   ID为2的学生平均分数：" + average2);
        
        // 关闭资源
        studentManager.close();
        
        System.out.println("\nStudentManager 类测试完成！");
    }
}