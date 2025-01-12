/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author adamnaeman
 */
public class AdminManagement {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    public static final int[] packageBookingCounts = new int[6]; // Track bookings for each package

    public static void adminLogin() {
        Scanner input = new Scanner(System.in);

        System.out.println("ADMIN LOGIN");
        System.out.println("--------------------------------------");
        System.out.print("Username: ");
        String username = input.next();
        System.out.print("Password: ");
        String password = input.next();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            adminMenu();
        } else {
            System.out.println("*** Invalid credentials ***");
            System.out.println("Redirecting to Login Page...");
                            System.out.println("--------------------------------------");
            Account.AccountSignIn();
        }
    }

    public static void adminMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("ADMIN MENU");
        System.out.println("1. View Booking Statistics");
        System.out.println("2. View All Package Details");
        System.out.println("3. Print Statistics");
        System.out.println("4. Log Out");
        System.out.println("-----------------------------");
        System.out.print("Choose option: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                displayBookingStatistics();
                break;
            case 2:
                displayAllPackages();
                break;
            case 4:
                Account.AccountSignIn();
                break;
            case 3:
                printStatistics();
                break;
            default:
                System.out.println("Invalid option!");
                adminMenu();
        }
    }

    public static void printStatistics() {
        try (FileWriter printStatistics = new FileWriter("printStatistics.txt"); PrintWriter writer = new PrintWriter(printStatistics)) {

            writer.println("-----------------------------");
            writer.println("BOOKING STATISTICS");
            writer.println("-----------------------------");
            writer.println("HAJI PACKAGES:");
            writer.println("Package 1: " + packageBookingCounts[0] + " bookings");
            writer.println("Package 2: " + packageBookingCounts[1] + " bookings");
            writer.println("Package 3: " + packageBookingCounts[2] + " bookings");

            writer.println("\nUMRAH PACKAGES:");
            writer.println("Package 1: " + packageBookingCounts[3] + " bookings");
            writer.println("Package 2: " + packageBookingCounts[4] + " bookings");
            writer.println("Package 3: " + packageBookingCounts[5] + " bookings");

            int totalBookings = 0;
            for (int count : packageBookingCounts) {
                totalBookings += count;
            }

            writer.println("\nTotal Bookings: " + totalBookings);
             System.out.println("--------------------------------------");
            System.out.println("Your booking have been printed.");
             System.out.println("--------------------------------------");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            adminMenu();
        }
    }

    public static void updateBookingStatistics(int packageId) {
        // Convert package ID to array index
        int index;
        if (packageId >= 1001 && packageId <= 1003) {
            index = packageId - 1001; // Haji packages
        } else if (packageId >= 2001 && packageId <= 2003) {
            index = packageId - 1998; // Umrah packages (2001 -> index 3)
        } else {
            return;
        }

        packageBookingCounts[index]++;
    }

    public static void displayBookingStatistics() {
        System.out.println("-----------------------------");
        System.out.println("BOOKING STATISTICS");
        System.out.println("-----------------------------");
        System.out.println("HAJI PACKAGES:");
        System.out.println("Package 1: " + packageBookingCounts[0] + " bookings");
        System.out.println("Package 2: " + packageBookingCounts[1] + " bookings");
        System.out.println("Package 3: " + packageBookingCounts[2] + " bookings");

        System.out.println("\nUMRAH PACKAGES:");
        System.out.println("Package 1: " + packageBookingCounts[3] + " bookings");
        System.out.println("Package 2: " + packageBookingCounts[4] + " bookings");
        System.out.println("Package 3: " + packageBookingCounts[5] + " bookings");

        int totalBookings = 0;
        for (int count : packageBookingCounts) {
            totalBookings += count;
        }

        System.out.println("\nTotal Bookings: " + totalBookings);
        System.out.println("-----------------------------");

        adminMenu();
    }

    public static void displayAllPackages() {
        System.out.println("-----------------------------");
        System.out.println("ALL PACKAGE DETAILS");
        System.out.println("-----------------------------");
        System.out.println("\nHAJI PACKAGES:");
        DatabasePackage.getHajiPackage1().displayPackage();
        System.out.println();
        DatabasePackage.getHajiPackage2().displayPackage();
        System.out.println();
        DatabasePackage.getHajiPackage3().displayPackage();

        System.out.println("\nUMRAH PACKAGES:");
        DatabasePackage.getUmrahPackage1().displayPackage();
        System.out.println();
        DatabasePackage.getUmrahPackage2().displayPackage();
        System.out.println();
        DatabasePackage.getUmrahPackage3().displayPackage();

        adminMenu();
    }
}
