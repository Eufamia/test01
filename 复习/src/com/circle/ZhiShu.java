package com.circle;

public class ZhiShu {
    public static void main(String[] args) {
        boolean flag=true;
        int count=0;
        long start=System.currentTimeMillis();
        for (int i = 2; i <= 100000; i++) {
            //for (int j=2;j<i;j++){
            for (int j=2;j<=Math.sqrt(i);j++){//这个带来的效率也是惊人的
                if(i%j==0){
                    flag=false;
                    break;//97
                }
            }
            if (flag==true){
                System.out.println(i);
                count++;
            }
            flag=true;
        }
        long end=System.currentTimeMillis();
        System.out.println(count);
        System.out.println("程序执行时间:"+(end-start));//48

        /*不输出：15
        * 同时不break:97
        * 同时j<i:16963 break 1545*/
    }
}
