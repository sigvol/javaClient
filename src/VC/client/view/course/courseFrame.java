package VC.client.view.course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;

public class courseFrame extends JFrame{
	JButton button1 = new JButton("ѡ��");
	JButton button2 = new JButton("�˿�");
	JButton button3 = new JButton("�ҵĿγ�");
	
	JFrame jf = new JFrame();
	public courseFrame() {
		
		jf.setTitle("����У԰ѡ��ϵͳ");
		jf.setSize(new Dimension(500, 200));
		jf.setLocation(200, 200);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setLayout(null);
		
		jf.getContentPane().add(button1, null);
		jf.getContentPane().add(button2, null);
		jf.getContentPane().add(button3, null);
		
		button1.setBounds(new Rectangle(50, 50, 70, 27));
		button2.setBounds(new Rectangle(150, 50, 70, 27));
		button3.setBounds(new Rectangle(250, 50, 150, 27));
		
		button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new chooseCourse();
            	jf.setVisible(false);
            }
         });
		
		button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new mycourse();
            	jf.setVisible(false);
            }
         });
		
		button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new giveupCourse();
            	jf.setVisible(false);
            }
         });
		
	}
	
	public static void main(String[] args) {
		new courseFrame();
	}
}
