package day1213;

import java.util.Scanner;

public class Ex12For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
	 * 문제1
	 * 숫자 n을 입력하면 1부터 n까지의 합계를 구하시오
	 * (for문 사용할 것)
	*/
		
		
	Scanner sc = new Scanner(System.in);
	int sum = 0;
	System.out.print("n 입력 : ");
	int n = sc.nextInt();
	
	for(int i = 1; i <= n; i++) {
		sum += i;
		}
	System.out.printf("1부터 n까지의 합계 : %d", sum);
	}

}
