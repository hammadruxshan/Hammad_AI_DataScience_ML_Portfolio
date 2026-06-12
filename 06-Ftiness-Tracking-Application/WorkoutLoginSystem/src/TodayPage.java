import javax.swing.*;
import java.awt.*;

public class TodayPage {
    JFrame frame;

    public TodayPage() {
        frame = new JFrame("Today Page");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(20, 20)); 

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255,255,255));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel dateLabel = new JLabel("22 NOV", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Jersey 25", Font.BOLD, 24));
        mainPanel.add(dateLabel);

        ImageIcon originalImageIcon = new ImageIcon("src/icon/today1.png"); 
        Image image = originalImageIcon.getImage();
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
        JLabel pictureLabel = new JLabel(new ImageIcon(scaledImage));
        pictureLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(pictureLabel);

        JPanel dateImagePanel = new JPanel();
        dateImagePanel.setBackground(new Color(255,255,255));
        dateImagePanel.setLayout(new BoxLayout(dateImagePanel, BoxLayout.Y_AXIS));

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1.add(new JLabel("22 NOV"));
        ImageIcon firstImageIcon = new ImageIcon("src/icon/today5.png");
        Image firstImage = firstImageIcon.getImage();
        Image scaledFirstImage = firstImage.getScaledInstance(400, 250, Image.SCALE_SMOOTH); 
        JLabel firstImageLabel = new JLabel(new ImageIcon(scaledFirstImage));

        row1.add(firstImageLabel);

        firstImageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        row1.add(firstImageLabel);
        dateImagePanel.add(row1);
        
        mainPanel.add(dateImagePanel);
        
        row1.setBackground(new Color(255,255,255));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        String[] textLines = {
            "Meals",
            "Breakfast+",
            "Lunch+",
            "Dinner+",
            "Extra Meal+"
        };

        for (int i = 0; i < 5; i++) {
            JPanel textLinePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            textLinePanel.add(new JLabel(textLines[i]));

            if (i == 0) {
                ImageIcon rectImageIcon = new ImageIcon("src/icon/today3.png"); 
                Image rectImage = rectImageIcon.getImage();
                Image scaledRectImage = rectImage.getScaledInstance(200, 15, Image.SCALE_SMOOTH); 
                JLabel rectImageLabel = new JLabel(new ImageIcon(scaledRectImage));

                textLinePanel.add(rectImageLabel);
            }

        textLinePanel.setBackground(new Color(255,255,255));

        textPanel.add(textLinePanel);
        }

        mainPanel.add(textPanel);

        frame.add(mainPanel, BorderLayout.CENTER);

        JPanel bottomPanel = createBottomPanel();
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 10));

        JButton homeButton = createIconButton("src/icon/live13.jpg");
        JButton todayButton = createIconButton("src/icon/live14.png");
        JButton chatButton = createIconButton("src/icon/live15.png");
        JButton profileButton = createIconButton("src/icon/live16.png");

        buttonPanel.add(homeButton);
        buttonPanel.add(todayButton);
        buttonPanel.add(chatButton);
        buttonPanel.add(profileButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        homeButton.addActionListener(e -> {
            frame.dispose();
            new CoursesPage(); 
        });
        chatButton.addActionListener(e -> {
            frame.dispose();
            new ChatPage(); 
        });
        profileButton.addActionListener(e -> {
            frame.dispose();
            new ProfilePage();
        });

        return panel;
    }

    private JButton createIconButton(String iconPath) {
        ImageIcon icon = new ImageIcon(iconPath); 
        Image img = icon.getImage();  
        Image resizedImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
        icon = new ImageIcon(resizedImg); 

        JButton button = new JButton(icon);
        button.setPreferredSize(new Dimension(50, 50)); 
        button.setContentAreaFilled(false); 
        button.setBorderPainted(false); 
        button.setFocusPainted(false); 
        return button;
    }

}

