package Design;
import javax.swing.*;

import Design.sign;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Logins {
	public static void main(String[] args)
	{
		new log();
	}
}
class log extends JFrame implements ActionListener{
	public String[] Name1=new String[1];
	public String[] Pwd1=new String[1];
	public static String []str=new String[5];
	public static String NAME1,PWD1;
	
	JLabel user1,tu,pwd1;
	JTextField nameField1;
	JPasswordField pwdField1;
	JButton button0,sign;
	JTabbedPane choose0;
	JPanel panel0;
	log(){
		tu=new JLabel(new ImageIcon("C:\\Users\\久\\Desktop\\image\\3.png"));
		add(tu,BorderLayout.NORTH);
		user1=new JLabel("账号",JLabel.CENTER);
		pwd1=new JLabel("密码",JLabel.CENTER);
		
		
		nameField1=new JTextField(10);
		pwdField1=new JPasswordField(10);
		panel0=new JPanel();
		choose0=new JTabbedPane();
		button0=new JButton("登录");
		sign=new JButton("注册");
		choose0.add("登录",panel0);
		panel0.setLayout(null);
		user1.setBounds(0, 0, 100, 40);
		nameField1.setBounds(100,0,200,40);
		pwd1.setBounds(0,40, 100, 40);
		pwdField1.setBounds(100,40, 200, 40);
		sign.setBounds(500,50, 70, 20);
		
		
		
		
		panel0.add(user1);
		panel0.add(nameField1);
		panel0.add(pwd1);
		panel0.add(pwdField1);
		panel0.add(sign);
	
		button0.setActionCommand("button0");
		button0.addActionListener(this);
		sign.setActionCommand("sign");
		sign.addActionListener(this);
		add(button0,BorderLayout.SOUTH);
		add(choose0,BorderLayout.CENTER);
		
		
		ImageIcon tu=new ImageIcon("C:\\Users\\久\\Desktop\\image\\1.jpg");
		setIconImage(tu.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(600,200,650,680);
		setTitle("登陆");
		
		
		
		
	}
	public void actionPerformed(ActionEvent e2) {
		
		
		
		
		NAME1=nameField1.getText();
		PWD1 = pwdField1.getText();
		
		FileInputStream fls = null;
        //声明输出流的引用
        FileOutputStream fos =null;
        try{
            File file=new File("C:/Users/久/Desktop/账号/"+NAME1+".txt");
            FileReader fr1=new FileReader(file);
            BufferedReader br = new BufferedReader(fr1); 
            String line=null;
            
            String s=null;
            int j=0;
            line=br.readLine();
            while(line!=null) 
            {
            	
            	str[j]=line;
            	j++;
            	line=br.readLine();
            }
            br.close();
           
            
            
        }
        catch(Exception e1){
            System.out.println(e1.toString());
        }	
        
        Name1[0]=NAME1;
		Pwd1[0]=PWD1;
		
		
		
			
			if(e2.getActionCommand().equals("button0"))
		{
			
			if(Name1[0].equals(str[0])&&Pwd1[0].equals(str[3]))
			{
			JOptionPane.showMessageDialog(this, "登陆成功！","提示",JOptionPane.WARNING_MESSAGE);
			
			try {
				new login_face();
			} catch (IOException e6) {
				// TODO Auto-generated catch block
				e6.printStackTrace();
			}
			this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "账号或密码错误！\n请重新输入!","提示",JOptionPane.WARNING_MESSAGE);
			}
			
			}
		
		
		
		if(e2.getActionCommand().equals("sign"))
		{
			this.dispose();
			new sign();
		}
			
	}
}
