/*
 * You are choreographing a circus show with various animals. For one act,
 * you are given two kangaroos on a number line ready to jump in the
 * positive direction (i.e., toward positive infinity).
 *
 * The first kangaroo starts at location x1 and moves at a rate of v1
 * meters per jump.
 *
 * The second kangaroo starts at location x2 and moves at a rate of v2
 * meters per jump.
 *
 * You have to figure out a way to get both kangaroos at the same location
 * at the same time as part of the show.
 *
 * If it is possible, return "YES", otherwise return "NO".
 */

import java.util.*;

public class NumberLine {

    public static String kangaroo(int x1, int v1, int x2, int v2) {

        int v = v1 - v2;
        int x = x2 - x1;

        if (v != 0 && x % v == 0) 
        {

            int n = x / v;

            if (n >= 0) 
            {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        // Input: x1 v1 x2 v2
        int x1 = sc.nextInt();
        int v1 = sc.nextInt();
        int x2 = sc.nextInt();
        int v2 = sc.nextInt();

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);

        sc.close();
    }
}