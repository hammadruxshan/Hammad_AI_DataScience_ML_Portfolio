import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class PersonalProfilePage extends JPanel {
    JFrame frame;

    public PersonalProfilePage() {
        frame = new JFrame("PersonalProfilePage");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());  

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

        JPanel titleIconPanel = new JPanel(new GridBagLayout());
        titleIconPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Profile", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        titleIconPanel.add(titleLabel, gbc);

        headerPanel.add(titleIconPanel, BorderLayout.CENTER);

        ImageIcon photoIcon = new ImageIcon(new ImageIcon("src/icon/pp1.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JButton photoButton = new JButton(photoIcon);
        photoButton.setPreferredSize(new Dimension(30, 30));
        photoButton.setContentAreaFilled(false);
        photoButton.setBorderPainted(false);
        photoButton.setFocusPainted(false);

        photoButton.addActionListener(e -> {
            System.out.println("Navigating to ProfileEditPage...");
            frame.setContentPane(new ProfileEditPage());  
            frame.revalidate();
            frame.repaint();
        });

        headerPanel.add(photoButton, BorderLayout.EAST);
        frame.add(headerPanel, BorderLayout.NORTH);

        JPanel createProfilePanel = new JPanel();
        createProfilePanel.setLayout(new BoxLayout(createProfilePanel, BoxLayout.Y_AXIS)); 
        createProfilePanel.add(createProfileCard("src/icon/profile1.jpg", "JeongHan", "Set some very specific goals", "10.4M Followers   13 Following"));
        
        createProfilePanel.setPreferredSize(new Dimension(frame.getWidth(), 150));  
        frame.add(createProfilePanel, BorderLayout.CENTER); 

        JPanel profileCardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
        profileCardsPanel.setBackground(Color.WHITE);

        String[][] profileData = {
            {"", "src/icon/pp2.jpg"},
            {"", "src/icon/pp3.jpg"}
        };

        for (int i = 0; i < profileData.length; i++) {
            JPanel profileCard = new JPanel();
            profileCard.setLayout(new BorderLayout());
            profileCard.setBackground(Color.WHITE);
            profileCard.setPreferredSize(new Dimension(250, 310)); 

            ImageIcon rectangularIcon = new ImageIcon(profileData[i][1]);
            Image rectangularImage = rectangularIcon.getImage().getScaledInstance(250, 290, Image.SCALE_SMOOTH);
            JLabel rectangularImageLabel = new JLabel(new ImageIcon(rectangularImage));
            profileCard.add(rectangularImageLabel, BorderLayout.CENTER);

            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0)); 
            bottomPanel.setBackground(Color.WHITE);

            ImageIcon loveIcon = new ImageIcon(new ImageIcon("src/icon/social3.png")
                    .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            JLabel loveIconLabel = new JLabel(loveIcon);
            bottomPanel.add(loveIconLabel);

            String[] loveCounts = {"1.04M", "1.4M"};
            JLabel loveTextLabel = new JLabel(loveCounts[i]);
            loveTextLabel.setFont(new Font("Inria Sans", Font.PLAIN, 10));
            loveTextLabel.setForeground(Color.GRAY);
            bottomPanel.add(loveTextLabel);

            profileCard.add(bottomPanel, BorderLayout.SOUTH);

            profileCardsPanel.add(profileCard);  
        }
        
        frame.add(profileCardsPanel, BorderLayout.SOUTH); 

        frame.setVisible(true);
    }

    private JPanel createProfileCard(String profilePicturePath, String name, String quote, String followers) {
        JPanel profileCard = new JPanel();
        profileCard.setLayout(new BorderLayout());
        profileCard.setPreferredSize(new Dimension(750, 150)); 
        profileCard.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
        topPanel.setBackground(Color.WHITE);

        JLabel profileLabel = new JLabel(createCircularImage(profilePicturePath, 150)); 
        topPanel.add(profileLabel);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
        textPanel.add(nameLabel);

        JLabel quoteLabel = new JLabel(quote);
        quoteLabel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        textPanel.add(quoteLabel);

        JLabel followersLabel = new JLabel(followers);
        followersLabel.setFont(new Font("Arial", Font.PLAIN, 14)); 
        textPanel.add(followersLabel);

        topPanel.add(textPanel);
        profileCard.add(topPanel, BorderLayout.NORTH);

        return profileCard;
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
