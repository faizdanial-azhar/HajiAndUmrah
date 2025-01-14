/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;


import java.util.Scanner;


//ADAM ISKANDAR
public class DeleteBooking {
    
    public static void handleDeleteBooking() {
        Scanner input = new Scanner(System.in);
        
        if (UserBooking.bookingCount == 0) {
            System.out.println("No bookings available to delete.");
            System.out.println("Adamn github");
            MainMenu.mainMenu();
            return;
        }
        
        // Display all current bookings
        BookingLists.DisplayBookings();
        
        System.out.println("\nDELETE BOOKING");
        System.out.println("-----------------------------");
        System.out.print("Enter booking number to delete (1-" + UserBooking.bookingCount + "): ");
        
        try {
            int bookingNumber = input.nextInt();
            
            if (bookingNumber < 1 || bookingNumber > UserBooking.bookingCount) {
                System.out.println("Invalid booking number!");
                handleDeleteBooking();
                return;
            }
            
            // Get package ID before deletion for statistics update
            int packageId = UserBooking.bookingPackageId[bookingNumber - 1];
            
            // Confirm deletion
            System.out.print("Are you sure you want to delete this booking? (Y/N): ");
            String confirmation = input.next();
            
            if (confirmation.equalsIgnoreCase("Y")) {
                deleteBooking(bookingNumber - 1, packageId);
                System.out.println("Booking successfully deleted!");
            } else {
                System.out.println("Deletion cancelled.");
            }
            
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }
        
        MainMenu.mainMenu();
    }
    
    private static void deleteBooking(int index, int packageId) {
        // Update admin statistics
        updateAdminStatistics(packageId);
        
        // Shift all elements after the deleted booking one position to the left
        for (int i = index; i < UserBooking.bookingCount - 1; i++) {
            UserBooking.bookings[i] = UserBooking.bookings[i + 1];
            UserBooking.bookingPackageId[i] = UserBooking.bookingPackageId[i + 1];
        }
        
        // Clear the last element
        UserBooking.bookings[UserBooking.bookingCount - 1] = null;
        UserBooking.bookingPackageId[UserBooking.bookingCount - 1] = 0;
        
        // Decrease the booking count
        UserBooking.bookingCount--;
    }
    
    public static void updateAdminStatistics(int packageId) {
        // Convert package ID to array index
        int index;
        if (packageId >= 1001 && packageId <= 1003) {
            index = packageId - 1001; // Haji packages
        } else if (packageId >= 2001 && packageId <= 2003) {
            index = packageId - 1998; // Umrah packages
        } else {
            return;
        }
        
        // Decrease the count for the deleted package
        if (AdminManagement.packageBookingCounts[index] > 0) {
            AdminManagement.packageBookingCounts[index]--;
        }
    }
}
