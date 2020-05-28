package Design;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class sign extends JFrame implements ActionListener{
	public String _name,_sex,_phone,_pwd;
	JButton button;
	JPanel panel;
	JLabel name,sex,phone,pwd,title;
	JTextField namefield,sexfield,phonefield,pwdfield;
	sign(){
		button =new JButton("完成注册");
		panel=new JPanel();
		name=new JLabel("姓名(账号)：");
		sex=new JLabel("性别：");
		phone=new JLabel("手机号码：");
		pwd=new JLabel("密码");
		title=new JLabel("请完整填写以下信息完成注册");
		title.setFont(new Font("黑体",Font.PLAIN,20));
		namefield=new JTextField(10);
		sexfield=new JTextField(10);
		phonefield=new JTextField(10);
		pwdfield=new JTextField(10);
		
		name.setBounds(192,100, 100, 50);
		sex.setBounds(192, 150, 100, 50);
		phone.setBounds(192, 200, 100, 50);
		pwd.setBounds(192, 250, 100, 50);
		title.setBounds(190, 20, 300, 50);
		
		namefield.setBounds(270, 110, 190, 30);
		sexfield.setBounds(270, 160, 190, 30);
		phonefield.setBounds(270, 210,190, 30);
		pwdfield.setBounds(270, 260,190, 30);
		
		button.setBounds(500,550,100,30);
		
		panel.add(button);
		panel.add(name);
		panel.add(namefield);
		panel.add(sex);
		panel.add(sexfield);
		panel.add(phone);
		panel.add(phonefield);
		panel.add(pwd);
		panel.add(pwdfield);
		panel.add(title);
		panel.setPreferredSize(new Dimension(0,1000));
		panel.setLayout(null);
		
		button.setActionCommand("button");
		button.addActionListener(this);
		namefield.setActionCommand("namefield");
		namefield.addActionListener(this);
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(600,200,620,680);
		setTitle("注册");

	}
	public void actionPerformed(ActionEvent e4) {
		_name=namefield.getText();
		_sex=sexfield.getText();
		_phone=phonefield.getText();
		_pwd=String.valueOf(pwdfield.getText());
		

		File user=new File("C:\\Users\\久\\Desktop\\账号\\"+_name+".txt");
		PrintWriter out;
		try {
			out=new PrintWriter(user);
			out.println(_name);
			out.println(_sex);
			out.println(_phone);
			out.println(_pwd);
			out.close();
		}catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		if(e4.getActionCommand().equals("button")){
			
			if(_name.equals("")||_pwd.contentEquals(""))
			{
				JOptionPane.showMessageDialog(this, "请填写完整的信息","提示",JOptionPane.WARNING_MESSAGE);
			}
			else 
			{
			JOptionPane.showMessageDialog(this, "注册完成！跳转后请登录！","提示",JOptionPane.WARNING_MESSAGE);
			this.dispose();
			new log();
			}
			
	        
		}
		
		
	}
	


}
