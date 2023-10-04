/** This class makes a simply GUI and application to reverse a string.
 * Author: JJB
 */
import javax.swing.*;
import java.awt.event.*;

public class StringReverser extends JFrame {
    //==================MAIN================
    /**
     * Starts the application
     * @param args - not used
     */
    public static void main(String[] args) {
        StringReverser o = new StringReverser();
    }

    //=============CONSTRUCTOR===============
    public StringReverser() {
        // create the GUI
        JPanel panel = new JPanel();
        JTextArea textBox = new JTextArea(6, 30);
        JScrollPane scrollPane = new JScrollPane(textBox);
        JButton reverseButton = new JButton("Reverse");
        JButton exitButton = new JButton("Exit");
        
        // the reverse button will reverse the text
        // in the text box
        reverseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String text = textBox.getText();
                    String reverseText = reverse(text);
                    textBox.setText(reverseText);
                } catch (Exception ex) {
                }
            }
        });

        // exit button closes
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // add componenets and show the panel
        panel.add(scrollPane);
        panel.add(reverseButton);
        panel.add(exitButton);
        this.add(panel);
        setVisible(true);
        this.pack();
    }

    //==================METHODS=====================
    /**
     * This method reversing the given string 
     * and returns the reversed string.
     * @param text - string to reverse
     * @return the text reversed
     */
    private String reverse(String text) {
        StackReferenceBased<Character> stack = new StackReferenceBased<Character>();

        // TODO: Add code here
        return "";
    }
}
