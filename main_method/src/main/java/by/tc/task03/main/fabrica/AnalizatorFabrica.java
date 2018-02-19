package main.java.by.tc.task03.main.fabrica;


import main.java.analizator.Analizator;

import java.io.FileInputStream;

public class AnalizatorFabrica {// ты пользуешься джаркой, и создаешь фарбику, поставляющую ее объекты
    // ЗАЧЕМ ты это делаешь?????? у тебя задача требует изменения подхода создания объектов
    // не уподобляетесь братьям нашим меньшим - включай голову, всю, а не просто используй набор выученных трюков

    private static final AnalizatorFabrica instance = new AnalizatorFabrica();

    public static AnalizatorFabrica getInstance(){
        return instance;
    }

    public Analizator makeAnalizator(FileInputStream inputStream){
        return new Analizator(inputStream);
    }
}
