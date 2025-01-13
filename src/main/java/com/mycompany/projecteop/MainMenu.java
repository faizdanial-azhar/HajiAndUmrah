/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;

import java.util.InputMismatchException;
import java.util.Scanner;


// AMMAR FAIZ
public class MainMenu {

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        //user main menu that allow user create,delete,print their bookings

        System.out.println("--------------------------------------");
        System.out.println("Hi, Welcome Home!");
        System.out.println("1. Create New Booking.");
        System.out.println("2. Delete Booking.");
        System.out.println("3. Your Booking Details.");
        System.out.println("4. Print Your Booking.");
        System.out.println("5. Log Out");

        do {
            try {
                System.out.println("--------------------------------------");
                System.out.print("Choose option: ");
                choice = input.nextInt();
                System.out.println("--------------------------------------");

                if (choice < 1 || choice > 5) {
                    System.out.println("*** Invalid Choice. Please enter a number between 1 and 5. ***");
                }
            } catch (InputMismatchException e) {
                System.out.println("*** Invalid Input! Please enter a valid number. ***");
                input.nextLine();
            }
        } while (choice < 1 || choice > 5);

        // Handle valid choices
        switch (choice) {
            case 1 -> UserBooking.SelectPackage();
            case 2 -> DeleteBooking.handleDeleteBooking();
            case 3 -> BookingLists.HandleDisplayBookings();
            case 4 -> PrintBookings.PrintBookings();
            case 5 -> Account.AccountSignIn();
            default -> System.out.println("*** Unexpected error occurred. ***");
        }
    }
}
