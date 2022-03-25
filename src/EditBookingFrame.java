import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class EditBookingFrame  extends JFrame implements ActionListener{

    ArrayList<Integer> doctorIDs = new ArrayList<>();

    private JLabel patientIDLabel=new JLabel("patientID");
    private JLabel currentDoctorIDLabel=new JLabel("DoctorID");
    private JLabel newDoctorLabel=new JLabel("New Doctor");
    private JLabel frameTextLabel = new JLabel("Please enter patientId to edit");
    private JTextField patientIDText = new JTextField();
    private JTextField currentDoctorIDText = new JTextField();
    private JTextField newDoctorText = new JTextField();
    private Container container= getContentPane();
    private JButton editButton = new JButton("Edit");
    private JButton searchButton = new JButton("Search");
    private JButton deleteButton = new JButton("delete");
    
    public EditBookingFrame()
    {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
    }

    public void setLayoutManager()
    {
        //Setting layout manager of Container to null
        container.setLayout(null);
    }

    public void setLocationAndSize()
    {
        frameTextLabel.setBounds(100,30,150,60);
        patientIDLabel.setBounds(15,100,85,30);
        patientIDText.setBounds(100,100,150,30);
        searchButton.setBounds(265,100,100,30);
        currentDoctorIDLabel.setBounds(15,150,85,30);
        currentDoctorIDText.setBounds(100,150,150,30);
        newDoctorLabel.setBounds(15,200,85,30);
        newDoctorText.setBounds(100,200,150,30);
        editButton.setBounds(50,250,100,30);

    }

    public void addComponentsToContainer()
    {
        container.add(frameTextLabel);
        container.add(patientIDLabel);
        container.add(patientIDText);
        container.add(searchButton);
        container.add(currentDoctorIDLabel);
        container.add(currentDoctorIDText);
        container.add(newDoctorLabel);
        container.add(newDoctorText);
        container.add(editButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton)
        {
            int number = Integer.parseInt(patientIDText.getText());
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c0559", "root", "Dark Shadow");
                PreparedStatement stmt = connection.prepareStatement("select * from c0559.receptionists WHERE patientID =?");
                stmt.setInt(1,number);
                ResultSet resultSet = stmt.executeQuery(String.valueOf(stmt));
                 int str = resultSet.getInt( "doctorID");
                currentDoctorIDText.setText(Integer.toString(str));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if(e.getSource() == editButton)
        {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c0559", "root", "Dark Shadow");
                PreparedStatement stmt = connection.prepareStatement("UPDATE c0559.booking SET doctorID = ? WHERE patientID = ?");
                stmt.setInt(1,Integer.parseInt(newDoctorText.getText()));
                stmt.setInt(2,Integer.parseInt(patientIDText.getText()));
                stmt.executeUpdate();

            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}