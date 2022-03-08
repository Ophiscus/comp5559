import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
   private JLabel patDOBLabel=new JLabel("Date of birth");
   private JLabel patSpecLabel=new JLabel("Speciality");
   private JTextField forenameField=new JTextField();
   private JTextField surnameField=new JTextField();
   private JTextField dateOfBirthField=new JTextField();
   private JTextField specialityField=new JTextField();
   private JButton addButton=new JButton("ADD");
   private JButton resetButton=new JButton("RESET");
   private JLabel titleLabel=new JLabel("Doctor registation form");
    
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
    	titleLabel.setBounds(100,70,150,60);
        patForenameLabel.setBounds(50,150,100,30);
        forenameField.setBounds(150,150,150,30);
        patSurnameLabel.setBounds(50,220,100,30);
        surnameField.setBounds(150,220,150,30);
        patSpecLabel.setBounds(50,290,100,30);
        specialityField.setBounds(150,290,150,30);
        patDOBLabel.setBounds(50,370,100,30);
        dateOfBirthField.setBounds(150,370, 150,30);
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
    }
}

