import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw,back;
    String pinno;
    
    Withdrawl(String pinno){
        this.pinno = pinno;
 
       setLayout(null);

 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
 Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
 ImageIcon i3 = new ImageIcon(i2);
 JLabel image =new JLabel(i3);
 image.setBounds(0,0,900,900);
 add(image); 

 JLabel text =new JLabel("Enter the amount you want to Withdraw");
 text.setFont(new Font("System",Font.BOLD,16));
text.setBounds(170,300,400,20);
text.setForeground(Color.white);
image.add(text);

JTextField amount =new JTextField();
amount.setFont(new Font("raleway",Font.BOLD,22));
amount.setBounds(170,350,320,25);
image.add(amount);

 withdraw =new JButton("Withdraw");
 withdraw.setBounds(335,485, 150,30);
 withdraw.addActionListener(this);
image.add(withdraw);

 back =new JButton("Back");
 back.setBounds(335,520, 150,30);
back.addActionListener(this);;
 image.add(back);

 setSize(900,900);
 setLocation(300,0);
 setVisible(true);
    }

   public void actionPerformed (ActionEvent ae){
 if (ae.getSource() == withdraw) {
    String number = amount.getText();
    Date date = new Date() ;
    if (number.equals ("")) {
        JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");    
    }else{
        try{
        Conn conn =new Conn();
        String query ="insert into bank values('"+pinno+"','"+date+"','Withdrawl','"+number+"')";
        conn.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"RS"+number+"Withdraw Successfully");
     setVisible(false);
     new Transactions(pinno).setVisible(true); 
    }catch (Exception e){
        System.out.print(e);
     }
    }
     } else if (ae.getSource() == back) {
    setVisible(false);
    new Transactions(pinno) .setVisible(true);
 }
   }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}