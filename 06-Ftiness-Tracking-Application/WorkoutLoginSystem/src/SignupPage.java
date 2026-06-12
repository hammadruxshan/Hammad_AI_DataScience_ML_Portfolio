
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignupPage {

    public SignupPage() {
        JFrame frame = new JFrame("Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(0x0c225d));
        frame.setVisible(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel title = new JLabel("Sign Up");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(title, gbc);

        addLabeledField(frame, gbc, "Username", 1);
        addLabeledField(frame, gbc, "Age", 2);
        addLabeledField(frame, gbc, "Email", 3);
        addLabeledField(frame, gbc, "Phone Number", 4);
        addLabeledField(frame, gbc, "Password", 5);
        addLabeledField(frame, gbc, "Confirm Password", 6);

        JButton signUpButton = new JButton("Sign up");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
        signUpButton.setPreferredSize(new Dimension(150, 40));
        signUpButton.setBackground(Color.WHITE);
        signUpButton.setForeground(Color.BLACK);
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(signUpButton, gbc);
        
        signUpButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose(); 
            new SetupPage(); 
        }
        }
        );

        JLabel alreadyHaveAccount = new JLabel("Already have an account? Sign in.");
        alreadyHaveAccount.setFont(new Font("Arial", Font.PLAIN, 14));
        alreadyHaveAccount.setForeground(Color.WHITE);
        gbc.gridy = 8;
        frame.add(alreadyHaveAccount, gbc);
        
    }

    private void addLabeledField(JFrame frame, GridBagConstraints gbc, String labelText, int row) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(label, gbc);

        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setPreferredSize(new Dimension(300, 40));
        textField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(textField, gbc);
    }

    public static void main(String[] args) {
        new SignupPage();
        
    }
}

