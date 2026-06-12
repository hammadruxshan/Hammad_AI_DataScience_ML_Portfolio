import javax.swing.*;
import java.awt.*;

public class AchievementPage extends JPanel {
    JFrame frame;

    public AchievementPage() {
        frame = new JFrame("Achievement");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE); 
        
        JButton backButton = new JButton("<");
        backButton.setFont(new Font("Inria Sans", Font.BOLD, 20));
        backButton.setForeground(Color.BLACK);
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
        titlePanel.setBackground(Color.WHITE); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel titleLabel = new JLabel("Achievement", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER;
        titlePanel.add(titleLabel, gbc);

        headerPanel.add(titlePanel, BorderLayout.CENTER);

        frame.add(headerPanel, BorderLayout.NORTH);

        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 

        ImageIcon icon = new ImageIcon(new ImageIcon("src/icon/am1.jpg")
                .getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH));
        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        iconPanel.setBackground(Color.WHITE);

        iconPanel.add(iconLabel);

        frame.add(iconPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
