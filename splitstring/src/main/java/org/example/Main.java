package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String txt = "aaaa,bbbb,\"cc,c\"c\",dd\"ee,f,gg,,ijk,\"l,m\",n";
        String result = "";
        char previousChar = ' ';
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == ',') {
                if(previousChar == '\"'){
                    answer.add(result);
                    result = "";
                    continue;
                }
                answer.add(result);
                result = "";
                continue;
            }
            result += txt.charAt(i);
            previousChar = txt.charAt(i);
            if(txt.length() -1 == i){
                answer.add(result);
            }
        }
        System.out.println(answer);

    }
}