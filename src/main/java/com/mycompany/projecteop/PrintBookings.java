/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;

import static com.mycompany.projecteop.UserBooking.bookingCount;
import static com.mycompany.projecteop.UserBooking.bookingPackageId;
import static com.mycompany.projecteop.UserBooking.bookings;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author faizd
 */
//ADAM ISKANDAR
public class PrintBookings {
    
    public static void PrintBookings() {
          if (bookingCount == 0) {
            System.out.println("No booking made yet.");
           
        }else{
               System.out.println("Your booking have been printed");
          }
        try (FileWriter printBooking = new FileWriter("printBooking.txt"); PrintWriter writer = new PrintWriter(printBooking)) {
            for (int i = 0; i < bookingCount; i++) {
                writer.println("--------------------------");
                writer.println("Booking number -- " + (i + 1));
                writer.println("Package id:" + bookingPackageId[i]);
                writer.println(bookings[i]);

           
            }
            
           
           
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        MainMenu.mainMenu();

    }
}
