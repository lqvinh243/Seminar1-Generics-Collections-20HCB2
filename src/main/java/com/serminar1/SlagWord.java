/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serminar1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author lqvin
 */
public class SlagWord implements ISlagWord {

    private TreeMap<String, String> map;

    public SlagWord() {
        map = new TreeMap<String, String>();
    }

    @Override
    public void ReadSlagWordFromFile() {
        try {
            File myObj = new File("slang.txt");
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] arrOfStr = data.split("`", 2);
                    if (arrOfStr.length < 2) {
                        continue;
                    }
                    map.put(arrOfStr[0], arrOfStr[1]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    @Override
    public void PrintList() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
        }
    }

    @Override
    public void GetBykey() {
        System.out.println("Nhap key can lay:");
        String key = Helper.scan.nextLine();
        if(map.containsKey(key)){
            System.out.println("Slag word tim duoc la : ");
            System.out.println(map.get(key));
        }
        else {
            System.out.println("Khong ton tai slag word nay!");
        }
    }

}
