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
public class Account {
 public static void AccountSignIn(){
     Scanner input = new Scanner (System.in);
     System.out.println("1.Log in As Client\n2.Log In As Admin\n3.Exit ");
     int choice = input.nextInt();
     
     if (choice == 1){
         UserLogin.ClientInterface();
     } else if(choice == 2){
         AdminManagement.adminLogin();
     } else if (choice == 3){
         System.out.println("Thank you For Using Our Services");
         
     }
 }
         
}
