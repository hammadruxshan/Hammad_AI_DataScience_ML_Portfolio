import javax.swing.*;
import java.awt.*;

public class PostPage {
    JFrame frame;
    
    public PostPage () {
        frame = new JFrame("Post");
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
            new SocialPage(); 
        });

        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        backButtonPanel.setOpaque(false); 
        backButtonPanel.add(backButton);

        headerPanel.add(backButtonPanel, BorderLayout.WEST);

        JButton postButton = new JButton("Post");
        postButton.setFont(new Font("Inria Sans", Font.BOLD, 20));
        postButton.setForeground(Color.BLACK);
        postButton.setContentAreaFilled(false);
        postButton.setFocusPainted(false);
        postButton.setPreferredSize(new Dimension(90, 30)); 
        postButton.addActionListener(e -> {
            frame.dispose();
            new SocialPage(); 
        });

        JPanel postButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        postButtonPanel.setOpaque(false); 
        postButtonPanel.add(postButton);

        headerPanel.add(postButtonPanel, BorderLayout.EAST);
        
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));  
        middlePanel.setBackground(new Color(255,255,255));
        
        JLabel typingLabel = new JLabel("Type something...");
        typingLabel.setFont(new Font("Inria Sans", Font.BOLD, 20));
        typingLabel.setForeground(Color.GRAY);
        
        middlePanel.add(typingLabel);
        
        ImageIcon photoIcon = new ImageIcon(new ImageIcon("src/icon/post1.png") 
                    .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)); 
        JLabel photoIconLabel = new JLabel(photoIcon);
        middlePanel.add(photoIconLabel);
        
        JPanel blackLinePanel = new JPanel();
        blackLinePanel.setBackground(Color.GRAY);
        blackLinePanel.setPreferredSize(new Dimension(frame.getWidth(), 2));  
        blackLinePanel.setMaximumSize(new Dimension(frame.getWidth(), 2));  
        blackLinePanel.setAlignmentX(Component.LEFT_ALIGNMENT); 
        middlePanel.add(blackLinePanel); 

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));  
        textPanel.setBackground(Color.WHITE); 

        JLabel line1 = new JLabel("Mention@");
        line1.setFont(new Font("Inria Sans", Font.PLAIN, 18));  
        line1.setForeground(Color.BLACK);  

        JLabel line2 = new JLabel("Who can see");
        line2.setFont(new Font("Inria Sans", Font.PLAIN, 18));  
        line2.setForeground(Color.BLACK);  

        JLabel line3 = new JLabel("Who can't see");
        line3.setFont(new Font("Inria Sans", Font.PLAIN, 18)); 
        line3.setForeground(Color.BLACK);  

        textPanel.add(line1);
        textPanel.add(Box.createVerticalStrut(10));  
        textPanel.add(line2);
        textPanel.add(Box.createVerticalStrut(10)); 
        textPanel.add(line3);

        middlePanel.add(textPanel);
        
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
}
