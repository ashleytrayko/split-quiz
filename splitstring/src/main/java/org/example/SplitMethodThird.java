package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitMethodThird {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = "";
        while (true){
            txt = sc.nextLine();
            if(txt.equals("kill")){
                break;
            }
//            txt = "aaaa,bbbb,\"cc,c\"c\",dd\"ee,f,gg,,ijk,\"l,m\",n";
            String arrays[] = txt.split("\\s*,\\s*", -1);           // , 주변 공백 없애기
            List<String> lists = new ArrayList<>();
            for(int i = 0; i < arrays.length; i++){
                if(!arrays[i].startsWith("\"")){                                // 단어가 "로 시작하지 않는 경우
                    lists.add(arrays[i]);
                } else if (i == arrays.length - 1) {
                    lists.add(arrays[i]);
                } else {                                                        // 단어가 "로 시작하는 경우
                    String oddString = arrays[i];
                    for(int j = i + 1; j < arrays.length; j++){
                        if(!arrays[j].endsWith("\"")){                          // 다음 단어가 "로 끝나지 않는 경우
                            if(j == arrays.length - 1){                         // 배열의 끝이면 리스트에 추가
                                oddString = oddString + "," + arrays[j];
                                lists.add(oddString);
                                i = j;
                                break;
                            } else {                                            // 아니면 계속 더해나감
                                oddString = oddString + "," + arrays[j];
                            }
                        }else{                                                  // 다음 단어가 "로 끝나는 경우
                            oddString = oddString + "," + arrays[j];
                            lists.add(oddString);
                            i = j;
                            break;
                        }
                    }
                }
            }
            for(String array : arrays){
                System.out.println(array);
            }
            System.out.println("--------------최종답안----------------");
            System.out.println(lists.size() + "개");
            for(String list : lists){
                System.out.println(list);
            }

        }
    }
}
