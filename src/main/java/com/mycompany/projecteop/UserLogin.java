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
public class UserLogin {
    
        private static final String[] usernameClient = new String[100];
        private static final String[] passwordClient = new String[100];
        
    public static void ClientRegister(){
                
        Scanner input = new Scanner(System.in);
      
        System.out.println("-----------------------------");
        System.out.println("CLIENT REGISTER");
        System.out.println("-----------------------------");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        
        DatabaseClient(username, password);
        ClientLogin();
        
        
    }
    
    public static void ClientInterface() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you have an account ? (Y = Yes, N = No)");
        String option = input.nextLine();
        if (option.equalsIgnoreCase("N")){
              System.out.println("Please Register First");
            ClientRegister();
        } else if (option.equalsIgnoreCase("Y")) {
            System.out.println("Please Login First");
            ClientLogin();
        }
    }
    
    public static void ClientLogin(){
                
        Scanner input = new Scanner(System.in);
       
        System.out.println("-----------------------------");
        System.out.println("CLIENT LOGIN");
        System.out.println("-----------------------------");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        
        boolean name = ConfirmationUsername(username);
        boolean pass = ConfirmationPassword(password);
        
        if(name && pass) {
            MainMenu.mainMenu();
        } else if(!name || !pass){
           ClientInterface();
        }
    }
    
    public static void DatabaseClient(String username, String password) {
        
        for (int i = 0; i < 100; i++) {
            passwordClient[i] = password;
            usernameClient[i] = username;
        }
  
    }
    
    public static boolean ConfirmationUsername(String username){
        try{
                for (String name: usernameClient) {
                if (name.equals(username)){
                    return true;
                } 
            }
            
        } catch(Exception e) {
            return false;
        } 
        return false;
    }
    
    public static boolean ConfirmationPassword(String password){
        
        try{
                for (String pass: passwordClient) {
                if (pass.equals(password)){
                    return true;
                } 
            }
        } catch (Exception e) {
            return false;
        }  
        
        return false;
    }
}
