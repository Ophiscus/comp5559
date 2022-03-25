import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectorFrame extends JFrame implements ActionListener{
    Container container = getContentPane();
    JButton doctorButton=new JButton("DoctorForm");
    JButton patientButton=new JButton("PatientForm");
    JButton bookingButton=new JButton("BookingForm");
    JLabel tableLable = new JLabel("Which Form do you wish access? ");

    public ConnectorFrame()
    {
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
        doctorButton.setBounds(50,150,150,30);
        patientButton.setBounds(50,200,150,30);
        bookingButton.setBounds(50,250,150, 30);
        tableLable.setBounds(50,70,200,30);
    }

    public void addComponentsToContainer()
    {
        container.add(doctorButton);
        container.add(patientButton);
        container.add(bookingButton);
        container.add(tableLable);
    }

    public void addActionEvent()
    {
        //adding Action listener to components
        doctorButton.addActionListener(this);
        patientButton.addActionListener(this);
        bookingButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == doctorButton)
        {
            DoctorFrame jframe=new DoctorFrame();
            jframe.setTitle("Doctor Form");
            jframe.setVisible(true);
            jframe.setBounds(10,10,470,600);
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jframe.setResizable(true);
        }

        if(e.getSource() == patientButton)
        {
            PatientFrame jframe = new PatientFrame();
            jframe.setTitle("Patient Form");
            jframe.setVisible(true);
            jframe.setBounds(10,10,470,600);
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jframe.setResizable(true);
        }

        if(e.getSource() == bookingButton)
        {
            BookingForm jframe=new BookingForm();
            jframe.setTitle("Booking Form");
            jframe.setVisible(true);
            jframe.setBounds(10,10,470,600);
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jframe.setResizable(true);
        }
    }
}
