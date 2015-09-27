package com.example;

public class MyClass {

    public static  void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 6, 7, 56, 78, 45, 55};

        System.out.print(num.length + "\n" + "\n");

        for (int i = 0; i < num.length; i++) {

            System.out.print(num[i] + "\n");
        }
        sort(num, num.length);
        System.out.print("Values after sorting: \n");
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i] + "  ");
        }
    }
    private static void sort(int num[], int n) {
        for (int i = 1; i < n; i++){
            int j = i;
            int B = num[i];
            while ((j > 0) && (num[j-1] > B)){
                num[j] = num[j-1];
                j--;
            }
            num[j] = B;
        }
    }
 }
