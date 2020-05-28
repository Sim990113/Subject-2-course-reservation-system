package Design;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class login_face extends JFrame implements ActionListener{ 
	JButton button1,button2,button3,button4,
	button5,button6,button7,button8,button9,
	buttonbefore,buttonafter,logout1,logout2,logout3,logout4;
	JTabbedPane choose;
	JPanel panel1,panel2,panel3,panel4;
	JLabel label1,label2,label3,myname,mysex,myphone,mypwd;
	JTextArea text;
	public String cour;
	public String info[]=new String[4];
	int year,month,day,week,xueshi;
	Calendar cal=Calendar.getInstance();
	
	
	login_face() throws IOException{
		week=cal.get(Calendar.DAY_OF_WEEK)-1;
		if(week==0) {
			week=7;
		}
		year=cal.get(Calendar.YEAR);
		month=cal.get(Calendar.MONTH)+1;
		day=cal.get(Calendar.DATE);
		
		
		label1=new JLabel("��Ŀ���γ�");
		label1.setFont(new Font("����",Font.PLAIN,20));
		label2=new JLabel(""+year+"-"+month+"-"+day+" ��"+week+"");
		label2.setFont(new Font("����",Font.PLAIN,16));
		
		FileInputStream account = new FileInputStream("C:\\Users\\��\\Desktop\\�˺�\\"+log.NAME1+".txt");//��������Ϣ��ȡ��д���ҵ���Ϣ�У�
		BufferedReader br = new BufferedReader(new InputStreamReader(account));
		
		String line=null;
		int a=0;
		int i=0;
		while ((line = br.readLine())!=null) {
			info[i]=line;
			a++;
			i++;
			if(a>3) {
				break;
			}
			if(a<=3) {
				continue;
			}
			
			
		}
		
		br.close();
		myname=new JLabel("������    "+info[0]);
		myname.setFont(new Font("����",Font.PLAIN,20));
		mysex=new JLabel("�Ա�    "+info[1]);
		mysex.setFont(new Font("����",Font.PLAIN,20));
		myphone=new JLabel("�ֻ����룺"+info[2]);
		myphone.setFont(new Font("����",Font.PLAIN,20));
		mypwd=new JLabel("���룺    "+info[3]);
		mypwd.setFont(new Font("����",Font.PLAIN,20));
		
		
		
		FileInputStream cours = new FileInputStream("C:\\Users\\��\\Desktop\\�˺�\\"+log.NAME1+".txt");//����γ���Ϣ
		BufferedReader pr = new BufferedReader(new InputStreamReader(cours));
		
		String line1=null;
		StringBuffer buf = new StringBuffer();
		int b=0;
		while ((line1 = pr.readLine())!=null) {
			b++;
			if(b<5) {
				continue;
			}
			buf.append(line1+"\r\n");
			
		}
		pr.close();
		
		cour=buf.toString();
		xueshi=search(cour,"��Ŀ��");
		text=new JTextArea(cour);
		text.setFont(new Font("����",Font.PLAIN,22));
		text.setEnabled(false);
		
		
		label3=new JLabel("<html>����ǰ��ѧʱΪ:"+xueshi+"ѧʱ</html>");
		label3.setFont(new Font("����",Font.PLAIN,20));
		
		update();
		
		
		
		panel1=new JPanel();
		panel1.setBackground(Color.white);
		panel2=new JPanel();
		panel2.setBackground(Color.white);
		panel3=new JPanel();
		panel3.setBackground(Color.white);
		panel4=new JPanel();
		panel4.setBackground(Color.white);
		choose=new JTabbedPane();
		
		logout1=new JButton("ע��");
		logout1.setForeground(Color.red);
		logout2=new JButton("ע��");
		logout2.setForeground(Color.red);
		logout3=new JButton("ע��");
		logout3.setForeground(Color.red);
		logout4=new JButton("ע��");
		logout4.setForeground(Color.red);
		
		
		choose.add("ԤԼ�γ�",panel1);
		choose.add("��ѯ��ʱ",panel2);
		choose.add("�ҵ���Ϣ",panel3);
		choose.add("�ҵĿγ�",panel4);
		
		panel1.setLayout(null);
		panel2.setLayout(null);
		panel3.setLayout(null);
		panel4.setLayout(null);
		
		button1 = new JButton("<html>��XX123ѧ<br>08:00-09:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
		button2 = new JButton("<html>��XX123ѧ<br>09:00-10:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
		button3 = new JButton("<html>��XX123ѧ<br>10:00-11:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
		button4 = new JButton("<html>��XX123ѧ<br>11:00-12:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
		button5 = new JButton("<html>��XX123ѧ<br>13:00-14:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
		button6 = new JButton("<html>��XX123ѧ<br>14:00-15:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
		button7 = new JButton("<html>��XX123ѧ<br>15:00-16:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
		button8 = new JButton("<html>��XX123ѧ<br>16:00-17:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
		button9 = new JButton("<html>��XX123ѧ<br>17:00-18:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
		buttonbefore = new JButton("<ǰһ��");
		buttonafter = new JButton("��һ��>");
		
		
		
		
		label1.setBounds(250,20, 200, 50);
		label2.setBounds(250,60, 200, 100);
		label3.setBounds(200,200, 250, 100);
		myname.setBounds(200, 0, 600, 150);
		mysex.setBounds(200, 150, 600, 150);
		myphone.setBounds(200, 300, 600, 150);
		mypwd.setBounds(200, 450, 600, 150);
		
		
		
		button1.setBounds(42,150,172,150);
		button2.setBounds(214,150,172,150);
		button3.setBounds(386,150,172,150);
		button4.setBounds(42,300,172,150);
		button5.setBounds(214,300,172,150);
		button6.setBounds(386,300,172,150);
		button7.setBounds(42,450,172,150);
		button8.setBounds(214,450,172,150);
		button9.setBounds(386,450,172,150);
		buttonbefore.setBounds(115,80, 100, 50);
		buttonafter.setBounds(385,80,100,50);
		logout1.setBounds(500,20,80,30);
		logout2.setBounds(500,20,80,30);
		logout3.setBounds(500,20,80,30);
		logout4.setBounds(500,20,80,30);
		
		text.setBounds(0,50,1000,1000);
		
		
		
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel1.add(button5);
		panel1.add(button6);
		panel1.add(button7);
		panel1.add(button8);
		panel1.add(button9);
		panel1.add(buttonafter);
		panel1.add(buttonbefore);
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(logout1);
		panel1.setPreferredSize(new Dimension(0,1000));
		panel2.add(label3);
		panel2.add(logout2);
		
		panel3.add(myname);
		panel3.add(mysex);
		panel3.add(myphone);
		panel3.add(mypwd);
		panel3.add(logout3);
		
		
		panel4.add(text);
		panel4.add(logout4);
				
		button1.setActionCommand("button1");
		button2.setActionCommand("button2");
		button3.setActionCommand("button3");
		button4.setActionCommand("button4");
		button5.setActionCommand("button5");
		button6.setActionCommand("button6");
		button7.setActionCommand("button7");
		button8.setActionCommand("button8");
		button9.setActionCommand("button9");
		buttonbefore.setActionCommand("buttonbefore");
		buttonafter.setActionCommand("buttonafter");
		logout1.setActionCommand("logout1");
		logout2.setActionCommand("logout2");
		logout3.setActionCommand("logout3");
		logout4.setActionCommand("logout4");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		buttonafter.addActionListener(this);
		buttonbefore.addActionListener(this);
		logout1.addActionListener(this);
		logout2.addActionListener(this);
		logout3.addActionListener(this);
		logout4.addActionListener(this);
		

		add(choose,BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(600,200,620,680);
		setTitle("��Ŀ��ԤԼϵͳ");
		
		
	}
	public int search(String str,String strRes) {//��ѯѧʱ
		int n=0;//������
		while(str.indexOf(strRes)!=-1) {
            int h = str.indexOf(strRes);
            n++;
            str = str.substring(h+1);
        }
		
        return n;
	}
	void update() {
		
		label2.setText(""+year+"-"+month+"-"+day+" ��"+week+"");
		
	}
	
	public   static   void  add(String file, String conent) {  //��������ı�д���ļ��У�
        BufferedWriter out = null ;  
        try  {  
            out = new  BufferedWriter( new  OutputStreamWriter(  
                    new  FileOutputStream(file,  true )));  
            out.write(conent);  
        } catch  (Exception e) {  
            e.printStackTrace();
        } finally  {  
            try  {  
                out.close();  
            } catch  (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }
	public void nextday() {    //���������㷨(������һ��ľ�������)
		day++;
		week++;
		if(day>30&&(month==4||month==6||month==9||month==11))
			{
			month=month+1;
		    day=day-30;
		    }
		if(day>31&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12))
		{
			month=month+1;
			day=day-31;
		if(day>28&&month==2)
		{
			month=month+1;
			day=day-28;
		}
		}
		if(week>7)
		{
			week=week-7;
		}
		if(month>12)
		{
			month=month-1;
			year++;
		}
			
		update();
		
		
		
	}
	public void lastday() {       //���������㷨(����ǰһ��ľ�������)
		day--;
		week--;
		if(day<1&&(month==1||month==2||month==4||month==6||month==9||month==11))
			{
			month=month-1;
		    day=day+31;
		    }
		if(day<1&&(month==5||month==7||month==8||month==10||month==12))
		{
			month=month-1;
			day=day+30;
		}
		if(day<1&&month==3)
		{
			month=month-1;
			day=day+28;
		}
		if(week<1)
		{
			week=week+7;
		}
		if(month<1)
		{
			month=month+1;
			year--;
		}
			
		
		update();
	}
	
	
public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("logout1")) {    //ÿ�������ע����ť
			this.dispose();
			new log();
			}
		if(e.getActionCommand().equals("logout2")) {
			this.dispose();
			new log();
			}
		if(e.getActionCommand().equals("logout3")) {
			this.dispose();
			new log();
			}
		if(e.getActionCommand().equals("logout4")) {
			this.dispose();
			new log();
			}
		if(e.getActionCommand().equals("buttonafter")) {     //�������һ�족��ť֮�����ı仯
			nextday();
			
			button1.setBackground(null);
			button1.setText("<html>��XX123ѧ<br>08:00-09:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button2.setBackground(null);
			button2.setText("<html>��XX123ѧ<br>09:00-10:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button3.setBackground(null);
			button3.setText("<html>��XX123ѧ<br>10:00-11:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button4.setBackground(null);
			button4.setText("<html>��XX123ѧ<br>11:00-12:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button5.setBackground(null);
			button5.setText("<html>��XX123ѧ<br>13:00-14:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button6.setBackground(null);
			button6.setText("<html>��XX123ѧ<br>14:00-15:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button7.setBackground(null);
			button7.setText("<html>��XX123ѧ<br>15:00-16:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button8.setBackground(null);
			button8.setText("<html>��XX123ѧ<br>16:00-17:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button9.setBackground(null);
			button9.setText("<html>��XX123ѧ<br>17:00-18:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
		}
		if(e.getActionCommand().equals("buttonbefore")) {      //�����ǰһ�족��ť֮�����ı仯
			
			lastday();
			button1.setBackground(null);
			button1.setText("<html>��XX123ѧ<br>08:00-09:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button2.setBackground(null);
			button2.setText("<html>��XX123ѧ<br>09:00-10:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button3.setBackground(null);
			button3.setText("<html>��XX123ѧ<br>10:00-11:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button4.setBackground(null);
			button4.setText("<html>��XX123ѧ<br>11:00-12:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button5.setBackground(null);
			button5.setText("<html>��XX123ѧ<br>13:00-14:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button6.setBackground(null);
			button6.setText("<html>��XX123ѧ<br>14:00-15:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button7.setBackground(null);
			button7.setText("<html>��XX123ѧ<br>15:00-16:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button8.setBackground(null);
			button8.setText("<html>��XX123ѧ<br>16:00-17:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			button9.setBackground(null);
			button9.setText("<html>��XX123ѧ<br>17:00-18:00<br>C1-��Ŀ��(���)<br>��Լ0�ˣ���Լ1��</html>");
			
		}
		
		if(e.getActionCommand().equals("button1"))
		{
			
			button1.setBackground(Color.gray);
			button1.setText("<html>��XX123ѧ<br>08:00-09:00<br>C1-��Ŀ��(���)<br>ԤԼ����</html>");
			add("C:/Users/��/Desktop/�˺�/"+log.NAME1+".txt","\r\n"+year+"-"+month+"-"+day+" ��"+week+" ��XX123ѧ,08:00-09:00,C1-��Ŀ��(���)");
		}
		if(e.getActionCommand().equals("button2"))
		{
			button2.setBackground(Color.gray);
			button2.setText("<html>��XX123ѧ<br>09:00-10:00<br>C1-��Ŀ��(���)<br>ԤԼ����</html>");
			add("C:/Users/��/Desktop/�˺�/"+log.NAME1+".txt","\r\n"+year+"-"+month+"-"+day+" ��"+week+" ��XX123ѧ,09:00-10:00,C1-��Ŀ��(���)");
		}
		if(e.getActionCommand().equals("button3"))
		{
			button3.setBackground(Color.gray);
			button3.setText("<html>��XX123ѧ<br>10:00-11:00<br>C1-��Ŀ��(���)<br>ԤԼ����</html>");
			add("C:/Users/��/Desktop/�˺�/"+log.NAME1+".txt","\r\n"+year+"-"+month+"-"+day+" ��"+week+" ��XX123ѧ,10:00-11:00,C1-��Ŀ��(���)");
		}
		if(e.getActionCommand().equals("button4"))
		{
			button4.setBackground(Color.gray);
			button4.setText("<html>��XX123ѧ<br>11:00-12:00<br>C1-��Ŀ��(���)<br>ԤԼ����</html>");
			add("C:/Users/��/Desktop/�˺�/"+log.NAME1+".txt","\r\n"+year+"-"+month+"-"+day+" ��"+week+" ��XX123ѧ,11:00-12:00,C1-��Ŀ��(���)");
		}
		if(e.getActionCommand().equals("button5"))
		{
			button5.setBackground(Color.gray);
			button5.setText("<html>��XX123ѧ<br>13:00-14:00<br>C1-��Ŀ��(���)<br>ԤԼ����</html>");
			add("C:/Users/��/Desktop/�˺�/"+log.NAME1+".txt","\r\n"+year+"-"+month+"-"+day+" ��"+week+" ��XX123ѧ,13:00-14:00,C1-��Ŀ��(���)");
		}
		if(e.getActionCommand().equals("button6"))
		{
			button6.setBackground(Color.gray);
			button6.setText("<html>��XX123ѧ<br>14:00-15:00<br>C1-��Ŀ��(���)<br>ԤԼ����</html>");
			add("C:/Users/��/Desktop/�˺�/"+log.NAME1+".txt","\r\n"+year+"-"+month+"-"+day+" ��"+week+" ��XX123ѧ,14:00-15:00,C1-��Ŀ��(���)");
		}
		if(e.getActionCommand().equals("button7"))
		{
			button7.setBackground(Color.gray);
			button7.setText("<html>��XX123ѧ<br>15:00-16:00<br>C1-��Ŀ��(���)<br>ԤԼ����</html>");
			add("C:/Users/��/Desktop/�˺�/"+log.NAME1+".txt","\r\n"+year+"-"+month+"-"+day+" ��"+week+" ��XX123ѧ,15:00-16:00,C1-��Ŀ��(���)");
		}
		if(e.getActionCommand().equals("button8"))
		{
			button8.setBackground(Color.gray);
			button8.setText("<html>��XX123ѧ<br>16:00-17:00<br>C1-��Ŀ��(���)<br>ԤԼ����</html>");
			add("C:/Users/��/Desktop/�˺�/"+log.NAME1+".txt","\r\n"+year+"-"+month+"-"+day+" ��"+week+" ��XX123ѧ,16:00-17:00,C1-��Ŀ��(���)");
		}
		if(e.getActionCommand().equals("button9"))
		{
			button9.setBackground(Color.gray);
			button9.setText("<html>��XX123ѧ<br>17:00-18:00<br>C1-��Ŀ��(���)<br>ԤԼ����</html>");
			add("C:/Users/��/Desktop/�˺�/"+log.NAME1+".txt","\r\n"+year+"-"+month+"-"+day+" ��"+week+"��XX123ѧ,17:00-18:00,C1-��Ŀ��(���)");
		}
		
				
	}
}
