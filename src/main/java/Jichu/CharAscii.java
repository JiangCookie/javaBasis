package Jichu;

import java.util.HashMap;

/**
 * @author JYH
 * 2018/10/7 11:18
 */
public class CharAscii {
    public static void main(String[] args) {
//        char m='a'+'b';
//        System.out.println(m);
//        char m1='a'+1;
//        int m2='a'+1;
//        System.out.println(m1);
//        System.out.println(m2);

        String kk = "hello";
        Object kk1 = "hello" ;
        System.out.println(kk.hashCode());
        System.out.println(kk1.hashCode());
        kk.notify();
    }


    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for(int i = 0; i < s.length() ; i ++){
            freq[s.charAt(i)-'a'] ++;
        }

        for(int i = 0; i < s.length() ; i ++){
            if(freq[s.charAt(i)-'a'] == 1){
                return i;
            }

        }
        return -1;
    }
}
