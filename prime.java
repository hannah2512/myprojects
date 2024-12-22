import java.util.Scanner;

class prime {
    public static void main(String args[]){
        int i,a;
        Scanner obj =new Scanner(System.in);
        System.out.println("enter the number:");
        a=obj.nextInt();
        if(a<0){
            System.out.println("enter a positive number");
            System.exit(0);
        }
        boolean flag=true;
        for(i=2;i<a;i++){
            if(a%i==0)
            flag=false;
        }
        if(flag==true){
            System.out.println(a+ "is a prime number");
        }
        else{
            System.out.println(a+ "is not a prime number");
        }
    }
}
    