package day1226;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex6TableCRUD extends JFrame {
	static final String FILENAME="c:/naver1210/student.txt";
	JTable table;
	List<Student> list = new ArrayList<Student>();
	DefaultTableModel tableModel; //추가, 삭제 등의 메서드를 갖고 있는 클래스모델
	JTextField tfName, tfKor, tfEng;
	JButton btnAdd;
	

	public Ex6TableCRUD() {
		//TODO Auto-generated constructor stub
		super("학생관리");
		this.setBounds(300, 100, 400, 400);
		
		this.initDesign();
		this.setVisible(true);
	
		//윈도우 x버튼 클릭 시 이벤트를 발생시켜서 파일을 저장한다
		this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			//TODO Auto-generated method stub
			// list의 내용을 파일에 저장한다.
			saveFile();
			//프로그램 종료
			System.exit(0);
			
			super.windowClosing(e);
		}
		
		}); //인터페이스
	}
	
	public void studentFileRead() {
		//파일을 읽어서 list 변수에 담기
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			while(true) {
				String studentInfo = br.readLine();
				if(studentInfo ==null)
					break;
				
				String []s = studentInfo.split("\\|");
				Student student = new Student();
				student.setName(s[0]);
				student.setKor(Integer.parseInt(s[1]));
				student.setEng(Integer.parseInt(s[2]));
				student.setSum(Integer.parseInt(s[3]));
				student.setAvg(Double.parseDouble(s[4]));
				
				list.add(student);
			}
			System.out.println("총 " + list.size() + "명 읽음");
		} catch(FileNotFoundException e) {
			System.out.println("저장된 정보가 없습니다.");
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch(IOException|NullPointerException e) {
				
			}
		}
	}
	
	public void initDesign() {
		//파일을 읽어온다
		this.studentFileRead();
		
		//테이블을 생성해서 center에 추가
		String []title = {"이름", "국어", "영어", "총점", "평균"};
		tableModel = new DefaultTableModel(title, 0); //일단 행갯수는 0으로 생성
		table = new JTable(tableModel);
		//frame에 추가
		this.add("Center", new JScrollPane(table));
		
		//입력부분 디자인
		JPanel panel = new JPanel();
		tfName = new JTextField(5);
		tfKor = new JTextField(4);
		tfEng = new JTextField(4);
		
		btnAdd = new JButton("추가");
		
		//panel에 각 컴포넌트들 추가
		panel.add(new JLabel("이름"));
		panel.add(tfName);
		panel.add(new JLabel("국어"));
		panel.add(tfKor);
		panel.add(new JLabel("영어"));
		panel.add(tfEng);
		panel.add(btnAdd);
		
		//frame에 panel을 상단에 추가하자
		this.add("North",panel);
	}
	
	public void saveFile() {
		//List의 내용을 파일에 저장한다
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex6TableCRUD();
	}

}
