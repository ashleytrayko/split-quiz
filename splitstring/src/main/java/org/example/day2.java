package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day2 {
    static int currentI =0;
    public String sum(int index , String str, String[] arr,String basic){
        String madeStr = str;
        boolean isComma = true;
        for(int i = index; i < arr.length; i++){
            if(arr[i].endsWith("\"")){
                currentI=i;
                madeStr+=","+arr[i];
                isComma=false;
                break;
            }else{
                madeStr+=","+arr[i];
            }
        }
        if(isComma) {
            return basic;
        }else{
            return madeStr;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        String arrays[] = txt.split(",");
        day2 d = new day2();
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i<arrays.length;i++){
            String str = arrays[i];
            if(arrays[i].startsWith("\"")){
               if(arrays[i].endsWith("\"")){
                   list.add(str);
                   str="";
               }else{
                   if(i== arrays.length-1){
                       list.add(str);
                   }else{
                       str = d.sum(i+1, str, arrays, str);
                       list.add(str);
                       str="";
                       i=currentI;
                   }
               }
            }else{
                list.add(str);
                str="";
            }
        }
        System.out.println(list.size() + "개");
        System.out.println(list);
    }
}
