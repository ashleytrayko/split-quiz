package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //String txt = "aaaa,bbbb,\"cc,c\"c\",dd\"ee,f,gg,,ijk,\"l,m\",n";
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        // Split(정규표현식)사용

        SplitMethod split = new SplitMethod();
        while(flag){
            String input = sc.nextLine();
            if(input.equals("kill")){
                flag = false;
            }
            String answer[] = split.splitMethod1(input);
            System.out.println(answer.length + "개");
            for(int i = 0; i < answer.length; i++){
                System.out.println("answer " + i + " : " + answer[i]);
            }
        }

        // 반복문 사용

//        SplitMethod splitMethod2 = new SplitMethod();
//         while (flag){
//             String input = sc.nextLine();
//              if(input.equals("kill")){
//                  flag = false;
//              }
//              List<String> answer = splitMethod2.splitMethod2(input);
//              System.out.println(answer.size());
//              for(int i = 0; i < answer.size(); i++){
//                    System.out.println("answer " + i + " : " + answer.get(i));
//              }
//         }
        
        
        //CSV라이브러리 사용
//        SplitMethod splitMethod = new SplitMethod();
//        while (flag) {
//            String input = sc.nextLine();
//            if (input.equals("kill")) {
//                flag = false;
//            }
//            List<String[]> answers = splitMethod.splitMethod4(input);
//            int listIndex = 0;
//            for (String[] answer : answers) {
//                System.out.println(answer.length + "개");
//                System.out.println("\nString[" + listIndex++ + "] : " + Arrays.toString(answer));
//
//                int index = 0;
//                for (String array : answer) {
//                    System.out.println(index++ + " : " + array);
//                }
//            }
//        }
    }

}