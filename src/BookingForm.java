import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class BookingForm extends JFrame implements ActionListener {

    Container container=getContentPane();
    JLabel userLabel=new JLabel("patientID");
    JTextField patientField=new JTextField();
    JLabel doctorLabel=new JLabel("Doctor ID");
    JTextField doctorField=new JTextField();
    JLabel dateLabel=new JLabel("Booking date (yyyy-MM-dd)");
    JTextField bookingDateField=new JTextField();
    JLabel reasonLabel=new JLabel("Booking reason");
    JTextField reasonField=new JTextField();
    JButton submitButton=new JButton("Submit");
    JButton cancelButton=new JButton("cancel");
    JLabel formLabel = new JLabel("Booking Form");
    JButton editButton = new JButton("edit");

    
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
       patientField.setBounds(250,150,150,30);
       doctorLabel.setBounds(50,220,100,30);
       doctorField.setBounds(250,220,150,30);
       dateLabel.setBounds(50,270,150,30);
       bookingDateField.setBounds(250, 270,150, 30);
       reasonLabel.setBounds(50,320,100,30);
       reasonField.setBounds(250,320,150,100);
       submitButton.setBounds(15,500,85,30);
       cancelButton.setBounds(115,500,85,30);
       formLabel.setBounds(125,70, 100, 50);  
        editButton.setBounds(215,500,85,30);
   }
   
   public void addComponentsToContainer()
   {
      //Adding each components to the Container
       container.add(userLabel);
       container.add(patientField);
       container.add(doctorLabel);
       container.add(doctorField);
       container.add(dateLabel);
       container.add(bookingDateField);;
       container.add(reasonLabel);
       container.add(reasonField);
       container.add(submitButton);
       container.add(cancelButton);
       container.add(formLabel);
       container.add(editButton);
   }
   
   public void addActionEvent()
   {
      //adding Action listener to components
       submitButton.addActionListener(this);
       cancelButton.addActionListener(this);
       editButton.addActionListener(this);
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == submitButton) {
            int doctorID = Integer.parseInt(doctorField.getText());
            int patientID = Integer.parseInt(patientField.getText());
            Date bookingDate= Date.valueOf(bookingDateField.getText());
            String bookingReason = reasonField.getText();
             try {
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c0559", "root", "Dark Shadow");
                 PreparedStatement stmt= connection.prepareStatement("INSERT INTO c0559.booking(doctorID, patientID, bookingDate, bookingReason) VALUES(?,?,?,?)");
                 stmt.setInt(1,doctorID);
                 stmt.setInt(2,patientID);
                 stmt.setDate(3, bookingDate);
                 stmt.setString(4,bookingReason);
                 stmt.executeUpdate();
                 JOptionPane.showMessageDialog(this, " Successful");
             }
             catch(Exception f)
             {
                 f.printStackTrace();
                 JOptionPane.showMessageDialog(this, "Invalid entry. Please re-check details entered");
             }
 
        }
        //Coding Part of RESET button
        if (e.getSource() == cancelButton) {
            bookingDateField.setText("");
            patientField.setText("");
            doctorField.setText("");
            reasonField.setText("");
        }

        if(e.getSource() == editButton){
            JOptionPane.showMessageDialog(this, "Login Successful");
            EditBookingFrame jframe = new EditBookingFrame();
            jframe.setTitle("Edit Form");
            jframe.setVisible(true);
            jframe.setBounds(10,10,470,600);
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jframe.setResizable(true);
            setVisible(false); //you can't see me!
            dispose();
        }
       //Coding Part of showPassword JCheckBox
    }
}