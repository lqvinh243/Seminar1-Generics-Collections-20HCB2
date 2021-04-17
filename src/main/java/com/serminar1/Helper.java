/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serminar1;

import java.util.Scanner;

/**
 *
 * @author lqvin
 */
public class Helper {
    public static void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
    
    public static Scanner scan = new Scanner(System.in);
}
