import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class ChatPage {
    JFrame frame;
    
    public ChatPage () {
        frame = new JFrame("Chat");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(255,255,255)); 

        JButton backButton = new JButton("<");
        backButton.setFont(new Font("Inria Sans", Font.BOLD, 20));
        backButton.setForeground(Color.BLACK);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(50, 30)); 
        backButton.addActionListener(e -> {
            frame.dispose();
            new CoursesPage(); 
        });

        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)); 
        backButtonPanel.setOpaque(false); 
        backButtonPanel.add(backButton);

        headerPanel.add(backButtonPanel, BorderLayout.WEST);

        JPanel titleIconPanel = new JPanel(new GridBagLayout());
        titleIconPanel.setBackground(new Color(255,255,255)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel titleLabel = new JLabel("Chat", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        titleIconPanel.add(titleLabel, gbc);

        headerPanel.add(titleIconPanel, BorderLayout.CENTER);

        frame.add(headerPanel, BorderLayout.NORTH);
        
        JPanel chatCardsPanel = new JPanel();
        chatCardsPanel.setLayout(new BoxLayout(chatCardsPanel, BoxLayout.Y_AXIS)); 

        chatCardsPanel.add(createChatCard("src/icon/chat1.png", 
                                            "Liked", 
                                            " ",
                                            " "
                                            ));
        chatCardsPanel.add(createChatCard("src/icon/chat2.png", 
                                            "Comment", 
                                            " ",
                                            ""
                                            ));
        chatCardsPanel.add(createChatCard("src/icon/chat3.jpg", 
                                            "Mingyu", 
                                            "[Sticker]",
                                            "16:04"
                                            ));
        chatCardsPanel.add(createChatCard("src/icon/chat4.jpg", 
                                            "YHX", 
                                            "[Sticker]",
                                            "08:16"
                                            ));
        chatCardsPanel.add(createChatCard("src/icon/chat5.jpg", 
                                            "The 8", 
                                            "[Sticker]",
                                            "07:11"
                                            ));
        chatCardsPanel.add(createChatCard("src/icon/chat6.jpg", 
                                            "Loopy", 
                                            "[Sticker]",
                                            "05:20"
                                            ));


        frame.add(chatCardsPanel, BorderLayout.CENTER); 
        
        frame.setVisible(true);


    }
    
    private JPanel createChatCard(String profilePicturePath, String name, String content, String rightText) {
        JPanel chatCard = new JPanel();
        chatCard.setLayout(new BorderLayout());
        chatCard.setPreferredSize(new Dimension(500, 150)); 
        chatCard.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
        topPanel.setBackground(Color.WHITE);

        JLabel profileLabel = new JLabel(createCircularImage(profilePicturePath, 60)); 
        topPanel.add(profileLabel);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.WHITE);

        textPanel.add(new JLabel(name)); 
        textPanel.add(new JLabel(content));  

        topPanel.add(textPanel);
        chatCard.add(topPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));  
        rightPanel.setBackground(Color.WHITE);

        JLabel rightLabel = new JLabel(rightText);  
        rightPanel.add(rightLabel);

        chatCard.add(rightPanel, BorderLayout.EAST);  

        return chatCard;
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

}
