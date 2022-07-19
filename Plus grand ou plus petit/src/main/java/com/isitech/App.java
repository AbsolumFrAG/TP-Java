package com.isitech;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int randomNumber = (int)(Math.random() * 100);
        int number = 0;

        do {
            System.out.println("Deviner le nombre entre (1 et 100)");
            number = sc.nextInt();

            if (number == randomNumber) {
                System.out.println("Bravo !");
                break;
            } else if (number > randomNumber) {
                System.out.println("Plus petit");
            }
            else {
                System.out.println("Plus grand");
            }
        } while (number >= 0);

        System.out.println("Le nombre était : ");
        System.out.println(randomNumber);
        sc.close();
    }
}
