package main.java.by.tc.task03.main;

import main.java.analizator.util.Node;
import main.java.analizator.util.TypeOfNode;

public class PrintXMLNode {

    public static void print(Node node){

        TypeOfNode typeOfNode = node.getNodeType();

        String name = node.getNodeName();

        System.out.println("[" + typeOfNode + "]  " + name);
    }
}
