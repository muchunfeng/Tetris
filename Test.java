package ylutil.myworks.myFirstTries;

import java.awt.*; 
import javax.swing.*;
public class Test {
	public static void main(String args[])
	{ 
		JPanel panel=new JPanel(new GridLayout(1,2));
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JLabel label1=new JLabel(String.valueOf(XianShi.fengshu)),label2=new JLabel();
		JFrame frame=new JFrame("俄罗斯方块");
		//frame.setPreferredSize(new Dimension(350,550));
		frame.setBounds(100, 100, 350, 700);
		Container con=frame.getContentPane();
		panel.add(panel1);
		panel.add(panel2);
		panel1.add(label1);
		panel2.add(label2);
		con.add(panel,BorderLayout.PAGE_END);
		XianShi xs=new XianShi(frame.getWidth(),frame.getHeight()-100,label1,label2);
		//xs.setBorder(BorderFactory.createLineBorder(new Color(200,107,178)));
		frame.addKeyListener(xs);
		System.out.println(frame.getWidth()+"  "+frame.getHeight());
		con.add(xs,BorderLayout.CENTER);
		frame.show();
		xs.control();
	}

}