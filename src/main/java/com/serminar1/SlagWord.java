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
        map = new TreeMap<>();
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
    public void GetBySlagWord() {
        System.out.println("Nhap key can lay:");
        String key = Helper.scan.nextLine();
        if (map.containsKey(key)) {
            System.out.println("Slag word tim duoc la : ");
            System.out.println(map.get(key));
        } else {
            System.out.println("Khong ton tai slag word nay!");
        }
    }

    @Override
    public void FindSlagWordByDefinition() {
        System.out.println("Nhap definiton: ");
        String definition = Helper.scan.nextLine();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().toLowerCase().contains(definition.toLowerCase())) {
                System.out.println(entry.getKey());
            }
        }
    }

    @Override
    public void AddNewSlagWord() {
        System.out.println("Nhap slag word can them : ");
        String slag = Helper.scan.nextLine();
        System.out.println("Nhap y nghia cua slag: ");
        String mean = Helper.scan.nextLine();
        if(map.containsKey(slag) == true){
            System.out.println("Slag word da ton tai!!Ban muon ghi de hay them moi??");
            System.out.println("0.Huy bo thao tac");
            System.out.println("1.Them moi");
            System.out.println("2.Ghi de");
            String choice = Helper.scan.nextLine();
            switch (choice){
                case "0":
                    break;
                case "1":
                    map.put(slag,mean);
                    break;
                case "2":
                    map.put(slag, map.get(slag)+"| "+mean);
                    break;
                default:
                    System.out.println("Khong co lua chon nay!");
                    break;
            }
            
        }
    }
}
