import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LivePage {
    JFrame frame = new JFrame("Live Page");

    LivePage() {
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
        button.setBackground(new Color(255, 255, 255)); 
        button.setOpaque(false);  
        button.setBorderPainted(false);  
        button.setContentAreaFilled(false);  
        button.setFocusPainted(false);  
        button.setFont(new Font("Archivo Narrow", Font.BOLD, 12));
        button.setForeground(Color.GRAY);
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panel.setBackground(new Color(255, 255, 255)); 

        JButton courseButton = new JButton("Course");
        JButton plansButton = new JButton("Plans");
        JButton liveButton = new JButton("Live");
        JButton coachButton = new JButton("Coach");

        setButtonStyle(courseButton);
        setButtonStyle(plansButton);
        setButtonStyle(liveButton);
        setButtonStyle(coachButton);

        liveButton.setForeground(Color.BLACK);

        JPanel liveButtonContainer = new JPanel();
        liveButtonContainer.setLayout(new BorderLayout());
        liveButtonContainer.setBackground(new Color(255, 255, 255)); 

        liveButtonContainer.add(liveButton, BorderLayout.CENTER);

        JPanel redLinePanel = new JPanel();
        redLinePanel.setBackground(Color.RED);

        int liveButtonWidth = liveButton.getPreferredSize().width;
        redLinePanel.setPreferredSize(new Dimension(20, 3)); 

        liveButtonContainer.add(redLinePanel, BorderLayout.SOUTH);

        panel.add(courseButton);
        panel.add(plansButton);
        panel.add(liveButtonContainer); 
        panel.add(coachButton);

        courseButton.addActionListener(e -> {
            frame.dispose();
            new CoursesPage(); 
        });
        plansButton.addActionListener(e -> {
            frame.dispose();
            new PlansPage(); 
        });
        coachButton.addActionListener(e -> {
            frame.dispose();
            new CoachPage(); 
        });

        return panel;
    }

    public static ImageIcon createCircularImage(String imagePath, int diameter) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage();
            BufferedImage circularImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2 = circularImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setClip(new java.awt.geom.Ellipse2D.Float(0, 0, diameter, diameter));
            g2.drawImage(image, 0, 0, diameter, diameter, null);
            g2.dispose();

            return new ImageIcon(circularImage);
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private JPanel createMiddlePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0)); 
        buttonPanel.setBackground(Color.WHITE);

        JButton searchButton = new JButton();
        searchButton.setIcon(new ImageIcon(new ImageIcon("src/icon/search.jpg")  
                    .getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))); 
        searchButton.setBackground(new Color(255, 255, 255)); 
        searchButton.setForeground(Color.WHITE); 
        searchButton.setPreferredSize(new Dimension(20, 20)); 
        searchButton.setBorder(BorderFactory.createEmptyBorder()); 
        searchButton.setContentAreaFilled(false); 
        searchButton.setFocusPainted(false); 
        buttonPanel.add(searchButton, BorderLayout.WEST); 

        JButton suggestedButton = new JButton("Suggested");
        suggestedButton.setFont(new Font("Inria Sans", Font.BOLD, 12));
        suggestedButton.setContentAreaFilled(false);
        suggestedButton.setFocusPainted(false);
        suggestedButton.setBorder(BorderFactory.createEmptyBorder());
        buttonPanel.add(suggestedButton);

        JButton followButton = new JButton("Follow");
        followButton.setFont(new Font("Inria Sans", Font.BOLD, 12));
        followButton.setContentAreaFilled(false);
        followButton.setFocusPainted(false);
        followButton.setBorder(BorderFactory.createEmptyBorder());
        followButton.setForeground(Color.GRAY);
        buttonPanel.add(followButton);

        JPanel profilePanel = new JPanel(new GridLayout(2, 4, 5, 5)); 
        profilePanel.setBackground(Color.WHITE);

        String[][] profileData = {
            {"Spiderman", "src/icon/live1.jpg", "src/icon/live5.jpg"},
            {"Minion", "src/icon/live2.jpg", "src/icon/live6.jpg"},
            {"PaperCat", "src/icon/live3.jpg", "src/icon/live7.jpg"},
            {"Ghosttt", "src/icon/live4.jpg", "src/icon/live8.jpg"},
            {"Quirky", "src/icon/live18.jpg", "src/icon/live17.jpg"},
            {"Kirby", "src/icon/live20.jpg", "src/icon/live19.jpg"},
            {"Jerry", "src/icon/live22.jpg", "src/icon/live21.jpg"},
            {"GUin", "src/icon/live24.jpg", "src/icon/live23.jpg"} 
        };

        for (int i = 0; i < profileData.length; i++) {
            JPanel profileCard = new JPanel();
            profileCard.setLayout(new BorderLayout());
            profileCard.setBackground(Color.WHITE);
            profileCard.setPreferredSize(new Dimension(210, 270));

            ImageIcon rectangularIcon = new ImageIcon(profileData[i][1]);
            Image rectangularImage = rectangularIcon.getImage().getScaledInstance(210, 250, Image.SCALE_SMOOTH);
            JLabel rectangularImageLabel = new JLabel(new ImageIcon(rectangularImage));
            profileCard.add(rectangularImageLabel, BorderLayout.CENTER);

            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 10)); 
            bottomPanel.setBackground(Color.WHITE);

            JLabel profileNameLabel = new JLabel(profileData[i][0]);
            profileNameLabel.setFont(new Font("Inria Sans", Font.PLAIN, 12));
            profileNameLabel.setHorizontalAlignment(SwingConstants.LEFT);

            JLabel roundProfileImageLabel = new JLabel(createCircularImage(profileData[i][2], 40));
            roundProfileImageLabel.setPreferredSize(new Dimension(50, 50));

            bottomPanel.add(profileNameLabel);
            bottomPanel.add(roundProfileImageLabel);

            profileCard.add(bottomPanel, BorderLayout.SOUTH);

            profilePanel.add(profileCard);
        }

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(profilePanel, BorderLayout.CENTER);

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

}