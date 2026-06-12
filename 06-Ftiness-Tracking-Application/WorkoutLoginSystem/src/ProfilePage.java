import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class ProfilePage {
    JFrame frame;

    public ProfilePage() {
        frame = new JFrame("Profile Page");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topCardPanel = createTopCard("src/icon/profile1.jpg", "JeongHan", "Since 2021", PersonalProfilePage.class);
        mainPanel.add(topCardPanel, BorderLayout.NORTH);

        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new GridLayout(5, 1, 0, 10)); 
        navigationPanel.setBackground(Color.WHITE);

        navigationPanel.add(createNavigationCard("Achievement", "src/icon/profile2.png", AchievementPage.class));
        navigationPanel.add(createNavigationCard("Personal Data", "src/icon/profile3.png", PersonalDataPage.class));
        navigationPanel.add(createNavigationCard("Target", "src/icon/profile4.png", TargetPage.class));
        navigationPanel.add(createNavigationCard("Customer Support", "src/icon/profile5.png", CustomerSupportPage.class));

        mainPanel.add(navigationPanel, BorderLayout.CENTER);

        JPanel bottomPanel = createBottomPanel();
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        
        frame.setVisible(true);
    }

    private JPanel createTopCard(String imagePath, String title, String subtitle, Class<? extends JPanel> pageClass) {
        JPanel topCard = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10)); 
        topCard.setBackground(Color.WHITE);
        topCard.setPreferredSize(new Dimension(800, 100));
        
        JLabel imageLabel = new JLabel(createCircularImage(imagePath, 90)); 
        topCard.add(imageLabel);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        textPanel.add(titleLabel);
        textPanel.add(subtitleLabel);
        topCard.add(textPanel);

        topCard.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        topCard.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                JPanel page = pageClass.getDeclaredConstructor().newInstance();  
                frame.setContentPane(page);
                frame.revalidate();
                frame.repaint();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            topCard.setBackground(Color.GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            topCard.setBackground(Color.WHITE);
        }
        });

        return topCard;
    }

    private JPanel createNavigationCard(String text, String imagePath, Class<? extends JPanel> pageClass) {
        JPanel card = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 20));
        card.setBackground(Color.WHITE);
        card.setPreferredSize(new Dimension(800, 20));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel imageLabel = new JLabel(createCircularImage(imagePath, 60)); 
        card.add(imageLabel);

        JLabel textLabel = new JLabel(text);
        textLabel.setFont(new Font("Arial", Font.BOLD, 16));
        card.add(textLabel);

        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    JPanel page = pageClass.getDeclaredConstructor().newInstance();  
                    frame.setContentPane(page);
                    frame.revalidate();
                    frame.repaint();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBackground(Color.WHITE);
            }
        });

        return card;
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

}
