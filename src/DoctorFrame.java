import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


/**
 * Write a description of class DoctorFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DoctorFrame extends JFrame implements ActionListener
{
   private Container container= getContentPane();
   private JLabel docForenameLabel=new JLabel("Forename");
   private JLabel docSurnameLabel=new JLabel("Surname");
   private JLabel docDOBLabel=new JLabel("Date of birth (yyyy-MM-dd)");
   private JLabel docSpecLabel=new JLabel("Speciality");
   private JLabel docPhoneNumberLabel=new JLabel("Phone Number");
   private JTextField forenameField=new JTextField();
   private JTextField surnameField=new JTextField();
   private JTextField dateOfBirthField=new JTextField();
   private JTextField specialityField=new JTextField();
   private JTextField phoneNumberField=new JTextField();
   private JButton addButton=new JButton("ADD");
   private JButton resetButton=new JButton("RESET");
   private JLabel titleLabel=new JLabel("Doctor registration form");
    DoctorFrame()
    {
        setLocationAndSize();
        addComponentsToContainer();
        setLayoutManager();
        addActionEvent();
    }
    public void setLayoutManager()
    {
       //Setting layout manager of Container to null
       container.setLayout(null);
    }
    public void setLocationAndSize()
    {
        //Setting location and Size of each component using setBounds() method.
    	titleLabel.setBounds(100,50,150,60);
        docForenameLabel.setBounds(50,100,100,30);
        forenameField.setBounds(250,100,150,30);
        docSurnameLabel.setBounds(50,150,100,30);
        surnameField.setBounds(250,150,150,30);
        docSpecLabel.setBounds(50,200,100,30);
        specialityField.setBounds(250,200,150,30);
        docPhoneNumberLabel.setBounds(50,250,150,30);
        phoneNumberField.setBounds(250,250,150,30);
        docDOBLabel.setBounds(50,300,175,30);
        dateOfBirthField.setBounds(250,300, 150,30);
        addButton.setBounds(50,500,100,30);
        resetButton.setBounds(200,500,100,30);
    }
    public void addComponentsToContainer()
   {
       container.add(titleLabel);
       container.add(docForenameLabel);
       container.add(docSurnameLabel);
       container.add(docSpecLabel);
       container.add(docDOBLabel);
       container.add(forenameField);
       container.add(surnameField);
       container.add(specialityField);
       container.add(dateOfBirthField);
       container.add(addButton);
       container.add(resetButton);
       container.add(docPhoneNumberLabel);
       container.add(phoneNumberField);
    }

    public void addActionEvent()
    {
       //adding Action listener to components
        addButton.addActionListener(this);
        resetButton.addActionListener(this);
    }
    
     @Override
    public void actionPerformed(ActionEvent e)
    {
    	 if (e.getSource() == resetButton)
         {
    		 forenameField.setText("");
    		 surnameField.setText("");
    		 specialityField.setText("");
    		 dateOfBirthField.setText("");
         }

         if(e.getSource() == addButton)
         {
             String Forename = forenameField.getText();
             String Surname = surnameField.getText();
             String Speciality = specialityField.getText();
             Date DoB=Date.valueOf(dateOfBirthField.getText());
             String phoneNumber = phoneNumberField.getText();

             try {
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c0559", "root", "Dark Shadow");
                 PreparedStatement stmt= connection.prepareStatement("INSERT INTO c0559.doctors(doctorForename , doctorSurname ,doctorSpeciality,doctorDoB,doctorPhoneNumber) VALUES(?,?,?,?,?)");
                 stmt.setString(1,Forename);
                 stmt.setString(2,Surname);
                 stmt.setString(3,Speciality);
                 stmt.setDate(4,DoB);
                 stmt.setString(5,phoneNumber);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(this, "Successful");
             }
             catch(Exception f)
             {
                 f.printStackTrace();
                 JOptionPane.showMessageDialog(this, "Invalid entry. Please re-check details entered");
             }

         }
    }


}
