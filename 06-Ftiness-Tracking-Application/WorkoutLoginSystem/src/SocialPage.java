
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class SocialPage {
    JFrame frame = new JFrame("Social Page");

    SocialPage() {
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
    
    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 255, 255)); 

        JPanel buttonContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 0));
        buttonContainer.setBackground(new Color(255, 255, 255));

        JButton postButton = new JButton();
        postButton.setIcon(new ImageIcon(new ImageIcon("src/icon/social1.png")  
                    .getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))); 
        postButton.setBackground(new Color(255, 255, 255)); 
        postButton.setForeground(Color.WHITE); 
        postButton.setPreferredSize(new Dimension(25, 25)); 
        postButton.setBorder(BorderFactory.createEmptyBorder()); 
        postButton.setContentAreaFilled(false); 
        postButton.setFocusPainted(false); 
        
        JButton chatButton = new JButton();
        chatButton.setIcon(new ImageIcon(new ImageIcon("src/icon/social2.png")  
                    .getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))); 
        chatButton.setBackground(new Color(255, 255, 255)); 
        chatButton.setForeground(Color.WHITE); 
        chatButton.setPreferredSize(new Dimension(25, 25)); 
        chatButton.setBorder(BorderFactory.createEmptyBorder()); 
        chatButton.setContentAreaFilled(false); 
        chatButton.setFocusPainted(false); 

        buttonContainer.add(postButton);
        buttonContainer.add(chatButton);

        panel.add(buttonContainer, BorderLayout.EAST);

        postButton.addActionListener(e -> {
            frame.dispose();
            new PostPage(); 
        });
        chatButton.addActionListener(e -> {
            frame.dispose();
            new ChatPage(); 
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
            {"Awwww", "src/icon/social12.jpg"},
            {"Light", "src/icon/social13.jpg"},
            {"Night", "src/icon/social14.jpg"},
            {".", "src/icon/social15.jpg"},
            {"Snoopy", "src/icon/social16.jpg"},
            {"yummy", "src/icon/social17.jpg"},
            {"healthy", "src/icon/social18.jpg"},
            {"wow", "src/icon/social19.jpg"} 
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

            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0)); 
            bottomPanel.setBackground(Color.WHITE);

            JLabel roundProfileImageLabel = new JLabel(createCircularImage(profileData[i][2], 40));
            roundProfileImageLabel.setPreferredSize(new Dimension(50, 50));
            bottomPanel.add(roundProfileImageLabel);

            JPanel profileInfoPanel = new JPanel(new GridLayout(2, 1, 0, 2)); 
            profileInfoPanel.setBackground(Color.WHITE);

            JLabel profileNameLabel = new JLabel(profileData[i][0]);
            profileNameLabel.setFont(new Font("Inria Sans", Font.BOLD, 12));
            profileInfoPanel.add(profileNameLabel);

            JPanel lovePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0)); 
            lovePanel.setBackground(Color.WHITE);

            ImageIcon loveIcon = new ImageIcon(new ImageIcon("src/icon/social3.png") 
                    .getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
            JLabel loveIconLabel = new JLabel(loveIcon);
            lovePanel.add(loveIconLabel);

            String[] loveCounts = {"23.5k", "12.4k", "521k", "18.1k", "520k", "42.3k", "9.8k", "27.6k"}; 
            JLabel loveTextLabel = new JLabel(loveCounts[i]); 
            loveTextLabel.setFont(new Font("Inria Sans", Font.PLAIN, 10));
            loveTextLabel.setForeground(Color.GRAY);
            lovePanel.add(loveTextLabel);

            profileInfoPanel.add(lovePanel); 

            bottomPanel.add(profileInfoPanel);

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
