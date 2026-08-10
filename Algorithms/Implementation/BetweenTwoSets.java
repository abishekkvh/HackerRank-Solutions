/*
 * Between Two Sets
 * 
 * There will be two arrays of integers. Determine all integers that satisfy
 * the following two conditions:
 * 1. The elements of the first array are all factors of the integer being considered.
 * 2. The integer being considered is a factor of all elements of the second array.
 * 
 * These numbers are referred to as being between the two sets.
 * Determine how many such numbers exist.
 */

import java.util.*;

public class BetweenTwoSets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        if (a == null || a.isEmpty() || b == null || b.isEmpty()) {
            return 0;
        }

        // Find LCM of all elements in a
        int lcm = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            lcm = lcm(lcm, a.get(i));
        }

        // Find GCD of all elements in b
        int gcd = b.get(0);
        for (int i = 1; i < b.size(); i++) {
            gcd = gcd(gcd, b.get(i));
        }

        // Count multiples of LCM that divide GCD
        int count = 0;
        for (int x = lcm; x <= gcd; x += lcm) {
            if (gcd % x == 0) {
                count++;
            }
        }

        return count;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            List<Integer> brr = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                brr.add(sc.nextInt());
            }

            int total = getTotalX(arr, brr);
            System.out.println(total);
        }

        sc.close();
    }
}
