package main.java.by.tc.task03.main;

import main.java.analizator.Analizator;
import main.java.analizator.util.Node;
import main.java.by.tc.task03.main.fabrica.AnalizatorFabrica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;

public class Main {

            private static final String typeOfFile = "xml";

    public static void main(String[] args) {

        try {

            String xml_path;

            Node node = null;

            ResourcesPath resourcesPath = new ResourcesPath();

            xml_path = resourcesPath.takePath(typeOfFile);

            AnalizatorFabrica fabrica = AnalizatorFabrica.getInstance();

            Analizator analizator = fabrica.makeAnalizator(new FileInputStream(xml_path));

            while ((node = analizator.next()) != null) {
                PrintXMLNode.print(node);
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());

        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
