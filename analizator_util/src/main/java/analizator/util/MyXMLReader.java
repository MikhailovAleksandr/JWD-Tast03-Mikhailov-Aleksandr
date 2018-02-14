package main.java.analizator.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyXMLReader implements AutoCloseable, MyReader{

    private int endOfFileIndicator = 0;

    private String XMLDataPart = "";

    private BufferedReader XMLreader = null;

    private static final XMLDataParser dataParser;

    private List<String> nodes = new ArrayList<>();

    static{
        dataParser = XMLDataParser.getInstance();
    }

    public MyXMLReader(){}

    public MyXMLReader(InputStream inputStream){
        XMLreader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public String takePart() throws IOException{

        int countOfSymbols = 0;

        char[] XMLDataBuffer = new char[200];

        if(!nodes.isEmpty()){
            nodes.remove(0);
        }

        if(!nodes.isEmpty()) {
            return nodes.get(0);
        }

        if(endOfFileIndicator == -1){
            return null;
        }

        endOfFileIndicator = XMLreader.read(XMLDataBuffer, 0,100);

        XMLDataPart += String.valueOf(XMLDataBuffer).trim();

        nodes = dataParser.parse(XMLDataPart);

        if(nodes.isEmpty()) {
            return null;
        }

        for (String node : nodes) {
            countOfSymbols += node.length();
        }

        XMLDataPart = XMLDataPart.substring(countOfSymbols).trim();

        return nodes.get(0);
    }

    @Override
    public void close() throws IOException {
        if(XMLreader != null){
            XMLreader.close();
        }
    }
}
