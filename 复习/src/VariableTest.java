public class VariableTest {
    public static void main(String[] args) {
      /*  float a=100;//这种是可以的，因为float容量比int大
        System.out.println(a);
        int b=100;
        byte c=10;
        long d=b+c;
        System.out.println(d);
        System.out.println("=================");
        byte num=127;
        System.out.println("输出num"+(++num));*/
        int i1=10;
        int i2=20;
        int i=i1++;
        System.out.println("i=="+i);
        System.out.println("i1=="+i1);
    }
}
