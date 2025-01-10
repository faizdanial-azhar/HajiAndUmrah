/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author faizd
 */
public class UserBooking {

    public static final String[] bookings = new String[100];
    public static final int[] bookingPackageId = new int[100];
    public static int bookingCount = 0;

    public static void HandlePayments(int packageId, int adultPrice, int childrenPrice) {

        Confirmation();
        int numberOfAdult = NumberOfAdult();
        int numberOfChildren = NumberOfChildren();
        int totalAmount = CalculateTotalAmount(adultPrice, numberOfAdult, childrenPrice, numberOfChildren);
        boolean paymentSuccessfull = PaymentMethod(totalAmount, adultPrice, childrenPrice, numberOfAdult, numberOfChildren);
        if (paymentSuccessfull){
        PrintReceipt(packageId, totalAmount, numberOfAdult, numberOfChildren);
        if (bookingCount < bookings.length) {

            String bookingDetails = "\nAdults: " + numberOfAdult + "\nChildren: " + numberOfChildren + "\nTotal: RM " + totalAmount;
            bookingPackageId[bookingCount] = packageId;
            bookings[bookingCount] = bookingDetails;
            bookingCount++;
            
            AdminManagement.updateBookingStatistics(packageId); 
            MainMenu.mainMenu();
        } else {
            System.out.println("Booking list is full! Unable to add more bookings.");
        }}
       
    }

    public static void SelectPackage() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("1-- Haji Package\n2-- Umrah Package");
        System.out.println("-----------------------------");
        System.out.print("(Haji / Umrah):");
        int choice = input.nextInt();
        if (choice == 1) {
            PackageHaji();
        } else if (choice == 2) {
            PackageUmrah();
        }

    }

    public static void PackageHaji() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int adultPrice;
        int childrenPrice;
        System.out.println("---------------------------------------------------------------");
        System.out.println("1.Haji 1st Package   2.Haji 2nd Package   3.Haji 3rd Package");
        System.out.println("---------------------------------------------------------------");
        do {
            System.out.print("Your Package Number: ");
            choice = input.nextInt();

            if (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Invalid package pls enter valid package!");
            }

        } while (choice != 1 && choice != 2 && choice != 3);

        switch (choice) {
            case 1 -> {
                DatabasePackage.getHajiPackage1().displayPackage();
                adultPrice = DatabasePackage.getHajiPackage1().getAdultPrice();
                childrenPrice = DatabasePackage.getHajiPackage1().getAdultPrice();
                HandlePayments(1001, adultPrice, childrenPrice);
            }

            case 2 -> {
                DatabasePackage.getHajiPackage2().displayPackage();
                adultPrice = DatabasePackage.getHajiPackage2().getAdultPrice();
                childrenPrice = DatabasePackage.getHajiPackage2().getAdultPrice();
                HandlePayments(1002, adultPrice, childrenPrice);
            }
            case 3 -> {
                DatabasePackage.getHajiPackage3().displayPackage();
                adultPrice = DatabasePackage.getHajiPackage3().getAdultPrice();
                childrenPrice = DatabasePackage.getHajiPackage3().getAdultPrice();
                HandlePayments(1003, adultPrice, childrenPrice);
            }

            default ->
                System.out.println("Not A valid Package");

        }
        System.out.println("-----------------------------------");
    }

    public static void PackageUmrah() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int adultPrice;
        int childrenPrice;
        System.out.println("---------------------------------------------------------------");
        System.out.println("1.Umrah 1st Package   2.Umrah 2nd Package   3.Umrah 3rd Package");
        System.out.println("---------------------------------------------------------------");
        do {
            System.out.print("Your Package Number: ");
            choice = input.nextInt();

            if (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Invalid package pls enter valid package!");
            }

        } while (choice != 1 && choice != 2 && choice != 3);
        System.out.println("-----------------------------");
        switch (choice) {
            case 1 -> {
                DatabasePackage.getUmrahPackage1().displayPackage();
                adultPrice = DatabasePackage.getUmrahPackage1().getAdultPrice();
                childrenPrice = DatabasePackage.getUmrahPackage1().getAdultPrice();
                HandlePayments(2001, adultPrice, childrenPrice);
            }
            case 2 -> {
                DatabasePackage.getUmrahPackage2().displayPackage();
                adultPrice = DatabasePackage.getUmrahPackage2().getAdultPrice();
                childrenPrice = DatabasePackage.getUmrahPackage2().getAdultPrice();
                HandlePayments(2002, adultPrice, childrenPrice);
            }
            case 3 -> {
                DatabasePackage.getUmrahPackage3().displayPackage();
                adultPrice = DatabasePackage.getUmrahPackage3().getAdultPrice();
                childrenPrice = DatabasePackage.getUmrahPackage3().getAdultPrice();
                HandlePayments(2003, adultPrice, childrenPrice);
            }

            default ->
                System.out.println("Not A valid Package");

        }
        System.out.println("-----------------------------------");
    }

    public static void Confirmation() {
        Scanner input = new Scanner(System.in);
        String choice;
        do {
            System.out.print("Continue to Payment Gateway (Y for yes / N for no): ");
            choice = input.next();

            if (choice.equalsIgnoreCase("y")) {
                break;
            } else if (choice.equalsIgnoreCase("n")) {

                UserBooking.SelectPackage();

            } else {
                System.out.println("Invalid option, Please enter valid option)");
            }

        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));

    }

    public static int NumberOfAdult() {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of Adults: ");
        int numberOfAdults = input.nextInt();
        return numberOfAdults;
    }

    public static int NumberOfChildren() {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of Children:");

        int numberOfChildren = input.nextInt();
        return numberOfChildren;

    }

    public static int CalculateTotalAmount(int adultPrice, int numberOfAdults, int childrenPrice, int numberOfChildren) {
        System.out.println("-------------------");
        int totalAmount = (numberOfAdults * adultPrice) + (numberOfChildren * childrenPrice);
        return totalAmount;
    }

    public static boolean PaymentMethod(int totalAmount, int adultPrice, int childrenPrice, int numberOfAdult, int numberOfChildren) {

        Scanner input = new Scanner(System.in);

        System.out.println("PAYMENT METHODS :");
        System.out.println("Total Payments for (" + numberOfAdult + " Adults + " + numberOfChildren + " Children): RM " + totalAmount);

        System.out.println("1 = Online Banking\n2 = Debit Card(Visa/Mastercard)\n3 = E-wallet ");
        System.out.print("Please choose your payment methods:");
        int paymentMethod = input.nextInt();

        if (paymentMethod == 1 || paymentMethod == 2 || paymentMethod == 3) {
            System.out.println("Amount To Pay: " + totalAmount);
            System.out.print("Y to Pay / N to Cancel : ");

            String choice = input.next();
            if (choice.equalsIgnoreCase("n")) {
                System.out.println("1. Change Payment Method\n2. Change Package\n3. Main Menu");
                int innerChoice = input.nextInt();

                switch (innerChoice) {
                    case 1 -> {
                        return PaymentMethod(totalAmount, adultPrice, childrenPrice, numberOfAdult, numberOfChildren);
                    }
                    case 2 -> {
                        SelectPackage();
                        return false;
                    }
                    case 3 -> {
                        MainMenu.mainMenu();
                        return false;
                    }
                    default -> {
                        System.out.println("Invalid choice. Please try again.");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    

    public static void PrintReceipt(int packageId, int totalAmount, int numberOfAdults,
            int numberOfChildren) {
        System.out.println("------------------------------------------------");
        System.out.println("YOUR PAYMENT SUCCESSFULLY MADE!");
        System.out.println("-THANK YOU FOR BOOKING WITH US-");
        switch (packageId) {
            case 1001 -> {
                DatabasePackage.getHajiPackage1().displayPackage();
                System.out.println("Total Payment(Adults: " + numberOfAdults + " + Children: " + numberOfChildren + "):Rm " + totalAmount);
            }
            case 1002 -> {
                DatabasePackage.getHajiPackage2().displayPackage();
                System.out.println("Total Payment(Adults: " + numberOfAdults + " + Children: " + numberOfChildren + "):Rm " + totalAmount);
            }
            case 1003 -> {
                DatabasePackage.getHajiPackage3().displayPackage();
                System.out.println("Total Payment(Adults: " + numberOfAdults + " + Children: " + numberOfChildren + "):Rm " + totalAmount);
            }
            case 2001 -> {
                DatabasePackage.getUmrahPackage1().displayPackage();
                System.out.println("Total Payment(Adults: " + numberOfAdults + " + Children: " + numberOfChildren + "):Rm " + totalAmount);
            }
            case 2002 -> {
                DatabasePackage.getUmrahPackage2().displayPackage();
                System.out.println("Total Payment(Adults: " + numberOfAdults + " + Children: " + numberOfChildren + "):Rm " + totalAmount);
            }
            case 2003 -> {
                DatabasePackage.getUmrahPackage3().displayPackage();
                System.out.println("Total Payment(Adults: " + numberOfAdults + " + Children: " + numberOfChildren + "):Rm " + totalAmount);
            }

        }
        System.out.println("------------------------------------------------");
        System.out.println("Redirecting you to Main Menu ....");
       
    }

    public static void DisplayBookings() {

        System.out.println("Your Bookings:");
        if (bookingCount == 0) {
            System.out.println("No bookings made yet.");
        } else {

            for (int i = 0; i < bookingCount; i++) {
                System.out.println("-----------------------------");
                System.out.println("Booking [" + (i + 1) + "]");
                System.out.println("-----------------------------");
                int packageId = bookingPackageId[i];
                switch (packageId) {
                    case 1001 ->
                        DatabasePackage.getHajiPackage1().displayPackage();
                    case 1002 ->
                        DatabasePackage.getHajiPackage2().displayPackage();

                    case 1003 ->
                        DatabasePackage.getHajiPackage3().displayPackage();

                    case 2001 ->
                        DatabasePackage.getUmrahPackage1().displayPackage();

                    case 2002 ->
                        DatabasePackage.getUmrahPackage2().displayPackage();

                    case 2003 ->
                        DatabasePackage.getUmrahPackage3().displayPackage();

                }
                System.out.println(bookings[i]);

            }
        }
    }

  public static void PrintBookings() {
    
      try (FileWriter printBooking = new FileWriter("printBooking.txt");
         PrintWriter writer = new PrintWriter(printBooking)) {
          for (int i = 0; i < bookingCount; i++) {
              switch (bookingPackageId[i]) {
                    case 1001 ->
                        DatabasePackage.getHajiPackage1();
                    case 1002 ->
                        DatabasePackage.getHajiPackage2();

                    case 1003 ->
                        DatabasePackage.getHajiPackage3();

                    case 2001 ->
                        DatabasePackage.getUmrahPackage1();

                    case 2002 ->
                        DatabasePackage.getUmrahPackage2();

                    case 2003 ->
                        DatabasePackage.getUmrahPackage3();

                }
             writer.println(DatabasePackage.packageName))
              writer.println(bookings[i]);
          }
          System.out.println("Your booking have been printed");
      } catch (IOException e) {
          System.err.println("An error occurred while writing to the file: " + e.getMessage());
      }
      
      MainMenu.mainMenu();
      
  }}
