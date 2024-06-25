

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

JButton  rs1,rs2,rs3,rs4,rs5,rs6,back;
String pinno;

FastCash(String pinno){

    this.pinno = pinno;
    setLayout(null);

 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
 Image i2 =i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
 ImageIcon i3 =new ImageIcon(i2);
 JLabel image =new JLabel(i3);
 image.setBounds(0,0,900,900);
 add(image);


 JLabel text = new JLabel("SELECT WTIHDRAWL AMOUNT");
 text.setBounds(235,300,700,35);
 text.setForeground(Color.WHITE);
 text.setFont(new Font("Raleway",Font.BOLD,16));
 image.add(text);



 rs1 = new JButton("Rs -100");
 rs1.setBounds(170,415,150,30);
 rs1.addActionListener(this);
 image.add( rs1);

 rs2= new JButton("Rs -500");
 rs2.setBounds(335,415,150,30);
 rs2.addActionListener(this);
 image.add( rs2);

 rs3= new JButton("Rs -1000");
 rs3.setBounds(170,450,150,30);
 rs3.addActionListener(this);
 image.add( rs3);

 rs4 = new JButton("Rs -2000");
 rs4.setBounds(335,450,150,30);
 rs4.addActionListener(this);
 image.add( rs4);

 rs5 = new JButton("Rs -5000");
 rs5.setBounds(170,485,150,30);
 rs5.addActionListener(this);
 image.add( rs5);

 rs6= new JButton("Rs -10000");
 rs6.setBounds(335,485,150,30);
 rs6.addActionListener(this);
 image.add(  rs6);

  back= new JButton("Back");
 back.setBounds(335,520,150,30);
back.addActionListener(this);
 image.add(back);






  setSize(900,900);
  setLocation(300,0);
  setUndecorated(true);
  setVisible(true);

}



public void actionPerformed(ActionEvent ae){
    if (ae.getSource() ==back){
     setVisible(false);
     new Transactions(pinno).setVisible(true);
     } 
     else  { String amount = ((JButton)ae.getSource()).getText().substring(3);
     Conn c =new Conn();

     try{
       ResultSet rs = c.s.executeQuery("Select * from bank where pinno = '"+pinno+"'");
       int balance = 0;
       while(rs.next()){
        if(rs.getString("type").equals("Deposit")){
            balance += Integer.parseInt(rs.getString("amount"));
        }else{
            balance -= Integer.parseInt(rs.getString("amount"));
        }
  
if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
    JOptionPane.showMessageDialog(null," Insufficient Balance");
    return;
}

Date date =new Date();
String query ="insert into bank values('"+pinno+"','"+date+"','Withdrawl','"+amount+"')";
c.s.executeUpdate(query);
JOptionPane.showMessageDialog(null, "Rs" +amount+"Debited Successfully");
setVisible(false);
new Transactions(pinno).setVisible(true);    
}
     } catch(Exception e){
System.out.println(e);
     }

     }
}


    public static void main(String[] args) {
        new FastCash("");
    }
}