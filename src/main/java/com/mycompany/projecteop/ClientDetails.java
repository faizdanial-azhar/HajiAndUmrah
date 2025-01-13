/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecteop;

/**
 *
 * @author faizd
 */
//ADAM NAEMAN
public class ClientDetails {
    private static String username;
    private static String password;
    
    public ClientDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}
