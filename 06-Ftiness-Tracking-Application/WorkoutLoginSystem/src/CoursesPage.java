import javax.swing.*;
import java.awt.*;

public class CoursesPage {
    JFrame frame = new JFrame("Courses Page");

    CoursesPage() {
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
        
        courseButton.setForeground(Color.BLACK);

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
        coachButton.addActionListener(e -> {
            frame.dispose();
            new CoachPage(); 
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
                .getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))); // Set the search icon
        searchButton.setBackground(new Color(255, 255, 255)); // Set transparent background
        searchButton.setForeground(Color.WHITE); // Set text color (even though no text is present)
        searchButton.setPreferredSize(new Dimension(20, 20)); // Size of the button (icon size)
        searchButton.setBorder(BorderFactory.createEmptyBorder()); // Remove the border around the button
        searchButton.setContentAreaFilled(false); // Make button content area transparent
        searchButton.setFocusPainted(false); // Remove the blue focus outline
        buttonPanel.add(searchButton, BorderLayout.WEST); // Align the search button to the left

        JButton starredButton = new JButton("Starred");
        starredButton.setBackground(new Color(255, 255, 255));
        starredButton.setForeground(Color.BLACK);
        starredButton.setFont(new Font("Inria Sans", Font.BOLD, 12));
        starredButton.setPreferredSize(new Dimension(120, 40));
        starredButton.setBorder(BorderFactory.createEmptyBorder());
        starredButton.setContentAreaFilled(false);
        starredButton.setFocusPainted(false);

        JButton suggestedButton = new JButton("Suggested");
        suggestedButton.setBackground(new Color(255, 255, 255));
        suggestedButton.setForeground(Color.GRAY);
        suggestedButton.setFont(new Font("Inria Sans", Font.BOLD, 12));
        suggestedButton.setPreferredSize(new Dimension(120, 40));
        suggestedButton.setBorder(BorderFactory.createEmptyBorder());
        suggestedButton.setContentAreaFilled(false);
        suggestedButton.setFocusPainted(false);
        
        // Filter Button (Rightmost)
    JButton filterButton = new JButton();
    filterButton.setIcon(new ImageIcon(new ImageIcon("src/icon/fbb.png") 
                .getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))); 
    filterButton.setBackground(new Color(255, 255, 255));
    filterButton.setForeground(Color.BLACK);
    filterButton.setFont(new Font("Inria Sans", Font.BOLD, 12));
    filterButton.setPreferredSize(new Dimension(120, 40));
    filterButton.setBorder(BorderFactory.createEmptyBorder());
    filterButton.setContentAreaFilled(false);
    filterButton.setFocusPainted(false);
    buttonPanel.add(searchButton, BorderLayout.EAST); 
    

    // Add the ActionListener for the Filter button
    filterButton.addActionListener(e -> {
        new FilterPanel(); // Open the FilterPage
    });

        buttonPanel.add(starredButton);
        buttonPanel.add(suggestedButton);
        buttonPanel.add(filterButton);

        // Course List Panel with BoxLayout to align items vertically
        JPanel courseListPanel = new JPanel();
        courseListPanel.setLayout(new BoxLayout(courseListPanel, BoxLayout.Y_AXIS)); // Align vertically
        courseListPanel.setBackground(Color.WHITE);

        String[] courses = {"Plan A", "Plan B", "Plan C", "Plan D", "Plan E"};
        String[] durations = {"45 mins", "35 mins", "30 mins", "32 mins", "36 mins"};
        String[] instructors = {"Samuel", "Tiara", "SailorMoon", "Clown", "Jane"};
        String[] images = {"src/icon/courses1.png", "src/icon/courses2.png", "src/icon/courses3.png", "src/icon/courses4.png", "src/icon/courses5.png"};

        for (int i = 0; i < courses.length; i++) {
            JPanel courseItem = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout for horizontal alignment
            courseItem.setBackground(Color.WHITE);
            courseItem.setPreferredSize(new Dimension(1024, 100)); // Ensure consistent size for each course item
            courseItem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Load and scale the image
            JLabel imageLabel = new JLabel();
            try {
                ImageIcon courseImage = new ImageIcon(images[i]);
                Image scaledImage = courseImage.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
            } catch (Exception ex) {
                imageLabel.setText("Image Not Found");
                imageLabel.setHorizontalAlignment(JLabel.CENTER);
            }

            // Course details panel
            JPanel courseDetails = new JPanel();
            courseDetails.setLayout(new BoxLayout(courseDetails, BoxLayout.Y_AXIS)); // Stack name and duration vertically
            courseDetails.setBackground(Color.WHITE);
            courseDetails.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

            JLabel courseName = new JLabel(courses[i]);
            courseName.setFont(new Font("Arial", Font.BOLD, 16));

            JLabel courseInfo = new JLabel(durations[i] + " | " + instructors[i]);
            courseInfo.setFont(new Font("Arial", Font.PLAIN, 14));
            courseInfo.setForeground(Color.GRAY);

            courseDetails.add(courseName);
            courseDetails.add(courseInfo);

            // Add image and details to courseItem panel
            courseItem.add(imageLabel);
            courseItem.add(courseDetails);

            courseListPanel.add(courseItem);

            // Add separator between courses
            if (i < courses.length - 1) {
                courseListPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
            }
        }

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(courseListPanel, BorderLayout.CENTER);

        return panel; // Return the panel to complete the method
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

