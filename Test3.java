//Create a class Student with a public variable name.
// In the main method, create an object of Student and print the name.*/
package Assignment1;

class Student1 {
    public String name;
}

public class Test3 {
    public static void main(String[] args) {
        // create object
        Student1 s1 = new Student1();

        // assign value
        s1.name = "Abhishek";

        System.out.println("Student Name: " + s1.name);
    }
}

