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
public class UserLogin {

    private static final String[] usernameClient = new String[100];
    private static final String[] passwordClient = new String[100];

    public static void ClientRegister() {

        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------");
        System.out.println("CLIENT REGISTER");
        System.out.println("-----------------------------");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        System.out.println("User Succsefully Created!");
        DatabaseClient(username, password);
        ClientLogin();

    }

    public static void ClientInterface() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("User Registeration / User Log In");
            System.out.println("--------------------------------------");
            System.out.print("(Register = R / Login = L):");
            String option = input.nextLine();
            if (option.equalsIgnoreCase("R")) {

                ClientRegister();
                break;
            } else if (option.equalsIgnoreCase("L")) {

                ClientLogin();
                break;
            } else {
                System.out.println("*** Invalid Choice. Please enter valid choice. ***");
                                System.out.println("--------------------------------------");
            }
        }
    }

    public static void ClientLogin() {

        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------");
        System.out.println("CLIENT LOGIN");
        System.out.println("-----------------------------");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        System.out.println("Log In...");
        boolean name = ConfirmationUsername(username);
        boolean pass = ConfirmationPassword(password);

        if (name && pass) {
            MainMenu.mainMenu();
        } else if (!name || !pass) {
            System.out.println("*** Wrong Username/Password ***");
            System.out.println("Redirecting to Login page...");
                            System.out.println("--------------------------------------");
            ClientInterface();
        }
    }

    public static void DatabaseClient(String username, String password) {

        for (int i = 0; i < 100; i++) {
            passwordClient[i] = password;
            usernameClient[i] = username;
        }

    }

    public static boolean ConfirmationUsername(String username) {
        try {
            for (String name : usernameClient) {
                if (name.equals(username)) {
                    return true;
                }
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static boolean ConfirmationPassword(String password) {

        try {
            for (String pass : passwordClient) {
                if (pass.equals(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }
}
