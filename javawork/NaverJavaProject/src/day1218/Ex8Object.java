package day1218;


class Orange{
	public static final String MESSAGE="Happy";
	
	
	private String name;
	private int age;
	
	public void showData() {
		//일반 멤버 메서드는 this라는 인스턴스 변수를 가지고 있다
		//static 멤버 메서드에는 this가 없음
		//그래서 this.name 이런식으로 접근 가능(this는 경우에 따라 생략 가능)
		System.out.println("이름:"+this.name+",나이:"+this.age);
	}
	
	//값을 변경하기 위한 setter method를 만들어보자
	public void setName(String name) {
		//같은 구역에 멤버와 같은 이름의 변수가 있을 경우
		//멤버 변수 앞에 반드시 this를 붙인다. (구분하기 위해)
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

public class Ex8Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Orange.MESSAGE); //MESSAGE는 public이기 때문에 값 변경은 못해도 가져오는건 할 수 있음
		
		Orange orange = new Orange();
//		System.out.println(orange.name); //오류 : private 변수는 직접 접근 불가
	
		orange.showData(); //string은 초기값 null / int는 초기값 0
		System.out.println("값 변경");
		orange.setName("김태희");
		orange.setAge(35);
		
		orange.showData();
	}
}
