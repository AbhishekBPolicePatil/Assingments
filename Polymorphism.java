package Assignment1;

class Shape {
    void draw() {
        System.out.println("Drawing a Shape");
    }
}

// Subclass 1
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Subclass 2
class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Square");
    }
}

public class Polymorphism {
    public static void main(String[] args) {

        Shape s1 = new Circle();
        s1.draw();

        Shape s2 = new Square();
        s2.draw();
    }
}
