/*Question1 :In a program,input 3 numbers:A,B and C.You have to output the average of
these 3 numbers.
(Hint : Average of N numbers is sum of those numbers divided by N)*/
package Assignment1;

import java.util.Scanner;

public class Average {

    public static void main(String[] args) {
        System.out.print("Please enter the first number A: ");

        Scanner sc = new Scanner(System.in);
        double A = sc.nextInt();
        System.out.print("Please enter the second number B: ");
        double B = sc.nextInt();
        System.out.print("Please enter the third number C: ");
        double C = sc.nextInt();

        double Sum=A+B+C;
        double average=Sum/3 ;

       System.out.println(average);

       sc.close();
    }
}
