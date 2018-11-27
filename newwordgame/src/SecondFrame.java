import javax.swing.*;
import java.awt.event.*;

public class SecondFrame {

	JButton rb1,rb2,rb3;
	
	JFrame fr = new JFrame("Lets Play!!!");
	SecondFrame()
{
	
	JPanel pan=new JPanel();
	pan.setLayout(null);
	JLabel lab=new JLabel("Please choose from the following categories!!");
	lab.setBounds(100,10,300,20);
	rb1= new JButton("Animals");
	rb1.setBounds(100,70,100,30);
        rb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fr.dispose();
				new Game();
			}
		});
	rb2= new JButton("Plants");
	rb2.setBounds(100,130,100,30);
        rb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fr.dispose();
				new Game2();
			}
		});
	rb3= new JButton("Fruits");
	rb3.setBounds(100,190,100,30);
	rb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fr.dispose();
				new Game3();
			}
		});
	
	pan.add(lab);
	pan.add(rb1);
	pan.add(rb2);
	pan.add(rb3);
	
	fr.add(pan);
	fr.setSize(500,500);
	
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fr.setVisible(true);
}

 public static void main(String args[])
{
	new SecondFrame();
}
}

