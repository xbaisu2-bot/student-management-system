public class Student {
    private int id;
    private String name;
    private String gender;
    private String className;
    private double mathScore;
    private double javaScore;
    
    // 无参构造方法
    public Student() {
    }
    
    // Getter and Setter for id
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    // Getter and Setter for name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter and Setter for gender
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    // Getter and Setter for className
    public String getClassName() {
        return className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    
    // Getter and Setter for mathScore
    public double getMathScore() {
        return mathScore;
    }
    
    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }
    
    // Getter and Setter for javaScore
    public double getJavaScore() {
        return javaScore;
    }
    
    public void setJavaScore(double javaScore) {
        this.javaScore = javaScore;
    }
    
    // toString method for easy printing
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", className='" + className + '\'' +
                ", mathScore=" + mathScore +
                ", javaScore=" + javaScore +
                '}';
    }
}