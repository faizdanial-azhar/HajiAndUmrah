/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;


//ADAM ISKANDAR
//place to store our package data and allow it be call from any class
public class DatabasePackage {
   private final String packageName;
    private final int packageId;
    private final int adultPrice;
    private final int childrenPrice;
    private final String fromDate;
    private final String toDate;
    private final String departureTime;
    private final String arrivalTime;

    // Constructor
    public DatabasePackage(String packageName,int packageId, int adultPrice, int childrenPrice, String fromDate, String toDate, String departureTime, String arrivalTime) {
        this.packageName = packageName;
        this.packageId = packageId;
        this.adultPrice = adultPrice;
        this.childrenPrice = childrenPrice;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Getters
    public String getPackageName(){
    return packageName;
}
    
    public int getPackageId() {
        return packageId;
    }

    public int getAdultPrice() {
        return adultPrice;
    }

    public int getChildrenPrice() {
        return childrenPrice;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    //package details
    public static DatabasePackage getHajiPackage1() {
        return new DatabasePackage("Haji Package 1",1001, 33000, 20999, "15 May 2025", "15 June 2025", "19:00", "03:00");
    }

    public static DatabasePackage getHajiPackage2() {
        return new DatabasePackage("Haji Package 2",1002, 28000, 18999, "23 May 2025", "10 June 2025", "22:00", "07:00");
    }

    public static DatabasePackage getHajiPackage3() {
        return new DatabasePackage("Haji Package 3",1003, 40000, 24999, "10 May 2025", "1 July 2025", "20:00", "04:00");
    }

    public static DatabasePackage getUmrahPackage1() {
        return new DatabasePackage("Umrah Package 1",2001, 8000, 5999, "12 January 2025", "31 January 2025", "15:00", "01:00");
    }

    public static DatabasePackage getUmrahPackage2() {
        return new DatabasePackage("Umrah Package 2",2002, 11000, 7989, "20 January 2025", "15 February 2025", "23:00", "09:00");
    }

    public static DatabasePackage getUmrahPackage3() {
        return new DatabasePackage("Umrah Package 3",2003, 12000, 8509, "23 December 2024", "07 January 2025", "10:00", "23:00");
    }

    
    public void displayPackage() {
        System.out.println("--PACKAGE DETAILS--");
        System.out.println(packageName);
        System.out.println("Package ID: " + packageId);
        System.out.println("Adult Price: RM " + adultPrice);
        System.out.println("Children Price: RM " + childrenPrice);
        System.out.println("From Date: " + fromDate);
        System.out.println("To Date: " + toDate);
        System.out.println("Departure Time (MYT): " + departureTime);
        System.out.println("Arrival Time (KST): " + arrivalTime);
    }
    
    
}

    

