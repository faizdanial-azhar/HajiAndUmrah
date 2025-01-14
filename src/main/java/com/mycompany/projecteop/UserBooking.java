/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;


import java.util.InputMismatchException;
import java.util.Scanner;

// AMMAR FAIZ
public class UserBooking {

    public static final String[] bookings = new String[100];
    public static final int[] bookingPackageId = new int[100];
    public static int bookingCount = 0;



    public static void SelectPackage() {
        Scanner input = new Scanner(System.in);
        
//user enter choose their package
        while (true) {

            System.out.print("(Haji -- H / Umrah - U):");
            String choice = input.next();
            if (choice.equalsIgnoreCase("H")) {
                PackageHaji();
                break;
            } else if (choice.equalsIgnoreCase("U")) {
                PackageUmrah();
                break;
            } else {
                System.out.println("*** Invalid choice. Please Enter Valid Choice. ***");
            }
        }
    }

    public static void PackageHaji() {
        //display package based on user choice
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int adultPrice;
        int childrenPrice;
        System.out.println("---------------------------------------------------------------");

        System.out.println("HAJI PACKAGES:\n");
        DatabasePackage.getHajiPackage1().displayPackage();
        System.out.println();
        DatabasePackage.getHajiPackage2().displayPackage();
        System.out.println();
        DatabasePackage.getHajiPackage3().displayPackage();
        System.out.println("---------------------------------------------------------------");
        System.out.println("1.Haji 1st Package   2.Haji 2nd Package   3.Haji 3rd Package");
        System.out.println("---------------------------------------------------------------");
        do {
            try{
            System.out.print("Your Package Number: ");
            choice = input.nextInt();

            if (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("*** Invalid package pls enter valid package! ***");
            }}catch(InputMismatchException e){
                System.out.println(" *** Invalid package pls enter valid package number! ***");
                input.nextLine();
            }

        } while (choice != 1 && choice != 2 && choice != 3);

        switch (choice) {
            case 1 -> {
                DatabasePackage.getHajiPackage1().displayPackage();
                adultPrice = DatabasePackage.getHajiPackage1().getAdultPrice();
                childrenPrice = DatabasePackage.getHajiPackage1().getAdultPrice();
                PaymentGateway.HandlePayments(1001, adultPrice, childrenPrice);
                break;
            }

            case 2 -> {
                DatabasePackage.getHajiPackage2().displayPackage();
                adultPrice = DatabasePackage.getHajiPackage2().getAdultPrice();
                childrenPrice = DatabasePackage.getHajiPackage2().getAdultPrice();
                 PaymentGateway.HandlePayments(1002, adultPrice, childrenPrice);
                break;
            }
            case 3 -> {
                DatabasePackage.getHajiPackage3().displayPackage();
                adultPrice = DatabasePackage.getHajiPackage3().getAdultPrice();
                childrenPrice = DatabasePackage.getHajiPackage3().getAdultPrice();
                 PaymentGateway.HandlePayments(1003, adultPrice, childrenPrice);
                break;
            }

        }
        System.out.println("-----------------------------------");
    }

    public static void PackageUmrah() {
        
        //display umrah package based on user choice
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int adultPrice;
        int childrenPrice;
        System.out.println("---------------------------------------------------------------");
        System.out.println("UMRAH PACKAGES:\n");
        DatabasePackage.getUmrahPackage1().displayPackage();
        System.out.println();
        DatabasePackage.getUmrahPackage2().displayPackage();
        System.out.println();
        DatabasePackage.getUmrahPackage3().displayPackage();
        System.out.println("---------------------------------------------------------------");
        System.out.println("1.Umrah 1st Package   2.Umrah 2nd Package   3.Umrah 3rd Package");
        System.out.println("---------------------------------------------------------------");
        do {
            try{
            System.out.print("Your Package Number: ");
            choice = input.nextInt();

            if (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("*** Invalid package pls enter valid package! ***");
            }
            }catch(InputMismatchException e){
                System.out.println("*** Invalid package pls enter valid package! ***");
                input.nextLine();
            }

        } while (choice != 1 && choice != 2 && choice != 3);
        System.out.println("-----------------------------");
        switch (choice) {
            case 1 -> {
                DatabasePackage.getUmrahPackage1().displayPackage();
                adultPrice = DatabasePackage.getUmrahPackage1().getAdultPrice();
                childrenPrice = DatabasePackage.getUmrahPackage1().getAdultPrice();
                 PaymentGateway.HandlePayments(2001, adultPrice, childrenPrice);
            }
            case 2 -> {
                DatabasePackage.getUmrahPackage2().displayPackage();
                adultPrice = DatabasePackage.getUmrahPackage2().getAdultPrice();
                childrenPrice = DatabasePackage.getUmrahPackage2().getAdultPrice();
                 PaymentGateway.HandlePayments(2002, adultPrice, childrenPrice);
            }
            case 3 -> {
                DatabasePackage.getUmrahPackage3().displayPackage();
                adultPrice = DatabasePackage.getUmrahPackage3().getAdultPrice();
                childrenPrice = DatabasePackage.getUmrahPackage3().getAdultPrice();
                 PaymentGateway.HandlePayments(2003, adultPrice, childrenPrice);
            }

            default ->
                System.out.println("Not A valid Package");

        }
        System.out.println("-----------------------------------");
    }
  


}
