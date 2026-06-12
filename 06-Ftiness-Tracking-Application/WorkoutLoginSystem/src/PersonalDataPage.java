import javax.swing.*;
import java.awt.*;

public class PersonalDataPage extends JPanel{
    JFrame frame;
    
    public PersonalDataPage () {
        frame = new JFrame("Personal Data");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(10, 20, 80));

        JButton backButton = new JButton("<");
        backButton.setFont(new Font("Inria Sans", Font.BOLD, 20));
        backButton.setForeground(Color.WHITE);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(50, 30)); 
        backButton.addActionListener(e -> {
            frame.dispose();
            new ProfilePage(); 
        });

        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        backButtonPanel.setOpaque(false); 
        backButtonPanel.add(backButton);

        headerPanel.add(backButtonPanel, BorderLayout.WEST);

        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setBackground(new Color(10, 20, 80)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel titleLabel = new JLabel("Personal Data", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER;
        titlePanel.add(titleLabel, gbc);
        
        headerPanel.add(titlePanel, BorderLayout.CENTER);
        
        frame.add(headerPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(10, 20, 80)); 
        
        addLabeledField(formPanel, gbc, "Weight(kg)", 1);
        addLabeledField(formPanel, gbc, "Height(cm)", 2);
        addLabeledField(formPanel, gbc, "Bust/Chest(cm)", 3);
        addLabeledField(formPanel, gbc, "Waist(cm)", 4);
        addLabeledField(formPanel, gbc, "Hips(cm)", 5);
        
        frame.add(formPanel, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }

    private void addLabeledField(JPanel formPanel, GridBagConstraints gbc, String labelText, int row) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(label, gbc);

        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setPreferredSize(new Dimension(300, 40));
        textField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST; 
        formPanel.add(textField, gbc);
    }

}
