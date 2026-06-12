import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.ITALIC;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Log in");
    JButton signButton = new JButton("Sign up");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDlabel = new JLabel("Username");
    JLabel userpasslabel = new JLabel("Password");
    JLabel messagelabel = new JLabel("");
    HashMap<String, String> logininfo = new HashMap<>();

    LoginPage(HashMap<String, String> loginOG) {
        logininfo = loginOG;

        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(0x0c225d));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 

        JLabel loginTitle = new JLabel("Welcome!", JLabel.CENTER);
        loginTitle.setFont(new Font("Arial", Font.BOLD, 50));
        loginTitle.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        frame.add(loginTitle, gbc);

        JLabel loginTitle2 = new JLabel("Let's log in!", JLabel.CENTER);
        loginTitle2.setFont(new Font("Arial", Font.BOLD, 50));
        loginTitle2.setForeground(Color.WHITE);
        gbc.gridy = 1; 
        frame.add(loginTitle2, gbc);

        userIDlabel.setForeground(Color.WHITE);
        userIDlabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 2; 
        gbc.gridwidth = 1; 
        frame.add(userIDlabel, gbc);

        userIDField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        frame.add(userIDField, gbc);

        userpasslabel.setForeground(Color.WHITE);
        userpasslabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 3; 
        frame.add(userpasslabel, gbc);

        userPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        frame.add(userPasswordField, gbc);

        messagelabel.setFont(new Font("Arial", Font.ITALIC, 16));
        messagelabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4; 
        gbc.gridwidth = 2; 
        frame.add(messagelabel, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(new Color(0x0c225d));
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        signButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.addActionListener(this);
        signButton.addActionListener(this);
        buttonPanel.add(loginButton);
        buttonPanel.add(signButton);
        gbc.gridy = 5; 
        frame.add(buttonPanel, gbc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {                 
                   new SetupPage(); 
                } else {
                    messagelabel.setForeground(Color.red);
                    messagelabel.setText("Incorect Password , Try again");
                }
            } else {
                messagelabel.setForeground(Color.red);
                messagelabel.setText("User not found");
            }
        } else if (e.getSource() == signButton) {
            frame.dispose();
            new SignupPage(); 
        }
    }
}
		



    

