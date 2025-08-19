//Create a class Animal with a method sound(). Create a subclass Dog that inherits from
//Animal and prints "Dog barks"
//[Using Inheritance]
package Assignment1;

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Inheritance {
    public static void main(String[] args) {

        Dog d = new Dog();
        d.sound();  // Calls overridden method
    }
}
