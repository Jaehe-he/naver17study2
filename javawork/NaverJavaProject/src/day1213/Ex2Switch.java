package day1213;

import java.util.Scanner;

public class Ex2Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		char ch;
		
//		System.out.println("알파벳 한글자 입력");
//		ch=sc.nextLine().charAt(0); //입력한 문자열 중 첫글자를 char 타입으로 반환 // nextLine의 반환타입 : String
//		
//		switch(ch)
//		{
//		case 'a': //현재 case에는 break가 없기 때문에 다음 명령어 실행됨
//		case 'A':
//			System.out.println("Apple");
//			break;
//		case 'b':
//		case 'B':
//			System.out.println("Banana");
//		case 'c':
//		case 'C':
//			System.out.println("Computer");
//			break;
//		default:
//			System.out.println("a,b,c가 아닌 알파벳");
//		}
		
		System.out.println("영어 단어를 입력해주세요");
		String msg = sc.nextLine();
		
		//jdk8 이후로는 case 에서 문자열도 가능해졌다.
		switch(msg) {
		case "red":
		case "RED":
			System.out.println("빨간색");
			break;
		case "green":
		case "GREEN":
			System.out.println("초록색");
			break;
		default:
			System.out.println("빨강과 초록을 제외한 색상");
		}
	}
}
