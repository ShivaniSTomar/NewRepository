package core;

import java.util.Scanner;

public class ReverseDigits {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int number = scanner.nextInt();
		int reversedNumber = reverseDigits(number);
		System.out.println("Original number: " + number);
		System.out.println("Reversed number: " + reversedNumber);
		scanner.close();
	}

	public static int reverseDigits(int num) {
		int reversedNum = 0;
		while (num != 0) {
			int digit = num % 10;
			reversedNum = reversedNum * 10 + digit;
			num /= 10;
		}
		return reversedNum;
	}
}
