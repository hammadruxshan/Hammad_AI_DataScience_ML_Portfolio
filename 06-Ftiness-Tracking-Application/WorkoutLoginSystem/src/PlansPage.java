import javax.swing.*;
import java.awt.*;

public class PlansPage {
    JFrame frame = new JFrame("Plans Page");

    PlansPage() {
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = createTopPanel();
        frame.add(topPanel, BorderLayout.NORTH);

        JPanel middlePanel = createMiddlePanel();
        frame.add(middlePanel, BorderLayout.CENTER);
        
        JPanel bottomPanel = createBottomPanel();
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void setButtonStyle(JButton button) {
        button.setBackground(new Color(255, 255, 255)); // Set background color (White)
        button.setOpaque(false);  // Make the button background transparent
        button.setBorderPainted(false);  // Remove the button's border
        button.setContentAreaFilled(false);  // Remove the content area background
        button.setFocusPainted(false);  // Remove the blue focus line
        button.setFont(new Font("Archivo Narrow", Font.BOLD, 12));  // Set the font
        button.setForeground(Color.GRAY);
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel.setBackground(new Color(255,255,255));

        JButton courseButton = new JButton("Course");
        JButton plansButton = new JButton("Plans");
        JButton liveButton = new JButton("Live");
        JButton coachButton = new JButton("Coach");

        setButtonStyle(courseButton);
        setButtonStyle(plansButton);
        setButtonStyle(liveButton);
        setButtonStyle(coachButton);
        
        plansButton.setForeground(Color.BLACK);

        panel.add(courseButton);
        panel.add(plansButton);
        panel.add(liveButton);
        panel.add(coachButton);

        courseButton.addActionListener(e -> {
            frame.dispose();
            new CoursesPage(); 
        });
        plansButton.addActionListener(e -> {
            frame.dispose();
            new PlansPage(); 
        });
        liveButton.addActionListener(e -> {
            frame.dispose();
            new LivePage(); 
        });

        return panel;
    }


    private JPanel createMiddlePanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBackground(Color.WHITE);

    // Header Image with Overlay Text
    JLabel headerLabel = new JLabel();
    headerLabel.setLayout(new BorderLayout());
    ImageIcon headerIcon = new ImageIcon(new ImageIcon("src/icon/p111.png").getImage().getScaledInstance(790, 218, Image.SCALE_SMOOTH));
    headerLabel.setIcon(headerIcon);
    JLabel overlayText = new JLabel();
    overlayText.setFont(new Font("Arial", Font.BOLD, 24));
    headerLabel.add(overlayText);
    panel.add(headerLabel, BorderLayout.NORTH);


    // Create the suggested workouts section
    JPanel suggestedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
    suggestedPanel.setBackground(new Color(255, 255, 255));

    String[] workoutImages = {"src/icon/plans1.png", "src/icon/plans2.png", "src/icon/plans3.png", "src/icon/plans4.png"};
    String[] workoutNames = {"Arms Training", "Running", "Pilates", "Yoga"};

    for (int i = 0; i < workoutImages.length; i++) {
        JPanel workoutPanel = new JPanel();
        workoutPanel.setLayout(new BorderLayout());
        workoutPanel.setPreferredSize(new Dimension(200, 180));

        ImageIcon workoutIcon = new ImageIcon(new ImageIcon(workoutImages[i]).getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH));
        JLabel picLabel = new JLabel(workoutIcon);
        JLabel nameLabel = new JLabel(workoutNames[i], SwingConstants.CENTER);

        workoutPanel.add(picLabel, BorderLayout.CENTER);
        workoutPanel.add(nameLabel, BorderLayout.SOUTH);

        suggestedPanel.add(workoutPanel);
    }


    // JScrollPane to enable horizontal scrolling
    JScrollPane scrollPane = new JScrollPane(suggestedPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBorder(BorderFactory.createEmptyBorder());
    scrollPane.setPreferredSize(new Dimension(panel.getWidth(), 250));  // Adjust height as needed

    panel.add(scrollPane, BorderLayout.CENTER);

    return panel;
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
        todayButton.addActionListener(e -> {
            frame.dispose();
            new TodayPage(); 
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

    public static void main(String[] args) {
        new CoursesPage();
    }
}


