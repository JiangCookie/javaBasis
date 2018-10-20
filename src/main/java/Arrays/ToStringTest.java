package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author JYH
 * 2018/10/19 20:05
 */
public class ToStringTest {
    public static void main(String[] args) {
        int[] arr = {9,8,3,4};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        String[] ath = {"hello","world","Break","abc"};
        Arrays.sort(ath,String.CASE_INSENSITIVE_ORDER);
        Arrays.sort(ath, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareToIgnoreCase(o1);
            }
        });
        Arrays.sort(ath, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

        System.out.println(Arrays.toString(ath));

        int[][] att = new int[2][3];
        for (int i = 0; i < att.length; i++) {
            for (int j = 0; j < att[i].length; j++) {
                att[i][j] = i + j;
            }
        }
        System.out.println(Arrays.deepToString(att));

        int[] amm = {3,5,7,13,21};
        System.out.println(Arrays.binarySearch(amm,13));
    }
}
