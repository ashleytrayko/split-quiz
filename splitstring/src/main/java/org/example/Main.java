package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //String txt = "aaaa,bbbb,\"cc,c\"c\",dd\"ee,f,gg,,ijk,\"l,m\",n";
        Scanner sc = new Scanner(System.in);
        SplitMethod split = new SplitMethod();
        String input = sc.nextLine();
        String answer[] = split.splitMethod1(input);
        System.out.println(answer.length + "개");
        for(int i = 0; i < answer.length; i++){
            System.out.println("answer" + i + " : " + answer[i]);
        }




    }
//        String result = "";
//        char previousChar = ' ';
//        ArrayList<String> answer = new ArrayList<>();
//        for (int i = 0; i < txt.length(); i++) {
//            if (txt.charAt(i) == ',') {
//                if(previousChar == '\"'){
//                    answer.add(result);
//                    result = "";
//                    continue;
//                }
//                answer.add(result);
//                result = "";
//                continue;
//            }
//            result += txt.charAt(i);
//            previousChar = txt.charAt(i);
//            if(txt.length() -1 == i){
//                answer.add(result);
//            }
//        }
//        System.out.println(answer);
//
//    }

}