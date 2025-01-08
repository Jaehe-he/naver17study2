package day0107db;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex2 extends JFrame {
	JButton btnFoodResAdd;
	
    public Ex2() {
        super("창 제목"); // 창의 제목 설정
        this.setSize(400, 300); // 창 크기 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정
        this.setVisible(true); // 창을 화면에 표시
    }
    
    public void initDesign() {
    	JPanel p1 = new JPanel();
    	p1.setBackground(Color.LIGHT_GRAY);
    	btnFoodResAdd = new JButton("메뉴등록");
    	
    	p1.add(new JLabel("메뉴명"));
    }

    public static void main(String[] args) {
        Ex2 ex = new Ex2();
    }
}
