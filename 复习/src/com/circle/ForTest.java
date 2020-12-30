package com.circle;

public class ForTest {
    public static void main(String[] args) {
        int m=12;
        int n=20;
        int yinZi=1;
      /*  for (int i = 2; i <(m<n?m:n) ; i++) {
            if (m%i==0 && n%i==0){
                yinZi=i;//效率不高，会循环一遍
            }
        }*/
        int min=m<n?m:n;
        for (int i = min; i >1 ; i--) {
            if (m%i==0 && n%i==0){
                yinZi=i;//效率不高，会循环一遍
                break;//一旦在循环中执行到break,就跳出循环
            }
        }
        System.out.println(yinZi);
    }

}
