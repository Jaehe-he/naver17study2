package day0106db;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex2ShopTable extends JFrame {
	JTextField tfSang, tfSu, tfDan;
	JButton btnAdd, btnDel, btnUpdate;
	DefaultTableModel tableModel;
	JTable table;
	
	ShopModel shopModel = new ShopModel(); //shop DB 데이터 관리할 클래스
	
	public Ex2ShopTable() {
		// TODO Auto-generated constructor stub
		super("shop 관리"); //부모생성자 호출(JFrame)
		this.setBounds(300, 100, 400, 400); //시작위치와 프레임 크기 설정
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 클릭시 종료
		this.setVisible(true);
	}
	
	public void initDesign() {
		JPanel p1 = new JPanel();
		p1.add(new JLabel("상품명"));
		tfSang = new JTextField(6);
		tfSu = new JTextField(3);
		tfDan = new JTextField(6);
		
		p1.add(new JLabel("상품명"));
		p1.add(tfSang);
		
		p1.add(new JLabel("단가"));
		p1.add(tfDan);

		p1.add(new JLabel("수량"));
		p1.add(tfSu);
		
		//p1 panel frame 상단에 추가하가ㅣ
		this.add("North", p1);
		
		//frame 중간에 table 넣기
		String []title = {"인덱스", "상품명", "수량", "단가", " 총 금액", "입고일"};
		tableModel = new DefaultTableModel(title, 0); //제목과 데이터는 0개로 생성
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table)); //제목과 스크롤이 보이도록 추가
	
		//하단에는 버튼 3개
		btnAdd = new JButton("상품추가");
		btnDel = new JButton("상품삭제");
		btnUpdate = new JButton("상품수정");
		
		JPanel p2 = new JPanel();
		p2.add(btnAdd);
		p2.add(btnDel);
		p2.add(btnUpdate);
		this.add("South", p2);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2ShopTable ex2 = new Ex2ShopTable();
	}

}
