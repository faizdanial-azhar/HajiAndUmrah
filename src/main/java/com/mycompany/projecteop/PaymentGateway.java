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


//FAIZ DANIAL
public class PaymentGateway {

    public static void HandlePayments(int packageId, int adultPrice, int childrenPrice) {
//handle the flow of payments
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
                MainMenu.mainMenu();
            }
        }

    }

    public static void Confirmation() {
        Scanner input = new Scanner(System.in);
        String choice;
        //allow user to confirm their purchases
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
        //allow user enter number of adult passenger
        Scanner input = new Scanner(System.in);
        int numberOfAdults = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Number of Adults: ");
                numberOfAdults = input.nextInt();

                if (numberOfAdults < 0) {
                    System.out.println("Number of Adults should not be negative.");
                } else {
                    validInput = true; // Exit the loop for valid input
                }
            } catch (InputMismatchException e) {
                System.out.println("*** Invalid Input! Please enter a valid number. ***");
                input.nextLine(); // Clear the invalid input
            }
        }

        return numberOfAdults;
    }

    public static int NumberOfChildren() {
        
         //allow user enter number of children passenger
        Scanner input = new Scanner(System.in);
        int numberOfChildren = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Number of Children: ");
                numberOfChildren = input.nextInt();

                if (numberOfChildren < 0) {
                    System.out.println("*** Number of Children should not be negative. ***");
                } else {
                    validInput = true; // Exit the loop for valid input
                }
            } catch (InputMismatchException e) {
                System.out.println("*** Invalid Input! Please enter a valid number. ***");
                input.nextLine(); // Clear the invalid input
            }
        }

        return numberOfChildren;
    }

    public static int CalculateTotalAmount(int adultPrice, int numberOfAdults, int childrenPrice, int numberOfChildren) {
        //calculate total payment need to be pay
        System.out.println("-------------------");
        int totalAmount = (numberOfAdults * adultPrice) + (numberOfChildren * childrenPrice);
        return totalAmount;
    }
public static boolean PaymentMethod(int totalAmount, int adultPrice, int childrenPrice, int numberOfAdult, int numberOfChildren) {
    Scanner input = new Scanner(System.in);
    //allow user choose payment method they prefer
    int paymentMethod ;

    try {
        while (true) {
            System.out.println("PAYMENT METHODS:");
            System.out.println("Total Payments for (" + numberOfAdult + " Adults + " + numberOfChildren + " Children): RM " + totalAmount);
            System.out.println("1 = Online Banking\n2 = Debit Card (Visa/Mastercard)\n3 = E-wallet");
            System.out.print("Please choose your payment method: ");

            try {
                paymentMethod = input.nextInt();
                

                if (paymentMethod >= 1 && paymentMethod <= 3) {
                    System.out.println(">>> Amount To Pay: RM " + totalAmount);

                    while (true) { // Loop to ensure valid input for Y/N
                        System.out.print("Enter Y to Pay or N to Cancel: ");
                        String choice = input.next();

                        if (choice.equalsIgnoreCase("y")) {
                            return true; // Payment successful
                        } else if (choice.equalsIgnoreCase("n")) {
                            handleCancellation(choice, totalAmount, adultPrice, childrenPrice, numberOfAdult, numberOfChildren);
                            return false; // Payment cancelled
                        } else {
                            System.out.println("*** Invalid choice. Please enter 'Y' or 'N'. ***");
                        }
                    }
                } else {
                    System.out.println("*** Invalid payment method. Please choose 1, 2, or 3. ***");
                }
            } catch (InputMismatchException e) {
                System.out.println("*** Invalid input. Please enter a valid number for the payment method. ***");
                input.nextLine(); 
            }
        }
    } catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
        return false;
    }
}

public static void handleCancellation( String Choice,int totalAmount, int adultPrice, int childrenPrice, int numberOfAdult, int numberOfChildren) {
    while (true) {
        //handle payment cancellation and allow user to choose the reason they cancel
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("1. Change Payment Method\n2. Change Package\n3. Main Menu");
        System.out.println("--------------------------------------");

        try {
            System.out.print("Choose an option: ");
            int innerChoice = input.nextInt();
            

            switch (innerChoice) {
                case 1 -> {
                    PaymentMethod(totalAmount, adultPrice, childrenPrice, numberOfAdult, numberOfChildren);
                    return;
                }
                case 2 -> {
                    SelectPackage();
                    return;
                }
                case 3 -> {
                    MainMenu.mainMenu();
                    return;
                }
                default -> System.out.println("*** Invalid choice. Please enter 1, 2, or 3. ***");
            }
        } catch (InputMismatchException e) {
            System.out.println("*** Invalid input. Please enter a valid number. ***");
            input.nextLine(); // Clear invalid input
        }
    }
}


    public static void PrintReceipt(int packageId, int totalAmount, int numberOfAdults,
            int numberOfChildren) {
        //print receipt of the payment be made
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
