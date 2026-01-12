import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        
        while (true) {
            printMenu();
            System.out.print("请输入您的选择：");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符
            
            switch (choice) {
                case 1:
                    addStudent(scanner, studentManager);
                    break;
                case 2:
                    getStudentById(scanner, studentManager);
                    break;
                case 3:
                    displayAllStudents(studentManager);
                    break;
                case 4:
                    calculateAverageScore(scanner, studentManager);
                    break;
                case 5:
                    studentManager.close();
                    System.out.println("感谢使用学生管理系统，再见！");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
            
            System.out.println();
        }
    }
    
    // 打印菜单
    private static void printMenu() {
        System.out.println("================================");
        System.out.println("        学生管理系统");
        System.out.println("================================");
        System.out.println("1. 添加学生信息");
        System.out.println("2. 根据ID查询学生信息");
        System.out.println("3. 显示所有学生信息");
        System.out.println("4. 计算学生各科目的平均分数");
        System.out.println("5. 退出系统");
        System.out.println("================================");
    }
    
    // 添加学生信息
    private static void addStudent(Scanner scanner, StudentManager studentManager) {
        System.out.println("添加学生信息");
        System.out.println("------------");
        
        Student student = new Student();
        
        System.out.print("请输入学生姓名：");
        String name = scanner.nextLine();
        student.setName(name);
        
        System.out.print("请输入学生性别：");
        String gender = scanner.nextLine();
        student.setGender(gender);
        
        System.out.print("请输入学生班级：");
        String className = scanner.nextLine();
        student.setClassName(className);
        
        System.out.print("请输入数学成绩：");
        double mathScore = scanner.nextDouble();
        student.setMathScore(mathScore);
        
        System.out.print("请输入Java成绩：");
        double javaScore = scanner.nextDouble();
        student.setJavaScore(javaScore);
        scanner.nextLine(); // 消耗换行符
        
        studentManager.addStudent(student);
    }
    
    // 根据ID查询学生信息
    private static void getStudentById(Scanner scanner, StudentManager studentManager) {
        System.out.println("根据ID查询学生信息");
        System.out.println("----------------");
        
        System.out.print("请输入学生ID：");
        int id = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        
        Student student = studentManager.getStudentById(id);
        if (student != null) {
            System.out.println("查询到的学生信息：");
            System.out.println(student);
        } else {
            System.out.println("未查询到ID为 " + id + " 的学生");
        }
    }
    
    // 显示所有学生信息
    private static void displayAllStudents(StudentManager studentManager) {
        System.out.println("所有学生信息");
        System.out.println("------------");
        
        List<Student> students = studentManager.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("暂无学生信息");
        } else {
            System.out.printf("%-5s %-15s %-10s %-15s %-10s %-10s\n", "ID", "姓名", "性别", "班级", "数学成绩", "Java成绩");
            System.out.println("------------------------------------------------------------");
            for (Student student : students) {
                System.out.printf("%-5d %-15s %-10s %-15s %-10.2f %-10.2f\n", 
                    student.getId(), student.getName(), student.getGender(), 
                    student.getClassName(), student.getMathScore(), student.getJavaScore());
            }
        }
    }
    
    // 计算学生各科目的平均分数
    private static void calculateAverageScore(Scanner scanner, StudentManager studentManager) {
        System.out.println("计算学生平均分数");
        System.out.println("--------------");
        
        System.out.print("请输入学生ID：");
        int id = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        
        double average = studentManager.calculateAverageScore(id);
        if (average > 0) {
            System.out.printf("ID为 %d 的学生平均分数为：%.2f\n", id, average);
        } else {
            System.out.println("未查询到ID为 " + id + " 的学生或计算失败");
        }
    }
}