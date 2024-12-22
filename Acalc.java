import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        char operator;
        Double number1,number2,result;
        Scanner input=new Scanner(System.in);
        System.out.println("choose an opertor: +,-,*,or/");
        operator=input.next().charAt(0);
        System.out.println("enter first number:");
        number1=input.nextDouble();
        System.out.println("enter second number:");
        number2=input.nextDouble();
        switch(operator)
        {
            case '+': result = number1 + number2;
            System.out.println(number1 + "+" +number2 + "=" + result);
            break;
            case '-' : result = number1 - number2;
            System.out.println(number1 + "-" + number2 + "=" + result);
            case '/': result = number1 / number2;
            System.out.println(number1 + "/" + number2 + "=" + result);
            case '*': result = number1 * number2;
            System.out.println(number1 + "*" + number2 + "=" + result);
            default:
            System.out.println("enter valid operand");
        input.close();







        }
    }
}
