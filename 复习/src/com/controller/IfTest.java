package com.controller;

public class IfTest {
    public static void main(String[] args) {
        int x=10;
        int y=2;
        if(x>4)
            if(y>2)
                System.out.println(x+y);
            else//两个if都不加大括号的前提下，有一个就近原则
                System.out.println("x is "+x);//输出结果是x is 10
    }
}
