import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
 JButton login , clear, signup;
 JTextField card;
 JPasswordField Pin;

 Login(){
   setTitle("ATM");
   setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label =new JLabel(i3);
    label.setBounds(70, 10, 100, 100);
    add(label);

    JLabel text = new JLabel("Welcome to SBI");
    text.setFont(new Font("osward", Font.BOLD,38));
    text.setBounds(200,40,400,40);
    add(text);

    
    JLabel cardno = new JLabel("Card No:");
    cardno.setFont(new Font("Raleway", Font.BOLD,25));
    cardno.setBounds(120,150,150,40);
    add(cardno);

    card= new JTextField();
    card.setBounds(290,150,250,30);
    add(card);

    
    JLabel pin = new JLabel("PIN:");
    pin.setFont(new Font("osward", Font.BOLD,25));
    pin.setBounds(120,220,400,40);
    add(pin);

    Pin= new JPasswordField();
    Pin.setBounds(290,220,250,30);
    add(Pin);
    
     login = new JButton("SIGN IN");
    login.setBounds(300,300,100,30);
    login.addActionListener(this);
    add(login);

    
    clear = new JButton("CLEAR");
    clear.setBounds(430,300,100,30);
    clear.addActionListener(this);
    add(clear);

   signup = new JButton("SIGN UP");
    signup.setBounds(300,350,230,30);
    signup.addActionListener(this);
    add(signup);

    getContentPane().setBackground(Color.WHITE);
    
    setSize(800,480);
    setVisible(true);
    setLocation(350,200);
 }
 public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == clear){
     card.setText( "");
     Pin.setText("");
    }else if (ae.getSource() == login){
      Conn conn =new Conn();
      String cardno=card.getText();
      String pinno =Pin.getText();
      String query = "select * from login where CardNo = '"+cardno+"' and pinno ='"+pinno+"' ";
   try{
    ResultSet rs = conn.s.executeQuery(query);
    if (rs.next()) {
      setVisible(false);
      new Transactions(pinno).setVisible(true);
    }else{
      JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
    }
   }catch(Exception e){
    System.out.println(e);
   }
 
    }else if (ae.getSource() == signup){
      setVisible(false);
      new Signup().setVisible(true);
    }
 }
    public static void main(String args[]){
   new Login();
    }
    
}