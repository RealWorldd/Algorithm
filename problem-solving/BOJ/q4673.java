import java.util.TreeSet;

class q4673 {
    public static void main(String[] args) {
        TreeSet<Integer> list = new TreeSet<>();
        for (int i = 1; i < 10000; i++) {
            String numberStr = Integer.toString(i);
            int num = 0;
            for (int j = 0; j < numberStr.length(); j++) {
                int digit = Character.getNumericValue(numberStr.charAt(j));
                num += digit;
            }
            if (i + num <= 10000) {
                list.add(i + num);
            }
        }
        for (int i = 1; i <= 10000; i++) {
            if(!list.contains(i)) System.out.println(i);
        }
    }
}