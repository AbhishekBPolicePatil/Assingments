import java.util.ArrayList;
import java.util.LinkedList;

// 1. ArrayList of integers with exception handling
class Q1_ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            // Adding 10 numbers
            for (int i = 1; i <= 10; i++) {
                numbers.add(i * 10);
            }

            if (numbers.isEmpty()) {
                throw new Exception("ArrayList is empty, cannot print!");
            }

            System.out.println("Numbers in ArrayList:");
            for (int num : numbers) {
                System.out.println(num);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Q1 completed.\n");
        }
    }
}

// 2. LinkedList of strings, retrieve 3rd element with exception handling
class Q2_LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();

        try {
            names.add("Rahul");
            names.add("Sneha");
            names.add("Abhishek");
            names.add("Priya");
            names.add("Kiran");

            int index = 2; // 3rd element
            if (index >= names.size()) {
                throw new Exception("Index out of range!");
            }

            System.out.println("3rd name: " + names.get(index));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Q2 completed.\n");
        }
    }
}

// 3. Demonstrating size() vs isEmpty() with exception handling
class Q3_SizeVsIsEmpty {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        try {
            System.out.println("Initially:");
            System.out.println("Size = " + list.size());
            System.out.println("Is Empty? " + list.isEmpty());

            list.add("Java");
            list.add("Python");

            if (list.size() == 0) {
                throw new Exception("List is still empty!");
            }

            System.out.println("\nAfter adding elements:");
            System.out.println("Size = " + list.size());
            System.out.println("Is Empty? " + list.isEmpty());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Q3 completed.\n");
        }
    }
}

// 4. Check if element exists in ArrayList using contains() with exception handling
class Q4_ContainsExample {
    public static void main(String[] args) {
        ArrayList<String> languages = new ArrayList<>();

        try {
            languages.add("Java");
            languages.add("Python");
            languages.add("C++");
            languages.add("JavaScript");

            String check = "Python";

            if (languages.isEmpty()) {
                throw new Exception("ArrayList is empty, cannot check element!");
            }

            if (languages.contains(check)) {
                System.out.println(check + " exists in the list.");
            } else {
                throw new Exception(check + " does NOT exist in the list.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Q4 completed.\n");
        }
    }
}

// 5. LinkedList add/remove first & last with throws/throw/try-catch-finally
class Q5_LinkedListExceptionExample {

    // method with throws declaration
    public static void removeElements(LinkedList<String> list) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Cannot remove from an empty list!");
        }

        System.out.println("Removing first: " + list.removeFirst());
        System.out.println("Removing last: " + list.removeLast());
    }

    public static void main(String[] args) {
        LinkedList<String> items = new LinkedList<>();

        try {
            items.add("One");
            items.add("Two");
            items.add("Three");
            items.add("Four");

            System.out.println("Original List: " + items);

            removeElements(items); // method that throws Exception

            System.out.println("Updated List: " + items);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Q5 completed.\n");
        }
    }
}

