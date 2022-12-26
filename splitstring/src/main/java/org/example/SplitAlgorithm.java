package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1번 캐릭터가 !" -> n부터 다음 , 까지 자름
// 1번 캐릭터가 " ->"부터 다음,의 직전의 "까지 자름
// subString으로 해보기

public class SplitAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = "";
        while(!txt.equals("kill")){
            txt = sc.nextLine();
//        String txt = "aaaa,bbbb,\"cc,c\"c\",dd\"ee,f,gg,,ijk,\"l,m\",n";
            String arrays[] = txt.split(",");
            List<String> lists = new ArrayList<>();
            for(int i = 0; i < arrays.length; i++){
                if(!arrays[i].startsWith("\"")){
                    lists.add(arrays[i]);
                } else if (arrays[i] == "") {
                    lists.add(arrays[i]);
                } else{
                    String oddString = arrays[i];
                    for(int j = i + 1; j < arrays.length; j++){
                        if(!arrays[j].endsWith("\"")){
                            if(j != arrays.length - 1){
                                oddString = oddString + "," + arrays[j];
                            }else {
                                oddString = oddString + "," + arrays[j];
                                lists.add(oddString);
                                i = j;
                                break;
                            }
                        }else{
                            oddString = oddString + "," + arrays[j];
                            lists.add(oddString);
                            i = j;
                            break;
                        }
                    }
                }
            }
            System.out.println(lists.size() + "개");
            for(String list : lists){
                System.out.println(list);
            }
        }
    }
}
