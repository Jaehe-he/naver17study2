package day1213;

public class Ex6While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 65;
		while(a <= 90) {
			//System.out.printf("%c", a++); //결과 : ABCDEFGHIJKLMNOPQRSTUVWXYZ
			System.out.print((char)a++); //int a를 형변환을 해줌 charater로
		}
		
		System.out.println();
		char b='a';
		//do~while문을 이용해서 a부터 z까지 출력하시오
		do {
			System.out.print(b++);
		}while(b <= 'z'); //z대신 122로 적어도됨(아스킬코드로 z 숫자)
		
		System.out.println();
		int n=0;
		while(n<=10) {
			n++;
			if(n%2 ==0)
				continue; //조건식으로 이동 (while이나 do~while문에서)
			System.out.printf("%3d",n);
		}
	}

}
