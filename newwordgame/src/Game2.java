import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game2 {
    Connection con=null;
    PreparedStatement st=null;
    ResultSet rs=null;
  JFrame fr = new JFrame("ganwdnew!!!");  
  JPanel panel=new JPanel();
  JLabel lab=new JLabel("Hint");
  JTextField hint = new JTextField();
  JTextField input = new JTextField();
  JButton submit=new JButton("Submit");
  JButton reset=new JButton("Reset");
  Game2()
  {
      
      lab.setBounds(100,10,50,20);
     
      hint.setBounds(190,10,220,25);
      
      input.setBounds(100,100,220,25);
      
      submit.setBounds(100,150,220,25);
      submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {                                       
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            String x=(String)(hint.getText().trim());
            con = DriverManager.getConnection("jdbc:mysql://localhost/wordgamesdb","root","");
            String s = "SELECT * FROM untitled WHERE hint='"+x+"'";
            st = con.prepareStatement(s);        
            rs=st.executeQuery(s);
            String in=(String) input.getText().trim();
            if(rs.next()){   
            if(rs.getString("name").equalsIgnoreCase(in)==true)
            {
                JOptionPane.showMessageDialog(null, "Correct Answer");
                reset();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Answer");
                reset();
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } 
// TODO add your handling code here:
    }
      });
              
      reset.setBounds(100,200,220,25);
      reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {{                                      
reset();     
    }
                        }
      });
      panel.setLayout(null);
      panel.add(hint);
      panel.add(lab);
      panel.add(input);
      panel.add(reset);
      panel.add(submit);

      fr.add(panel);
      fr.setSize(600,600);
      fr.setVisible(true);
      call();
  
  }
  
   
  
     private void call() {
        
        try{
             int n ;
               n= (int) (Math.random()*5)%5;
             while(n<1)
             {
                 n= (int)( Math.random()*5)%5;
             }
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordgamesdb","root","");
      String s = "select hint from untitled";
      st = con.prepareStatement(s);
      rs = st.executeQuery(s);
      rs.next();
      for(int i=0;i<n-1;i++)
      {
          rs.next();
      }            
            hint.setText(rs.getString("hint"));
    }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    void reset() {
        input.setText("");
    try{
             int n ;
               n= (int) (Math.random()*5)%5;
             while(n<1)
             {
                 n= (int)( Math.random()*5)%5;
             }
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordgamesdb","root","");
      String s = "select hint from untitled";
      st = con.prepareStatement(s);
      rs = st.executeQuery(s);
      rs.next();
      for(int i=0;i<n-1;i++)
      {
          rs.next();
      }            
            hint.setText(rs.getString("hint"));
    }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }//To change body of generated methods, choose Tools | Templates.
    }
}

