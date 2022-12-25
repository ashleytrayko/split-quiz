package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitMethod {
    public String[] splitMethod1 (String input){
        // ("가 앞에 존재한다면 false),("가 뒤에 존재한다면 false)
        String answer[] = input.split("(?<!\\\"\\w),(?!\\w\\\")");
        return answer;
    }
}
