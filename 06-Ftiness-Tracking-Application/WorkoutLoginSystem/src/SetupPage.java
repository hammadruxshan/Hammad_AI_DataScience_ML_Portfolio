
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SetupPage {
    JFrame frame = new JFrame("Set up!");
    JLabel newlabel = new JLabel("");

    SetupPage() {
        newlabel.setBounds(0, 0, 200, 35);
        newlabel.setFont(new Font(null, Font.ITALIC, 25));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(0x0c225d));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel title = new JLabel("Let's Set Up!");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; 
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(title, gbc);

        addLabeledFieldWithUnit(frame, gbc, "Target Weight", "kg", 1);
        addLabeledFieldWithUnit(frame, gbc, "Weight", "kg", 2);
        addLabeledFieldWithUnit(frame, gbc, "Height", "cm", 3);
        addLabeledFieldWithUnit(frame, gbc, "Chest", "cm", 4);
        addLabeledFieldWithUnit(frame, gbc, "Waist", "cm", 5);
        addLabeledFieldWithUnit(frame, gbc, "Hips", "cm", 6);
        
        JButton DoneButton = new JButton("Done");
        DoneButton.setFont(new Font("Arial", Font.BOLD, 18));
        DoneButton.setPreferredSize(new Dimension(150, 40));
        DoneButton.setBackground(Color.WHITE);
        DoneButton.setForeground(Color.BLACK);
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(DoneButton, gbc);
        
           DoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
                new CoursesPage(); 
            }
        });
    }
    
    

    private void addLabeledFieldWithUnit(JFrame frame, GridBagConstraints gbc, String labelText, String unit, int row) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(label, gbc);

        JTextField textField = new JTextField(15);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setPreferredSize(new Dimension(300, 40));
        textField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(textField, gbc);

        JLabel unitLabel = new JLabel(unit);
        unitLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        unitLabel.setForeground(Color.WHITE);
        gbc.gridx = 2; 
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(unitLabel, gbc);
    }
}
