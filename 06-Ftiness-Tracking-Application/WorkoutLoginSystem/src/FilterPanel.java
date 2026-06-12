
import javax.swing.*;
import java.awt.*;

public class FilterPanel extends JFrame {
    public FilterPanel() {
        setTitle("Exercise Filter Panel");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1));

        add(createCategoryPanel("Difficulty", new String[]{"Beginner", "Advanced", "Strengthen", "Challenge"}));
        add(createCategoryPanel("Position", new String[]{"All", "Back", "Calves", "Shoulder", "Abs", "Waist", "Chest", "Glutes", "Neck", "Arms", "Thighs", "Face"}));
        add(createCategoryPanel("Duration", new String[]{"< 5 mins", "5-10 mins", "11-15 mins", "16-20 mins", "21-30 mins", "> 30 mins"}));

        setVisible(true);
    }

    private JPanel createCategoryPanel(String title, String[] options) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        for (String option : options) {
            JToggleButton button = new JToggleButton(option);
            button.setFocusPainted(false);
            panel.add(button);
        }

        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new FilterPanel();
        });
    }
}


