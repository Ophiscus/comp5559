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
public class PatientFrame extends JFrame implements ActionListener
{
   private Container container= getContentPane();
   private JLabel patForenameLabel=new JLabel("Forename");
   private JLabel patSurnameLabel=new JLabel("Surname");
   private JLabel patDOBLabel=new JLabel("Date of birth (yyyy-MM-dd)");
   private JLabel patSpecLabel=new JLabel("gender");
   private JLabel patPhoneNumberLabel=new JLabel("Phone Number");
   private JTextField forenameField=new JTextField();
   private JTextField surnameField=new JTextField();
   private JTextField dateOfBirthField=new JTextField();
   private JTextField specialityField=new JTextField();
   private JTextField phoneNumberField=new JTextField();
   private JButton addButton=new JButton("ADD");
   private JButton resetButton=new JButton("RESET");
   private JLabel titleLabel=new JLabel("Patient registation form");
    
    PatientFrame()
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
        //Setting location and Size of each components using setBounds() method.
    	titleLabel.setBounds(100,30,150,60);
        patForenameLabel.setBounds(50,100,100,30);
        forenameField.setBounds(250,100,150,30);
        patSurnameLabel.setBounds(50,150,100,30);
        surnameField.setBounds(250,150,150,30);
        patSpecLabel.setBounds(50,200,100,30);
        specialityField.setBounds(250,200,150,30);
        patPhoneNumberLabel.setBounds(50,250,100,30);
        phoneNumberField.setBounds(250,250,150,30);
        patDOBLabel.setBounds(50,300,150,30);
        dateOfBirthField.setBounds(250,300, 150,30);
        addButton.setBounds(50,500,100,30);
        resetButton.setBounds(200,500,100,30);
    }
    public void addComponentsToContainer()
   {
       container.add(titleLabel);
       container.add(patForenameLabel);
       container.add(patSurnameLabel);
       container.add(patSpecLabel);
       container.add(patDOBLabel);
       container.add(forenameField);
       container.add(surnameField);
       container.add(specialityField);
       container.add(dateOfBirthField);
       container.add(addButton);
       container.add(resetButton);
       container.add(patPhoneNumberLabel);
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
    	 if (e.getSource() == resetButton) {
    		 forenameField.setText("");
    		 surnameField.setText("");
    		 specialityField.setText("");
    		 dateOfBirthField.setText("");
         }
         if(e.getSource() == addButton)
         {
             String patientForename = forenameField.getText();
             String patientSurname = surnameField.getText();
             String patientGender = specialityField.getText();
             String patientPhoneNumber = phoneNumberField.getText();
             String patientDoB = dateOfBirthField.getText();
             try {
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c0559", "root", "Dark Shadow");
                 PreparedStatement stmt= connection.prepareStatement("INSERT INTO c0559.patient(patientForename, patientSurname, patientGender, patientPhoneNumber, patientDoB) VALUES(?,?,?,?,?)");
                 stmt.setString(1,patientForename);
                 stmt.setString(2,patientSurname);
                 stmt.setString(3,patientGender);
                 stmt.setDate(5, Date.valueOf(patientDoB));
                 stmt.setString(4,patientPhoneNumber);
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

