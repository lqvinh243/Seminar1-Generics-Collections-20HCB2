/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serminar1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

/**
 *
 * @author lqvin
 */
public final class SlagWord implements ISlagWord {

    private TreeMap<String, String> map;
    private final Stack<String> historyStack;

    public SlagWord() {
        map = new TreeMap<>();
        historyStack = new Stack();
        ReadSlagWordFromFile();
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

    public void ShowHistory() {
        System.out.println("Danh sach cac slag word da tim sap xep theo moi nhat:");
        int count = 0;
        for (int i = this.historyStack.size() - 1; i >= 0; i--) {
            System.out.println(this.historyStack.get(i));
            count++;
            if (count == 10) {
                break;
            }
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
        historyStack.push(SlagWord);
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

    @Override
    public void DeleteSlagWord() {
        System.out.println("Nhap slag word can xoa : ");
        String SlagWord = Helper.scan.nextLine();
        if (map.containsKey(SlagWord) == false) {
            System.out.println("Khong ton tai slag word nay!");
        } else {
            System.out.println("Ban co chac chan muon xoa tu nay?");
            System.out.println("1.Xoa ngay");
            System.out.println("2.Huy");
            String choice = Helper.scan.nextLine();
            switch (choice) {
                case "1":
                    map.remove(SlagWord);
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Khong tim thay lua chon!!");
            }
        }

    }

    @Override
    public void Reset() {
        ReadSlagWordFromFile();
    }

    @Override
    public void RandomSlagWord() {
        System.out.println("Random slag word :");
        Random generator = new Random();
        Object[] key = map.keySet().toArray();
        int numberRd = generator.nextInt(key.length);
        String randomKey = key[numberRd].toString();
        System.out.println("Key : " + randomKey);
        System.out.println("Definition : " + map.get(randomKey));
    }

    @Override
    public void QuizOne() {
        List<String> answers = new ArrayList<String>();
        String correctAnswer;
        System.out.println("Chao mung ban den voi game show!!");
        System.out.println("Chon definition dung cho slag word sau : ");
        Random generator = new Random();
        Object[] key = map.keySet().toArray();
        int numberRd = generator.nextInt(key.length);
        String randomKey = key[numberRd].toString();
        correctAnswer = map.get(randomKey);
        answers.add(correctAnswer);
        for (int i = 0; i < 3; i++) {
            numberRd = generator.nextInt(numberRd);
            answers.add(map.get(key[numberRd].toString()));
        }
        Collections.shuffle(answers);
        System.out.println("Slag word : " + randomKey);
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + " " + answers.get(i));
        }
        String choice = Helper.scan.nextLine();

        try {
            if (answers.get(Integer.parseInt(choice) - 1).equals(correctAnswer)) {
                System.out.println("Toe toe !! Chuc mung ban da tra loi dung");
            } else {
                System.out.println("Chia buon cung ban da tra loi sai!");
            }
        } catch (Exception e) {
            System.out.println("Chia buon cung ban da tra loi sai!");
        }
    }

    @Override
    public void QuizTwo() {
        List<String> answers = new ArrayList<String>();
        String correctAnswer;
        System.out.println("Chao mung ban den voi game show!!");
        System.out.println("Chon slag word dung cho definition sau : ");
        Random generator = new Random();
        Object[] key = map.keySet().toArray();
        int numberRd = generator.nextInt(key.length);
        String randomKey = key[numberRd].toString();
        correctAnswer = randomKey;
        answers.add(correctAnswer);
        for (int i = 0; i < 3; i++) {
            numberRd = generator.nextInt(numberRd);
            answers.add(key[numberRd].toString());
        }
        Collections.shuffle(answers);
        System.out.println("Definition : " + map.get(randomKey));
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + " " + answers.get(i));
        }
        String choice = Helper.scan.nextLine();

        try {
            if (answers.get(Integer.parseInt(choice) - 1).equals(correctAnswer)) {
                System.out.println("Toe toe !! Chuc mung ban da tra loi dung");
            } else {
                System.out.println("Chia buon cung ban da tra loi sai!");
            }
        } catch (Exception e) {
            System.out.println("Chia buon cung ban da tra loi sai!");
        }
    }

    @Override
    public void Menu() {
        System.out.println("Xin chao ban den voi chuong truong trinht thao tac voi slag word!!");
        String choose;
        do {
            System.out.println("Cac chuc nang chinh co trong chuong trinh : ");
            System.out.println("0.Thoat chuong trinh!");
            System.out.println("1.Tim kiem theo slag word!");
            System.out.println("2.Tim kiem theo definition!");
            System.out.println("3.Hien thi history slag word da tim kiem!");
            System.out.println("4.Chuc nang them mot slag word moi!");
            System.out.println("5.Chuc nang chinh sua slag word!");
            System.out.println("6.Chuc nang delete slag word");
            System.out.println("7.Chuc nang reset slag word goc!");
            System.out.println("8.Chuc nang random slag word!");
            System.out.println("9.Quiz game, hien thi slag word, tim definition chinh xac!!");
            System.out.println("10.Quiz game, hien thi definition, tim slag word chinh xac!! ");
            System.out.println("Chon chuc nang:");
            choose = Helper.scan.nextLine();
            switch (choose) {
                case "0":
                    break;
                case "1":
                    System.out.println("Nhap slag word can lay : ");
                    String SlagWord = Helper.scan.nextLine();
                    this.GetBySlagWord(SlagWord);
                    Helper.pressAnyKeyToContinue();
                    break;
                case "2":
                    this.FindSlagWordByDefinition();
                    Helper.pressAnyKeyToContinue();
                    break;
                case "3":
                    this.ShowHistory();
                    Helper.pressAnyKeyToContinue();
                    break;
                case "4":
                    this.AddNewSlagWord();
                    Helper.pressAnyKeyToContinue();
                    break;
                case "5":
                    this.EditSlagWord();
                    Helper.pressAnyKeyToContinue();
                    break;
                case "6":
                    this.DeleteSlagWord();
                    Helper.pressAnyKeyToContinue();
                    break;
                case "7":
                    this.Reset();
                    Helper.pressAnyKeyToContinue();
                    break;
                case "8":
                    this.RandomSlagWord();
                    Helper.pressAnyKeyToContinue();
                    break;
                case "9":
                    this.QuizOne();
                    Helper.pressAnyKeyToContinue();
                    break;
                case "10":
                    this.QuizTwo();
                    Helper.pressAnyKeyToContinue();
                    break;
                default:
                    System.out.println("Khong ton tai chuc nang nay!!");
                    Helper.pressAnyKeyToContinue();
            }
        } while (choose.compareTo("0") != 0);
    }
}
