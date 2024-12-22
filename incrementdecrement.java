public class incrementdecrement{
   public static void main( String[] args){
    int a=1;
    int b=2;
    int c;
    int d;
    c=++b;
    d=a++;
    c++;
    System.out.println("the value of a is:" + a);
    System.out.println("the value of b is:" + b);
    System.out.println("the value of c is:" + c);
    System.out.println("the value of d:" + d);
    int x=2;
    x+= x++ + ++x/2;
    System.out.println("the value of x is:" + x);
    int y=5;
    y+= --y+y--+--y;
    System.out.println("the value of y is:" + y);

   }

}
