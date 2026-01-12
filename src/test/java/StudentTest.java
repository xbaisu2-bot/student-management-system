public class StudentTest {
    public static void main(String[] args) {
        System.out.println("开始测试 Student 类...");
        
        // 创建 Student 对象
        Student student = new Student();
        System.out.println("\n1. 创建 Student 对象：");
        System.out.println("   初始对象：" + student);
        
        // 测试 setter 方法
        System.out.println("\n2. 测试 setter 方法：");
        student.setId(1);
        student.setName("张三");
        student.setGender("男");
        student.setClassName("软件1班");
        student.setMathScore(85.5);
        student.setJavaScore(90.0);
        System.out.println("   设置属性后：" + student);
        
        // 测试 getter 方法
        System.out.println("\n3. 测试 getter 方法：");
        System.out.println("   ID: " + student.getId());
        System.out.println("   姓名: " + student.getName());
        System.out.println("   性别: " + student.getGender());
        System.out.println("   班级: " + student.getClassName());
        System.out.println("   数学成绩: " + student.getMathScore());
        System.out.println("   Java成绩: " + student.getJavaScore());
        
        // 测试修改属性
        System.out.println("\n4. 测试修改属性：");
        student.setName("李四");
        student.setClassName("软件2班");
        student.setMathScore(88.0);
        student.setJavaScore(92.5);
        System.out.println("   修改后：" + student);
        
        // 测试空值情况
        System.out.println("\n5. 测试空值情况：");
        Student student2 = new Student();
        System.out.println("   未设置属性的对象：" + student2);
        System.out.println("   未设置姓名时 getName(): " + student2.getName());
        
        System.out.println("\nStudent 类测试完成！");
    }
}