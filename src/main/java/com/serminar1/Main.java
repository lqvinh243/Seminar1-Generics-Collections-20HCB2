/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serminar1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/**
 *
 * @author lqvin
 */
public class Main {

    static Stack<String> his = new Stack<>();

    public static ArrayList<String> findBySlagWord(TreeMap<String, ArrayList<String>> map, String slagWord) {
        his.push(slagWord);
        return map.get(slagWord);
    }

    public static void findByDefinition(TreeMap<String, ArrayList<String>> map, String slagWord) {
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (useLoop(entry.getValue(), slagWord)) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static boolean useLoop(ArrayList<String> arr, String targetValue) {
        for (String s : arr) {
            if (s.contains(targetValue)) {
                return true;
            }
        }
        return false;
    }

    public static void randomMap(TreeMap<String, ArrayList<String>> map) {
        Set<String> keySet = map.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        int size = keyList.size();
        int randIdx = new Random().nextInt(size);
//
        String randomKey = keyList.get(randIdx);
        ArrayList<String> randomValue = map.get(randomKey);

        System.out.println("key: " + randomKey + ", value: " + randomValue);
    }

    public static void deleteSlagWord(TreeMap<String, ArrayList<String>> map) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap slag word can xoa:");
        String slagWord = scan.nextLine();
        if (map.containsKey(slagWord) == false) {
            System.out.println("Khong tim thay slag word nay!");
            return;
        }
        System.out.println("Ban co chac muon xoa slag word nay?");
        System.out.println("1.Yes?");
        System.out.println("0.No?");
        String choose = scan.nextLine();
        switch (choose) {
            case "0":
                break;
            case "1":
                map.remove(slagWord);
                break;
            default:
                System.out.println("Khong co lua chon nay!");
                break;
        }
    }

    public static void main(String[] args) {
        SlagWord slag = new SlagWord();
        slag.ReadSlagWordFromFile();
        slag.PrintList();
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
}
