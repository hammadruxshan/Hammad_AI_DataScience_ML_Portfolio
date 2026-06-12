import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;

public class ProfileEditPage extends JPanel {
    JFrame frame;

    public ProfileEditPage() {
        frame = new JFrame("Profile Edit");
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

        ImageIcon icon = createCircularImage("src/icon/profile1.jpg", 150);
        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        gbc.gridy = 1;
        titleIconPanel.add(iconLabel, gbc);

        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBackground(Color.WHITE);
        GridBagConstraints gbcDetails = new GridBagConstraints();
        gbcDetails.insets = new Insets(5, 10, 5, 10);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel usernameValue = new JLabel("JeongHan");
        usernameValue.setFont(new Font("Arial", Font.PLAIN, 14));

        gbcDetails.gridx = 0;
        gbcDetails.gridy = 0;
        gbcDetails.anchor = GridBagConstraints.WEST;
        detailsPanel.add(usernameLabel, gbcDetails);

        gbcDetails.gridx = 1;
        detailsPanel.add(usernameValue, gbcDetails);

        JLabel bioLabel = new JLabel("Bio: ");
        bioLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel bioValue = new JLabel("Set some very specific goals");
        bioValue.setFont(new Font("Arial", Font.PLAIN, 14));

        gbcDetails.gridx = 0;
        gbcDetails.gridy = 1;
        detailsPanel.add(bioLabel, gbcDetails);

        gbcDetails.gridx = 1;
        detailsPanel.add(bioValue, gbcDetails);

        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel genderValue = new JLabel("Male");
        genderValue.setFont(new Font("Arial", Font.PLAIN, 14));

        gbcDetails.gridx = 0;
        gbcDetails.gridy = 2;
        detailsPanel.add(genderLabel, gbcDetails);

        gbcDetails.gridx = 1;
        detailsPanel.add(genderValue, gbcDetails);

        JLabel cityLabel = new JLabel("City: ");
        cityLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel cityValue = new JLabel("Kuala Lumpur");
        cityValue.setFont(new Font("Arial", Font.PLAIN, 14));

        gbcDetails.gridx = 0;
        gbcDetails.gridy = 3;
        detailsPanel.add(cityLabel, gbcDetails);

        gbcDetails.gridx = 1;
        detailsPanel.add(cityValue, gbcDetails);

        gbc.gridy = 2;
        titleIconPanel.add(detailsPanel, gbc);

        headerPanel.add(titleIconPanel, BorderLayout.CENTER);
        frame.add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public ImageIcon createCircularImage(String imagePath, int diameter) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage();

            BufferedImage circularImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = circularImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setClip(new Ellipse2D.Float(0, 0, diameter, diameter));

            g2.drawImage(image, 0, 0, diameter, diameter, null);
            g2.dispose();

            return new ImageIcon(circularImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
