/*Question 1)Write a Java program to create a class Student with data members name, rollNumber, and
marks.
Create objects of the class and display the details of two students.*/
package Assignment1;
class Student {

    String name;
    int rollNumber;
    double marks;

    // Constructor to initialize values
    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to display details
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("----------------------");
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Abhishek", 101, 87.5);
        Student s2 = new Student("Rohit", 102, 92.0);

        // Display details
        s1.display();
        s2.display();
    }
}

