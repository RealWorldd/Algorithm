package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class q20310 {
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        char[] chars = s.toCharArray();
        int zeroCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(chars[i] == '0') zeroCount++;
        }
        Arrays.sort(chars);
        char[] res = new char[s.length() / 2];
        for (int i = 0; i < zeroCount / 2; i++) {
            res[i] = '0';
        }
        for (int i = zeroCount / 2; i < res.length; i++) {
            res[i] = '1';
        }
        for (char i : res) {
            System.out.print(i);
        }
    }
}