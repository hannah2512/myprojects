import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Check for a string palindrome
        System.out.print("Enter a string to check if it's a palindrome: ");
        String inputString = scanner.nextLine();
        if (isPalindromeString(inputString)) {
            System.out.println("The string \"" + inputString + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + inputString + "\" is not a palindrome.");
        }

        // Check for a numeric palindrome
        System.out.print("Enter a number to check if it's a palindrome: ");
        int number = scanner.nextInt();
        if (isPalindromeNumber(number)) {
            System.out.println("The number " + number + " is a palindrome.");
        } else {
            System.out.println("The number " + number + " is not a palindrome.");
        }
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindromeString(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to check if a number is a palindrome
    public static boolean isPalindromeNumber(int num) {
        int originalNumber = num;
        int reversedNumber = 0;

        while (num > 0) {
            int digit = num % 10;
            reversedNumber = reversedNumber * 10 + digit;
            num /= 10;
        }
        return originalNumber == reversedNumber;
    }
}
