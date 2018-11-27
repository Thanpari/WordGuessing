import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;

class WordGuess
{
    JFrame frame=new JFrame("Word Guessing Game!!");
    
	
	WordGuess()
	{
		
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JLabel lab=new JLabel("Enter your name");
		JTextField name = new JTextField();
		JButton button=new JButton("Play");
		lab.setBounds(100,10,220,20);
		name.setBounds(250,10,220,25);
		button.setBounds(100,90,100,25);
		panel.add(name);
		panel.add(lab);
		panel.add(button);
                frame.add(panel);
		frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new file("C:\\Users\\ARUNJYOTI GORAI\\Downloads\\BingWallpaper-2018-11-17.jpg")))));
		
                frame.pack();
                

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new SecondFrame();
			}
		});
		frame.setVisible(true);
	}
	public static void main(String args[])
	{
                
    
       
		new WordGuess();
	}
}
