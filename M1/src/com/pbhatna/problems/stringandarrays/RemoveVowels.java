package com.pbhatna.problems.stringandarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveVowels {

    public static void main(String []args) {
        System.out.println(solve1("   wisss shram "));
        System.out.println(solve2("   wisss shram "));
    }

    public static String solve1 (String str) {
        Character vowels[] = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};
        List<Character> arrayList = Arrays.asList(vowels);
        StringBuffer sb = new StringBuffer(str);

        for (int i = 0; i < sb.length(); i++) {
            if(arrayList.contains(sb.charAt(i))){
                System.out.println(""+sb.charAt(i));
                sb.replace(i, i+1, "") ;
                i--;
            }
        }
        return sb.toString().trim();
    }

    public static String solve2 (String str) {
        return str.replaceAll("[aeiouAEIOU]", "").trim();
    }
}
