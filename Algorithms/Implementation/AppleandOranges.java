/*
===========================================================
IMPLEMENTATION - APPLES AND ORANGES - EASY
===========================================================

Problem:
Sam's house has an apple tree and an orange tree that yield
an abundance of fruit.

The apple tree is to the left of the house and the orange
tree is to the right.

The house occupies the inclusive range [s, t].

The apple tree is located at point a.
The orange tree is located at point b.

When a fruit falls from its tree, it lands d units of
distance from the tree of origin along the x-axis.

A negative value of d means the fruit falls to the left
of the tree, while a positive value means it falls to
the right.

Given the values of:
    - s : starting point of the house
    - t : ending point of the house
    - a : location of the apple tree
    - b : location of the orange tree
    - apples : distances at which apples fall
    - oranges : distances at which oranges fall

Determine how many apples and oranges fall on Sam's house.
*/

import java.util.*;

public class AppleAndOrange 
{

    public static void main(String[] args) 
    {
        int s = 7;
        int t = 10;

        int a = 4;
        int b = 12;

        int[] apples = {2, 3, -4};
        int[] oranges = {3, -2, -4};

        int appleCount = 0;
        int orangeCount = 0;

        for (int distance : apples) {

            int position = a + distance;

            if (position >= s && position <= t) {
                appleCount++;
            }
        }

        for (int distance : oranges) {

            int position = b + distance;

            if (position >= s && position <= t) {
                orangeCount++;
            }
        }

        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
}
