import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{    

long Random;
JTextField namefield,fnamefield,Dobfield,Emailfield,addressfield,Statefield,Cityfield,Pinfield; 
JRadioButton male,female,other,married,unmarried;
 
    Signup(){

    setLayout(null); 
 Random ran = new Random();
 Random =  Math.abs(ran.nextLong()% 9000 +1000L);


 JLabel formno = new JLabel("APPLICATION FORM NO: " + Random);
  formno.setFont(new Font("Raleway",Font.BOLD,38));
  formno.setBounds(140,20,600,40);
  add(formno);


  JLabel PersonDetails = new JLabel("Page 1 : Person Details");
  PersonDetails.setFont(new Font("Raleway",Font.BOLD,22));
  PersonDetails.setBounds(290,80,400,30);
  add(PersonDetails);


  JLabel name = new JLabel("Name : ");
  name.setFont(new Font("Raleway",Font.BOLD,22));
  name.setBounds(100,140,100,30);
  add(name);

    namefield = new JTextField();
   namefield.setFont(new Font("Raleway",Font.BOLD,14));
  namefield.setBounds(300,140,400,30);
  add(namefield);

  JLabel fname = new JLabel("Father's Name : ");
  fname.setFont(new Font("Raleway",Font.BOLD,22));
  fname.setBounds(100,190,200,30);
  add(fname);

   fnamefield = new JTextField();
  fnamefield.setFont(new Font("Raleway",Font.BOLD,14));
  fnamefield.setBounds(300,190,400,30);
 add(fnamefield);

  JLabel Dob= new JLabel("DOB: ");
  Dob.setFont(new Font("Raleway",Font.BOLD,22));
  Dob.setBounds(100,240,200,30);
  add(Dob);

   Dobfield = new JTextField("dd/mm/year");
  Dobfield.setFont(new Font("Raleway",Font.BOLD,14));
  Dobfield.setBounds(300,240,400,30);
 add(Dobfield);

  JLabel Gender = new JLabel("Gender: ");
  Gender.setFont(new Font("Raleway",Font.BOLD,22));
  Gender.setBounds(100,290,200,30);
  add(Gender);

  male =new JRadioButton("Male");
 male.setBounds(300, 290, 60, 30);
 add(male);

  female =new JRadioButton("Female");
 female.setBounds(450, 290, 80, 30);
 add(female);



 ButtonGroup group = new ButtonGroup();
  group.add(male);
  group.add(female);



  
   
  JLabel Email = new JLabel("Email: ");
  Email.setFont(new Font("Raleway",Font.BOLD,22));
  Email.setBounds(100,340,200,30);
  add(Email);

   Emailfield = new JTextField();
  Emailfield.setFont(new Font("Raleway",Font.BOLD,14));
  Emailfield.setBounds(300,340,400,30);
 add(Emailfield);

  JLabel marital = new JLabel("Marital Status: ");
  marital.setFont(new Font("Raleway",Font.BOLD,22));
  marital.setBounds(100,390,200,30);
  add(marital);

   married =new JRadioButton("married");
  married.setBounds(300, 390, 100, 30);
  add(married);
 
   unmarried =new JRadioButton("unmarried");
  unmarried.setBounds(450, 390, 100, 30);
  add(unmarried);

   other =new JRadioButton("other");
  other.setBounds(600, 390, 100, 30);
  add(other);

 
  ButtonGroup groupmarital = new ButtonGroup();
  groupmarital.add(married);
  groupmarital.add(unmarried);
  groupmarital.add(other);
 
  JLabel address = new JLabel("Address: ");
  address.setFont(new Font("Raleway",Font.BOLD,22));
  address.setBounds(100,440,200,30);
  add(address);
  
  addressfield  = new JTextField();
  addressfield.setFont(new Font("Raleway",Font.BOLD,14));
  addressfield.setBounds(300,440,400,30);
 add(addressfield);

  JLabel City= new JLabel("City: ");
  City.setFont(new Font("Raleway",Font.BOLD,22));
  City.setBounds(100,490,200,30);
  add(City);

   Cityfield = new JTextField();
  Cityfield.setFont(new Font("Raleway",Font.BOLD,14));
  Cityfield.setBounds(300,490,400,30);
 add(Cityfield);

  JLabel State= new JLabel("State: ");
  State.setFont(new Font("Raleway",Font.BOLD,22));
  State.setBounds(100,540,200,30);
  add(State);

  Statefield = new JTextField();
  Statefield .setFont(new Font("Raleway",Font.BOLD,14));
  Statefield .setBounds(300,540,400,30);
 add(Statefield );

 JLabel pin= new JLabel("Pin Code: ");
 pin.setFont(new Font("Raleway",Font.BOLD,22));
 pin.setBounds(100,590,200,30);
 add(pin);

  Pinfield = new JTextField();
 Pinfield .setFont(new Font("Raleway",Font.BOLD,14));
 Pinfield .setBounds(300,590,400,30);
add(Pinfield);


 JButton next = new JButton("NEXT");
 next.setBackground(Color.BLACK);
 next.setForeground(Color.WHITE);
 next.setFont(new Font("raleway",Font.BOLD, 14));
 next.setBounds(620,660,80,30);
 next.addActionListener(this);
 add(next);

 getContentPane().setBackground(Color.WHITE) ;

   setSize(850,800);
   setLocation(350,10);
   setVisible(true);

   
    }

    public void actionPerformed(ActionEvent ae){
  String formno = " " + Random;
  String name = namefield.getText();
  String fname= fnamefield.getText();
  String Dob = Dobfield.getText();
   String gender = null;
   if (male.isSelected()) {
    gender ="male"; 
   }else if (female.isSelected()) {
     gender ="Female";   
   }

   String email = Emailfield.getText();
   String marital = null;
   if (married.isSelected()) {
    marital= "married";
   }else if (unmarried.isSelected()) {
     marital ="Unmarried";
   }else if (other.isSelected()) {
    marital = "Other";
   }
String address =addressfield.getText();
String city = Cityfield.getText();
String state =Statefield.getText();   
String pin =Pinfield.getText();
try{
    if (name.equals("")) {
        JOptionPane.showMessageDialog(null, "Name is Requried"); 
     }else {
       Conn c =new Conn();
       String query="insert into Signup values ('"+formno+"','"+name+"','"+fname+"','"+Dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
       c.s.executeUpdate(query);

       setVisible(false);
       new SignupTwo(formno).setVisible(true);

      }
}catch (Exception e){
    
    System.out.println(e);
}
    }

    
public static void main(String[] args) {
    new Signup();
}
}