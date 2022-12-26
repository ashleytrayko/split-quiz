package org.example;

import com.google.common.base.Splitter;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitMethod {
    public String[] splitMethod1 (String input){
        // ("가 앞에 존재한다면 false),("가 뒤에 존재한다면 false)
//        String answer[] = input.split("(?<!\\\"\\w),(?!\\w\\\")");

        // ""가 없거나 복수인 ,를 찾아 자르기
        String answer[] = input.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//        String answer[] = input.split("(?!\B(\"|“|”)[^(\"|“|”)]*),(?![^(\"|“|”)]*(\"|“|”)\B)");
        return answer;
    }

    public List<String> splitMethod2 (String input){
        List<String> answer = new ArrayList<>();
        String result = "";
        int startPosition = 0;
        boolean isInQuotes = false;
        for(int currentPosition = 0; currentPosition < input.length(); currentPosition++){
            if (input.charAt(currentPosition) == '\"') {
                isInQuotes = !isInQuotes;
            }
            else if (input.charAt(currentPosition) == ',' && !isInQuotes) {
                answer.add(input.substring(startPosition, currentPosition));
                startPosition = currentPosition + 1;
            }
        }

        String lastToken = input.substring(startPosition);
        if (lastToken.equals(",")) {
            answer.add("");
        } else {
            answer.add(lastToken);
        }

        return answer;
    }
    public List<String> splitMethod3 (String input){
        Pattern pattern = Pattern.compile("\",(?!\\s)\"");
        Splitter splitter = Splitter.on(pattern);
        List<String> answers = splitter.splitToList(input);
        return answers;
    }

    public List<String[]> splitMethod4(String input){
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .build();
        CSVReader reader = new CSVReaderBuilder(new StringReader(input))
                .withCSVParser(parser)
                .build();
        List<String[]> list = new ArrayList<>();
        try {
            list = reader.readAll();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
