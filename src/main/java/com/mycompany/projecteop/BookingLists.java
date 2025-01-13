/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;

import static com.mycompany.projecteop.UserBooking.bookingCount;
import static com.mycompany.projecteop.UserBooking.bookingPackageId;
import static com.mycompany.projecteop.UserBooking.bookings;

/**
 *
 * @author faizd
 */
//AMMAR FAIZ
public class BookingLists {

      public static void HandleDisplayBookings(){
            DisplayBookings();
             MainMenu.mainMenu();
    
    }
    
      
       
        // Simulate selecting a package and booking
     
        
    public static void DisplayBookings() {

        System.out.println("=== Your Bookings ===");
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
  
}


        


