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
    public void GetBySlagWord(String SlagWord) {
        if (map.containsKey(SlagWord)) {
            System.out.println("Slag word tim duoc la : ");
            System.out.println(map.get(SlagWord));
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
        if (map.containsKey(slag) == true) {
            System.out.println("Slag word da ton tai!!Ban muon ghi de hay them moi??");
            System.out.println("0.Huy bo thao tac");
            System.out.println("1.Them moi");
            System.out.println("2.Ghi de");
            String choice = Helper.scan.nextLine();
            switch (choice) {
                case "0":
                    break;
                case "1":
                    map.put(slag, mean);
                    break;
                case "2":
                    map.put(slag, map.get(slag) + "| " + mean);
                    break;
                default:
                    System.out.println("Khong co lua chon nay!");
                    break;
            }

        }
    }

    @Override
    public void EditSlagWord() {
        System.out.println("Nhap slag word can tim : ");
        String slag = Helper.scan.nextLine();
        if (map.containsKey(slag) == false) {
            System.out.println("Khong tim thay slag word!");
        } else {
            System.out.println("Nhap lua chon : ");
            System.out.println("0.Huy thao tac");
            System.out.println("1.Chinh sua slag word");
            System.out.println("2.Chinh sua y nghia cua slag word");
            System.out.println("3.Chinh sua slag word va y nghia");
            String choice = Helper.scan.nextLine();
            switch (choice) {
                case "0":
                    break;
                case "1":
                    System.out.println("Nhap slag word moi");
                    String NewSlagWord = Helper.scan.nextLine();
                    map.put(NewSlagWord, map.get(slag));
                    map.remove(slag);
                    break;
                case "2":
                    System.out.println("Nhap y nghia moi cua slag word:");
                    String NewMeanning = Helper.scan.nextLine();
                    map.put(slag, NewMeanning);
                    break;
                case "3":
                    System.out.println("Nhap slag word moi");
                    NewSlagWord = Helper.scan.nextLine();
                    System.out.println("Nhap y nghia moi cua slag word:");
                    NewMeanning = Helper.scan.nextLine();
                    map.remove(slag);
                    map.put(NewSlagWord, NewMeanning);
                    break;
                default:
                    System.out.println("Khong co lua chon nay!!");
                    break;
            }
        }
    }
}
