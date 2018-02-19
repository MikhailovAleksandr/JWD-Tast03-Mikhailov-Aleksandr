package main.java.analizator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class XMLDataParser {

    private final String searchRequest = "(<([^<>]+)/>)|(</([^<>]+)>)|(<([^<>]+)>)|((<|</)[^[(</)]<>]+$)|([^[</]<>]+)";

    private Pattern searchPattern = Pattern.compile(searchRequest,Pattern.CASE_INSENSITIVE);

    private static final XMLDataParser instance = new XMLDataParser();

    public static XMLDataParser getInstance(){
        return instance;
    }

    public List<String> parse(String dataPart) {// parse  - нестандартый для xml метод - мне из названия надо понить, что за лист стрингов я получу

        List<String> nodes = new ArrayList<>();

        Matcher matches = searchPattern.matcher(dataPart);

        while (matches.find()) {

            if (matches.group() != null && matches.group(7) == null) {
                nodes.add(matches.group());
            }
        }
        return nodes;
    }
}
