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
//ADAM NAEMAN
public class Account {

    public static void AccountSignIn() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {

                System.out.println("1.Log in As Client\n2.Log In As Admin\n3.Exit ");
                System.out.println("--------------------------------------");
                 System.out.print("Choice: ");
                int choice = input.nextInt();
                 System.out.println("--------------------------------------");

                if (choice == 1) {
                    UserLogin.ClientInterface();
                } else if (choice == 2) {
                    AdminManagement.adminLogin();
                } else if (choice == 3) {
                    System.out.println("Thank you For Using Our Services!");
                   
                    System.exit(0);
                    
                }else{
                    System.out.println("*** Invalid Choice, log in again. ***");
                }
            } catch (Exception e) {
                System.out.println("*** Error in system, log in again. ***");
                input.nextLine();
            }
        }
    }

}
