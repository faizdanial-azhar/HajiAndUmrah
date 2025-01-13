/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;

import java.util.Scanner;

/**
 *
 * @author faizd
 */
//AMMAR FAIZ 
public class MainMenu {

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
         System.out.println("--------------------------------------");
        System.out.println("Hi, Welcome Home!");
        System.out.println("1.Create New Booking.\n2.Delete Booking. \n3.Your Booking Details.\n4.Print Your Booking.\n5.Log Out");
        while (true) {
           System.out.println("--------------------------------------");

                System.out.print("Choose option: ");
            int choice = input.nextInt();
            System.out.println("--------------------------------------");
            if (choice == 1) {
                UserBooking.SelectPackage();
                break;
            } else if (choice == 2) {
                DeleteBooking.handleDeleteBooking();
                break;
            } else if (choice == 3) {
                BookingLists.HandleDisplayBookings();
                break;
            } else if (choice == 4) {
                PrintBookings.PrintBookings();
                break;
            } else if (choice == 5) {
                Account.AccountSignIn();
                break;
            } else {
                System.out.println("*** Invalid Choice. Please enter valid one. ***");
            }
        }
    }
}
