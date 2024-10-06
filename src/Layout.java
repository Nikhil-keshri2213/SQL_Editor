import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout {
    private JFrame frame;
    private JTextArea queryArea;
    private JTextArea outputArea;

    public Layout() {
        frame = new JFrame("SQL Editor");
        frame.setSize(900, 720);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create query area
        queryArea = new JTextArea(20, 60);
        queryArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Create output area
        outputArea = new JTextArea(20, 60);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Create buttons
        JButton clearButton = new JButton("Clear");
        clearButton.setSize(40,20);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryArea.setText("");
                outputArea.setText("");
            }
        });

        JButton runButton = new JButton("Run");
        runButton.setSize(40, 20);
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TO DO: Implement running the query here
                String query = queryArea.getText();
                // Assume we have a method to execute the query and get the result
                String result = executeQuery(query);
                outputArea.setText(result);
            }
        });

        // Create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearButton);
        buttonPanel.add(runButton);

        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(queryArea), BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // Add main panel to frame
        frame.getContentPane().add(mainPanel);

        // Make frame visible
        frame.setVisible(true);
    }

    // TO DO: Implement executing the query here
    private String executeQuery(String query) {
        // For demonstration purposes, just return the query
        return query;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Layout();
            }
        });
    }
}