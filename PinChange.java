import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
JPasswordField pin,repin;
JButton change,back;
String pinno;

    PinChange(String pinno){
        
     this.pinno =pinno;

        setLayout(null);
     
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
     Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image =new JLabel(i3);
     image.setBounds(0, 0, 900, 900);
     add(image);

     JLabel text =new JLabel("CHANGE YOUR PIN");
     text.setForeground(Color.WHITE);
     text.setFont(new Font("System",Font.BOLD,16));
     text.setBounds(250, 280,500,30);
     image.add(text);
     
    
     JLabel pintext =new JLabel("NEW PIN:");
     pintext.setForeground(Color.WHITE);
     pintext.setFont(new Font("System",Font.BOLD,16));
     pintext.setBounds(165, 320,180,25);
     image.add(pintext);

      pin = new JPasswordField();
     pin.setFont(new Font("raleway",Font.BOLD,20));
     pin.setBounds(330, 320,180,25);
     image.add(pin);

     JLabel retext =new JLabel("Re-ENTER NEW PIN:");
     retext.setForeground(Color.WHITE);
     retext.setFont(new Font("System",Font.BOLD,16));
     retext.setBounds(165, 360,180,25);
     image.add(retext);

   
    repin = new JPasswordField();
     repin.setFont(new Font("raleway",Font.BOLD,20));
     repin.setBounds(330, 360,180,25);
     image.add(repin);

     JButton change =new JButton("Change");
     change.setBounds(335,485,150,30);
     change.addActionListener(this);
     image.add(change);

     JButton back =new JButton("Back");
    back.setBounds(335,520,150,30);
    back.addActionListener(this);
     image.add(back);


   setSize(900,900);
   setLocation(300, 0);
   setUndecorated(true);
   setVisible(true);


    }
public void actionPerformed(ActionEvent ae){
    if (ae.getSource() == change) {
        
try{
  String npin = pin.getText();
  String rpin = repin.getText();
  if (npin.equals(rpin)) {
    JOptionPane.showMessageDialog(null, "Entered Pin dosen't match");
    return;
  }
   if (npin.equals("")) {
    JOptionPane.showMessageDialog(null, "Please enter PIN");
  return;
   }
   if (rpin.equals("")) {
    JOptionPane.showMessageDialog(null,"Plesse re-enter the PIN");
   }

   Conn conn =new Conn();
   String query1 ="Update bank set pinno = '"+rpin+"' where pinmo ='"+pinno+"'";
   String query2 ="Update login set pinno = '"+rpin+"' where pinno ='"+pinno+"'";
   String query3 ="Update SignupThree set pinno = '"+rpin+"' where pinno ='"+pinno+"'";

   conn.s.executeUpdate(query1);
   conn.s.executeUpdate(query2);
   conn.s.executeUpdate(query3);

   JOptionPane.showMessageDialog(null, "PIN change successfully");

setVisible(false);
new Transactions(rpin).setVisible(true);
}catch(Exception e){
 System.out.println(e);
}
    }else {
        setVisible(false);
        new Transactions(pinno).setVisible(true);
    }
}

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
