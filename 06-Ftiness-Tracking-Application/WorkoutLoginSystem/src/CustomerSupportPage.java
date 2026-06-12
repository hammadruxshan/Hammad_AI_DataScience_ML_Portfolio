import javax.swing.*;
import java.awt.*;

public class CustomerSupportPage extends JPanel{
    JFrame frame;

    public CustomerSupportPage() {
        frame = new JFrame("Customer Support");
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

        JPanel titleIconPanel = new JPanel(new GridBagLayout());
        titleIconPanel.setBackground(new Color(10, 20, 80)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel titleLabel = new JLabel("Customer Support", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        titleIconPanel.add(titleLabel, gbc);

        ImageIcon icon = new ImageIcon(new ImageIcon("src/icon/cs1.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        gbc.gridy = 1;
        titleIconPanel.add(iconLabel, gbc);

        headerPanel.add(titleIconPanel, BorderLayout.CENTER);

        frame.add(headerPanel, BorderLayout.NORTH);

        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        chatPanel.setBackground(new Color(10, 20, 80)); 
        JLabel chatBubble = new JLabel("Hi! How can I help you?");
        chatBubble.setOpaque(true);
        chatBubble.setBackground(Color.WHITE);
        chatBubble.setFont(new Font("Arial", Font.PLAIN, 16));
        chatBubble.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        chatBubble.setAlignmentX(Component.LEFT_ALIGNMENT);
        chatBubble.setMaximumSize(new Dimension(300, 50));
        chatPanel.add(Box.createRigidArea(new Dimension(0, 20))); 
        chatPanel.add(chatBubble);
        frame.add(chatPanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(Color.WHITE); 
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setPreferredSize(new Dimension(0, 40));
        inputField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JButton emojiButton = new JButton();
        ImageIcon emojiIcon = new ImageIcon(new ImageIcon("src/icon/cs2.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)); 
        emojiButton.setIcon(emojiIcon); 
        emojiButton.setContentAreaFilled(false); 
        emojiButton.setBorderPainted(false); 
        emojiButton.setFocusPainted(false); 

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(emojiButton, BorderLayout.EAST);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

}
