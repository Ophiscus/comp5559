import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class LoginFrame extends JFrame implements ActionListener {

    ArrayList <String> userName= new ArrayList<>();
    ArrayList <String> password= new ArrayList<>();

    Container container=getContentPane();
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");
    
    LoginFrame()
    {
        //Calling setLayoutManger() method inside the constructor.
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        sql();
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
       passwordLabel.setBounds(50,220,100,30);
       userTextField.setBounds(150,150,150,30);
       passwordField.setBounds(150,220,150,30);
       showPassword.setBounds(150,250,150,30);
       loginButton.setBounds(50,300,100,30);
       resetButton.setBounds(200,300,100,30);
 
 
   }
   
   public void addComponentsToContainer()
   {
      //Adding each components to the Container
       container.add(userLabel);
       container.add(passwordLabel);
       container.add(userTextField);
       container.add(passwordField);
       container.add(showPassword);
       container.add(loginButton);
       container.add(resetButton);
   }
   
   public void addActionEvent()
   {
      //adding Action listener to components
       loginButton.addActionListener(this);
       resetButton.addActionListener(this);
       showPassword.addActionListener(this);
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            Boolean answer = true;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            for(int i = 0; i < userName.size(); i++)
            {
                String name = userName.get(i);
                String pass = password.get(i);
                if (userText.equalsIgnoreCase(name) && pwdText.equalsIgnoreCase(pass)) {
                    JOptionPane.showMessageDialog(this, "Login Successful");
                    ConnectorFrame jframe=new ConnectorFrame();
                    jframe.setTitle("Login Form");
                    jframe.setVisible(true);
                    jframe.setBounds(10,10,370,600);
                    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jframe.setResizable(true);
                    break;
                } else {
                    answer = false;
                }
            }
           if (answer == false)
           {
               JOptionPane.showMessageDialog(this, "Invalid Username or Password");
           }
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
 
 
        }
    }

    public void sql()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c0559", "root", "Dark Shadow");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from c0559.co559_receptionists");
            while (resultSet.next())
            {
                userName.add(resultSet.getString("receptionistUsername"));
                password.add(resultSet.getString("receptionistPassword"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
 