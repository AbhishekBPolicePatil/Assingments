/*Enter cost of 3 items from the user(using float datatype) -a pencil,a pen and an eraser.
You have to output the total cost of the items back to the user as their bill.
        (Add on : You can also try adding 18% gst tax to the items in the bill as an advanced
problem)*/
package Assignment1;

import java.util.Scanner;

public class TotalCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cost of pencil: ");
        float pencil = sc.nextFloat();

        System.out.print("Enter cost of pen: ");
        float pen = sc.nextFloat();

        System.out.print("Enter cost of eraser: ");
        float eraser = sc.nextFloat();

        // Total without tax
        float total = pencil + pen + eraser;
        System.out.println("Total cost (without GST): " + total);

        // Adding GST (18%)
        float gst = total * 0.18f;        // 18% of total
        float totalWithGst = total + gst; // Total after tax
        System.out.println("Total cost (with 18% GST): " + totalWithGst);

        sc.close();
    }

}
