import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookingForm extends JFrame implements ActionListener {
 
    Container container=getContentPane();
    JLabel userLabel=new JLabel("patientID");
    JList<String> patientList = new JList();
    JTextField patientField=new JTextField();
    JLabel timeLabel=new JLabel("booking time");
    JTextField timeField=new JTextField();
    JLabel doctorLabel=new JLabel("Doctor ID");
    JTextField doctorField=new JTextField();
    JLabel dateLabel=new JLabel("Booking date");
    JTextField bookingDateField=new JTextField();
    JLabel reasonLabel=new JLabel("Booking reason");
    JTextField reasonField=new JTextField();
    JButton submitButton=new JButton("Submit");
    JButton cancelButton=new JButton("cancel");
    JLabel formLabel = new JLabel("Booking Form");

    
    BookingForm()
    {
        //Calling setLayoutManger() method inside the constructor.
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
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
       userLabel.setBounds(50,150,100,30);
       patientField.setBounds(150,150,150,30);
       doctorLabel.setBounds(50,220,100,30);
       doctorField.setBounds(150,220,150,30);
       dateLabel.setBounds(50,270,100,30);
       bookingDateField.setBounds(150, 270,150, 30);
       timeLabel.setBounds(50,320,100,30);
       timeField.setBounds(150,320,150,30);
       reasonLabel.setBounds(50,370,100,30);
       reasonField.setBounds(150,370,150,100);
       submitButton.setBounds(50,500,100,30);
       cancelButton.setBounds(200,500,100,30);
       formLabel.setBounds(125,70, 100, 50);  
 
   }
   
   public void addComponentsToContainer()
   {
      //Adding each components to the Container
       container.add(userLabel);
       container.add(patientField);
       container.add(doctorLabel);
       container.add(doctorField);
       container.add(dateLabel);
       container.add(bookingDateField);
       container.add(timeLabel);
       container.add(timeField);
       container.add(reasonLabel);
       container.add(reasonField);
       container.add(submitButton);
       container.add(cancelButton);
       container.add(patientList);
       container.add(formLabel);
   }
   
   public void addActionEvent()
   {
      //adding Action listener to components
       submitButton.addActionListener(this);
       cancelButton.addActionListener(this);
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == submitButton) {
            String userText;
            String pwdText;
            userText = timeField.getText();
 
        }
        //Coding Part of RESET button
        if (e.getSource() == cancelButton) {
            timeField.setText("");
        }
       //Coding Part of showPassword JCheckBox
    }

    public void sql()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c0559", "root", "Dark Shadow");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from c0559.co559_receptionists");
            while (resultSet.next())
            {

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}