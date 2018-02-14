package main.java.analizator;

import main.java.analizator.util.MyReader;
import main.java.analizator.util.MyXMLReader;
import main.java.analizator.util.Node;
import main.java.analizator.util.NodeCreator;
import java.io.IOException;
import java.io.FileInputStream;

public class Analizator {

    private MyReader XMLReader = null;

    private Node node = null;

    private static final NodeCreator nodeCreator;

    static{
        nodeCreator = NodeCreator.getInstance();
    }

    public Analizator(){}

    public Analizator(FileInputStream inputStream){
        this.XMLReader = new MyXMLReader(inputStream);
    }

    public Node next() throws IOException{

        String part;

        part = XMLReader.takePart();

        if(part == null){
            return null;
        }

        node = nodeCreator.create(part);

        return node;
    }
}
