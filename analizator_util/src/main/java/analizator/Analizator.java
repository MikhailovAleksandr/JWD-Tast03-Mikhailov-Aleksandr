package main.java.analizator;//эм, а с чего вдруг такое название?

import main.java.analizator.util.MyReader;
import main.java.analizator.util.MyXMLReader;
import main.java.analizator.util.Node;
import main.java.analizator.util.NodeCreator;
import java.io.IOException;
import java.io.FileInputStream;

public class Analizator {// если судить по названию пакета - это у тебя главный явовский анализатор

    private MyReader XMLReader = null;//ну говорила же c My классы не называть, и что теперь?.....
    // XMLReader - с большой буквы, да и такое название используется для общеизвестного sax парсера
    
    private Node node = null;

    private static final NodeCreator nodeCreator;// а с чего это поле статическое?

    static{
        nodeCreator = NodeCreator.getInstance();// думай, прежде чем использовать шаблоны, особенно синглтон
        // на вижу тут необходимости его применять, а вот заметить свой Creator ты уже не сможешь без серьезного вмешательства в код
    }

    public Analizator(){}

    public Analizator(FileInputStream inputStream){
        this.XMLReader = new MyXMLReader(inputStream);//MyXMLReader - слов нет
    }

    public Node next() throws IOException{

        String part;// часть чего?

        part = XMLReader.takePart();

        if(part == null){
            return null;
        }

        node = nodeCreator.create(part);

        return node;
    }
}
