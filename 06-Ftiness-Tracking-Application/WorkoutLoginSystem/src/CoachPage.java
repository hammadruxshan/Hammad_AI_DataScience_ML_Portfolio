import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CoachPage {
    JFrame frame = new JFrame("Coach Page");

    CoachPage() {
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
        
        coachButton.setForeground(Color.BLACK);

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
        JPanel panel = new JPanel(new BorderLayout()); 
        panel.setBackground(new Color(255, 255, 255)); 
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0)); 
        buttonPanel.setBackground(new Color(255, 255, 255)); 

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

        JButton hotsButton = new JButton("Hots");
        hotsButton.setBackground(new Color(255, 255, 255));
        hotsButton.setForeground(Color.BLACK);
        hotsButton.setFont(new Font("Inria Sans", Font.BOLD, 12));
        hotsButton.setPreferredSize(new Dimension(120, 40));
        hotsButton.setBorder(BorderFactory.createEmptyBorder());
        hotsButton.setContentAreaFilled(false);
        hotsButton.setFocusPainted(false);

        JButton followButton = new JButton("Follow");
        followButton.setBackground(new Color(255, 255, 255));
        followButton.setForeground(Color.GRAY);
        followButton.setFont(new Font("Inria Sans", Font.BOLD, 12));
        followButton.setPreferredSize(new Dimension(120, 40));
        followButton.setBorder(BorderFactory.createEmptyBorder());
        followButton.setContentAreaFilled(false);
        followButton.setFocusPainted(false);

        buttonPanel.add(hotsButton);
        buttonPanel.add(followButton);

        panel.add(buttonPanel, BorderLayout.NORTH); 

        JPanel coachCardsPanel = new JPanel();
        coachCardsPanel.setLayout(new BoxLayout(coachCardsPanel, BoxLayout.Y_AXIS)); 

        coachCardsPanel.add(createCoachCard("src/icon/coach1.jpg", 
                                            "Dilraba", 
                                            "Push yourself because no one else is going to do it for you", 
                                            "88M Followers",
                                            new String[] {
                                            "src/icon/coach4.jpg", 
                                            "src/icon/coach5.jpg", 
                                            "src/icon/coach6.jpg"
                                            }));
        coachCardsPanel.add(createCoachCard("src/icon/coach2.jpg", 
                                            "Yan Hao Xiang", 
                                            "The pain you feel today will show itself as strength tomorrow", 
                                            "81.6M Followers",
                                            new String[] {
                                            "src/icon/coach7.jpg", 
                                            "src/icon/coach8.jpg", 
                                            "src/icon/coach9.jpg"
                                            }));
        coachCardsPanel.add(createCoachCard("src/icon/coach3.jpg", 
                                            "Qin Che", 
                                            "The real workout starts when you want to stop", 
                                            "77M Followers",
                                            new String[] {
                                            "src/icon/coach10.jpg", 
                                            "src/icon/coach11.jpg", 
                                            "src/icon/coach12.jpg"
                                            }));

        panel.add(coachCardsPanel, BorderLayout.CENTER); 

        return panel;
    }

    private JPanel createCoachCard(String profilePicturePath, String name, String quote, String followers, String[] imagePaths) {
        JPanel coachCard = new JPanel();
        coachCard.setLayout(new BorderLayout());
        coachCard.setPreferredSize(new Dimension(750, 150)); 
        coachCard.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
        topPanel.setBackground(Color.WHITE);

        JLabel profileLabel = new JLabel(createCircularImage(profilePicturePath, 60)); 
        topPanel.add(profileLabel);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.WHITE);

        textPanel.add(new JLabel(name)); 
        textPanel.add(new JLabel(quote)); 
        textPanel.add(new JLabel(followers)); 

        topPanel.add(textPanel);
        coachCard.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        bottomPanel.setBackground(Color.WHITE);

        for (String imagePath : imagePaths) {
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage().getScaledInstance(350, 150, Image.SCALE_SMOOTH); 
            bottomPanel.add(new JLabel(new ImageIcon(image)));
        }

        coachCard.add(bottomPanel, BorderLayout.CENTER);

        return coachCard;
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
