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
public class DoctorFrame extends JFrame implements ActionListener
{
   private Container container= getContentPane();
   private JLabel docForenameLabel=new JLabel("Forename");
   private JLabel docSurnameLabel=new JLabel("Surname");
   private JLabel docDOBLabel=new JLabel("Date of birth");
   private JLabel docSpecLabel=new JLabel("Speciality");
   private JTextField forenameField=new JTextField();
   private JTextField surnameField=new JTextField();
   private JTextField dateOfBirthField=new JTextField();
   private JTextField specialityField=new JTextField();
   private JButton addButton=new JButton("ADD");
   private JButton resetButton=new JButton("RESET");
   private JLabel titleLabel=new JLabel("Doctor registation form");
    
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
    	titleLabel.setBounds(100,70,150,60);
        docForenameLabel.setBounds(50,150,100,30);
        forenameField.setBounds(150,150,150,30);
        docSurnameLabel.setBounds(50,220,100,30);
        surnameField.setBounds(150,220,150,30);
        docSpecLabel.setBounds(50,290,100,30);
        specialityField.setBounds(150,290,150,30);
        docDOBLabel.setBounds(50,370,100,30);
        dateOfBirthField.setBounds(150,370, 150,30);
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
