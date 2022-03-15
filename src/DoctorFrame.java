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
   private JLabel docDOBLabel=new JLabel("Date of birth");
   private JLabel docSpecLabel=new JLabel("Speciality");
   private JLabel docPhoneNumberLabel=new JLabel("Phone Number");
   private JTextField forenameField=new JTextField();
   private JTextField surnameField=new JTextField();
   private JTextField dateOfBirthField=new JTextField();
   private JTextField specialityField=new JTextField();
   private JTextField phoneNumberField=new JTextField();
   private JButton addButton=new JButton("ADD");
   private JButton resetButton=new JButton("RESET");
   private JLabel titleLabel=new JLabel("Doctor registation form");
   private int count = 6;
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
        //Setting location and Size of each components using setBounds() method.
    	titleLabel.setBounds(100,50,150,60);
        docForenameLabel.setBounds(50,100,100,30);
        forenameField.setBounds(150,100,150,30);
        docSurnameLabel.setBounds(50,150,100,30);
        surnameField.setBounds(150,150,150,30);
        docSpecLabel.setBounds(50,200,100,30);
        specialityField.setBounds(150,200,150,30);
        docPhoneNumberLabel.setBounds(50,250,150,30);
        phoneNumberField.setBounds(150,250,150,30);
        docDOBLabel.setBounds(50,300,100,30);
        dateOfBirthField.setBounds(150,300, 150,30);
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
             String doctorForename = forenameField.getText();
             String doctorSurname = surnameField.getText();
             String doctorSpeciality = specialityField.getText();
             String doctorDoB = dateOfBirthField.getText();
             String doctorPhoneNumber = phoneNumberField.getText();
             String number = Integer.toString(count);
             String insertSql = "INSERT INTO c0559.doctors-table ( "+ number + ", " + doctorForename + ", " + doctorSurname + ", " + doctorSpeciality + ", " + doctorDoB + "," + doctorPhoneNumber +" );";
             try {
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c0559", "root", "Dark Shadow");
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = null;
                 PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql,Statement.RETURN_GENERATED_KEYS);
                 prepsInsertProduct.execute();
                 resultSet = prepsInsertProduct.getGeneratedKeys();
             }
             catch(Exception f)
             {
                 f.printStackTrace();
             }
            count ++;

         }
    }

    public void sql()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c0559", "root", "Dark Shadow");
            Statement statement = connection.createStatement();
            ResultSet resultSet = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
