package day1218;

import java.text.NumberFormat;

public class Ex10Object {

	public static void showTitle() {
		System.out.println("번호\t자동차명\t가격");
		System.out.println("=".repeat(30));
	}
	
	public static void writeCar(int num, Car myCar) {
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println(num+"\t"+myCar.getCarName()+"\t\t"+nf.format(myCar.getCarPrice())+"만원");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체 배열
		Car []cars = new Car[5]; //배열(메모리) 할당 시 객체는 생성된 값이 들어가는게 아닌 무조건 초기값이 null => 메서드를 호출할 수 있는 상태가 아님
		//배열 5개의 각 Car 객체는 따로 생성해줘야함
		for(int i=0;i<cars.length;i++)
			cars[i] = new Car(); //인스턴스 생성(값을 넣을 수 있는 단계)
		
		cars[0].setData("그랜져",5600); //null인 상태에서 메서드 호출하면 NullPointerException 오류 발생
		cars[1].setData("아반떼",4600);
		cars[2].setData("모닝",2300);
		cars[3].setData("미니",4900);
		cars[4].setData("아우디",6700);
		
		//제목부터 출력
		showTitle();
		
		//방법1. 내용 출력
		for(int i=0;i<cars.length;i++) {
			writeCar(i+1, cars[i]);
		}
		System.out.println();
		
		//방법 2.다른방법으로 출력
		int n=0;
		for(Car car: cars) {
			writeCar(++n, car);
		}
	}

}
