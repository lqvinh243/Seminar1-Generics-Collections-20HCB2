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
public interface ISlagWord {
    public boolean ReadDataSlagWordSave();
    public void ReadSlagWordFromFile();
    public void PrintList();
    public void GetBySlagWord(String SlagWord);
    public void FindSlagWordByDefinition();
    public void AddNewSlagWord();
    public void EditSlagWord();
    public void DeleteSlagWord();
    public void Reset();
    public void RandomSlagWord();
    public void QuizOne();
    public void QuizTwo();
    public void Menu();
}
