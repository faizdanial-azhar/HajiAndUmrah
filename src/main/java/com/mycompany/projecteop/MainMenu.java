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
public class MainMenu {

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("Hi, Welcome Home!");
        System.out.println("1.Create New Booking.\n2.Delete Booking. \n3.Your Booking Details.\n4.Print Your Booking.\n5.Log Out");
        System.out.println("-----------------------------");
        System.out.print("Choose option: ");
        int choice = input.nextInt();
        System.out.println("-----------------------------");
        if (choice == 1) {
            UserBooking.SelectPackage();
        } else if (choice == 2) {
            DeleteBooking.handleDeleteBooking();
        } else if (choice == 3) {
            BookingLists.BookingLists();
        } else if (choice == 4) {
            UserBooking.PrintBookings();
            
        } else if (choice == 5) {
            Account.AccountSignIn();
        }
    }
}
