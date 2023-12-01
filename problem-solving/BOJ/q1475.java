import java.util.*;

class q1475 {
    static String n;
    static int[] numbers = new int[9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLine();
        
        for(int i = 0; i < n.length(); i++) {
            if(n.charAt(i) == '9') {
                numbers[6]++;
                continue;
            }
            numbers[Character.getNumericValue(n.charAt(i))]++;
        }
        
        int res = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(i == 6 && numbers[i] % 2 == 0) {
                res = Math.max(res, numbers[i] / 2);
                continue;
            }
            if(i == 6 && numbers[i] % 2 == 1) {
                res = Math.max(res, numbers[i] / 2 + 1);
                continue;
            }
            res = Math.max(res, numbers[i]);
        }

        System.out.println(res);
    }
}