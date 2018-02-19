package main.java.analizator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NodeCreator {

    private final String searchRequest = "(<([^?!][^<>]+)/>)|(</([^<>]+)>)|(<([^?!][^<>]+)>)|([^<>]+)";
    // code convention

    private Pattern searchPattern = Pattern.compile(searchRequest,Pattern.CASE_INSENSITIVE);
    // searchPattern - что конкретно он будет искать

    private static final NodeCreator instance = new NodeCreator();

    public static NodeCreator getInstance(){
        return instance;
    }

    public Node create(String data){

        TypeOfNode type = null;

        String name = null;

        Matcher matches = searchPattern.matcher(data);

        while(matches.find()) {
            if (matches.group(5) != null) {// поля должны быть проименованы, почему кто-то должен тратить время, опереляя, что ты там выделяшь пятыми скобками
                type = TypeOfNode.OPEN_TAG;
                name = matches.group(6);
            } else if (matches.group(3) != null) {
                type = TypeOfNode.CLOSE_TAG;
                name = matches.group(4);
            } else if (matches.group(1) != null) {
                type = TypeOfNode.WITHOUT_BODY;
                name = matches.group(2);
            } else if (matches.group(7) != null){
                type = TypeOfNode.TAG_BODY;
                name = matches.group(7);
            }
        }

        Node node = new Node(type,name);

        return node;
    }
}
