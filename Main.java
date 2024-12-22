public class Main{
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.name = "john";
        student1.age=18;
        student1.grade="A";

        student2.name="john";
        student2.age=18;
        student2.grade="A";
        
        System.out.println("student name"+student1.name);
        System.out.println("age:"+student1.age);
        System.out.println("Grade:"+student1.grade);
        


    }
}