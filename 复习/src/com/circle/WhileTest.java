package com.circle;

import java.util.Scanner;

public class WhileTest {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int countJ=0;
        int countO=0;
        while (true){
            System.out.println("请输入一个整数：（当输入为0时程序自动结束）");
            int num=scan.nextInt();
            if (num==0){
                break;
            }
            if (num % 2 == 0) {
                countO++;
            } else {
                countJ++;
            }
        }
        System.out.println("奇数的个数是："+countJ+"，偶数的个数是："+countO);
    }
}
