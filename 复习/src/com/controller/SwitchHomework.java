package com.controller;

public class SwitchHomework {
    public static void main(String[] args) {
        //给出一个分数，判断分数是否合格，低于60为不合格（使用switch)
        int score=20;//可以缩小区间来计算判断，switch支持区间的合并
        switch ((score-60)/10){
            case 0,1,2,3,4:
                System.out.println("合格");
                break;
            default:
                System.out.println("不合格");
        }

    }
}
