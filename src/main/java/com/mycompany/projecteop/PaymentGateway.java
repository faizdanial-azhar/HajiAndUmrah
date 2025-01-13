/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;

import static com.mycompany.projecteop.UserBooking.SelectPackage;
import static com.mycompany.projecteop.UserBooking.bookingCount;
import static com.mycompany.projecteop.UserBooking.bookingPackageId;
import static com.mycompany.projecteop.UserBooking.bookings;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author faizd
 */
//FAIZ DANIAL
public class PaymentGateway {
      public static void HandlePayments(int packageId, int adultPrice, int childrenPrice) {

        Confirmation();
        int numberOfAdult = NumberOfAdult();
        int numberOfChildren = NumberOfChildren();
        int totalAmount = CalculateTotalAmount(adultPrice, numberOfAdult, childrenPrice, numberOfChildren);
        boolean paymentSuccessfull = PaymentMethod(totalAmount, adultPrice, childrenPrice, numberOfAdult, numberOfChildren);
        if (paymentSuccessfull) {
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
            }
        }

    }
    public static void Confirmation() {
        Scanner input = new Scanner(System.in);
        String choice;
        do {
            System.out.println("----------------------------------------------------");
            System.out.print("Continue to Payment Gateway (Y for yes / N for no): ");
            choice = input.next();
            System.out.println("----------------------------------------------------");

            if (choice.equalsIgnoreCase("y")) {
                break;
            } else if (choice.equalsIgnoreCase("n")) {

                UserBooking.SelectPackage();

            } else {
                System.out.println("*** Invalid option, Please enter valid option ***");
            }

        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));

    }

    public static int NumberOfAdult() {
        int numberOfAdults = 0;
        boolean choice = true;
        while (choice) {
            Scanner input = new Scanner(System.in);
            System.out.print("Number of Adults: ");
            numberOfAdults = input.nextInt();
            if (numberOfAdults < 0) {
                System.out.println("Number Of Adults should not be negative.");

            } else {
                break;
            }

        }

        return numberOfAdults;
    }

    public static int NumberOfChildren() {
        int numberOfChildren = 0;
        boolean choice = true;
        while (choice) {
            Scanner input = new Scanner(System.in);
            System.out.print("Number of Children: ");
            numberOfChildren = input.nextInt();
            if (numberOfChildren < 0) {
                System.out.println("Number Of Children should not be negative.");

            } else {
                break;

            }

        }

        return numberOfChildren;
    }

    public static int CalculateTotalAmount(int adultPrice, int numberOfAdults, int childrenPrice, int numberOfChildren) {
        System.out.println("-------------------");
        int totalAmount = (numberOfAdults * adultPrice) + (numberOfChildren * childrenPrice);
        return totalAmount;
    }
public static boolean PaymentMethod(int totalAmount, int adultPrice, int childrenPrice, int numberOfAdult, int numberOfChildren) {
    Scanner input = new Scanner(System.in);
    int paymentMethod;
    
    try {
        while (true) {
            System.out.println("PAYMENT METHODS :");
            System.out.println("Total Payments for (" + numberOfAdult + " Adults + " + numberOfChildren + " Children): RM " + totalAmount);
            System.out.println("1 = Online Banking\n2 = Debit Card(Visa/Mastercard)\n3 = E-wallet ");
            System.out.print("Please choose your payment methods: ");
            
            try {
                paymentMethod = input.nextInt();
                input.nextLine(); // Clear buffer
                
                if (paymentMethod >= 1 && paymentMethod <= 3) {
                    System.out.println(">>> Amount To Pay: RM " + totalAmount);
                    System.out.print("Y to Pay / N to Cancel : ");
                    String choice = input.nextLine().trim();
                    
                    if (choice.equalsIgnoreCase("n")) {
                        System.out.println("--------------------------------------");
                        System.out.println("1. Change Payment Method\n2. Change Package\n3. Main Menu");
                        
                        while (true) {
                            try {
                                System.out.print("Choice: ");
                                int innerChoice = input.nextInt();
                                System.out.println("--------------------------------------");
                                
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
                                        System.out.println("*** Invalid choice. Please enter 1, 2, or 3. ****");
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("*** Please enter a valid number. ***");
                                input.nextLine(); // Clear buffer
                            }
                        }
                    } else if (choice.equalsIgnoreCase("y")) {
                        return true;
                    } else {
                        System.out.println("Invalid choice. Please enter Y or N.");
                    }
                } else {
                    System.out.println("Invalid payment method. Please choose 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("*** Please enter a valid choice. ***");
                input.nextLine(); // Clear buffer
            }
        }
    } catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
        return false;
    } 
}


    public static void PrintReceipt(int packageId, int totalAmount, int numberOfAdults,
            int numberOfChildren) {
        System.out.println("------------------------------------------------");
        System.out.println("=== YOUR PAYMENT SUCCESSFULLY MADE! ===");
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

}
