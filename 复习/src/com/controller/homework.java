package com.controller;

import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入狗的年龄：");
        int age=scanner.nextInt();
        if(age<=2){
            System.out.println("狗的年龄相当于人类的"+(age*10.5)+"岁");
        }else {
            System.out.println("狗的年龄相当于人类的"+(2*10.5+(age-2)*4)+"岁");
        }
    }
}
