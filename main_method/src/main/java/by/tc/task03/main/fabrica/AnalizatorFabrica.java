package main.java.by.tc.task03.main.fabrica;


import main.java.analizator.Analizator;

import java.io.FileInputStream;

public class AnalizatorFabrica {

    private static final AnalizatorFabrica instance = new AnalizatorFabrica();

    public static AnalizatorFabrica getInstance(){
        return instance;
    }

    public Analizator makeAnalizator(FileInputStream inputStream){
        return new Analizator(inputStream);
    }
}
