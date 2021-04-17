/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serminar1;

/**
 *
 * @author lqvin
 */
public class Main {

    public static void main(String[] args) {
        SlagWord slag = new SlagWord();
//        slag.ReadSlagWordFromFile();
//        slag.GetBySlagWord();
        long startTime = System.nanoTime();
//        slag.AddNewSlagWord();
//        slag.GetBySlagWord("&");
          slag.Menu();
//        slag.EditSlagWord();
//        slag.GetBySlagWord("&");
//        slag.GetBySlagWord("&&");
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
}
