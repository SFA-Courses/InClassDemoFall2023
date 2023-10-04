import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class ParaChecker extends JFrame implements KeyListener {

    public static void main(String[] args) {
        ParaChecker o = new ParaChecker();
    }

    JTextArea textBox; // text box for the equation

    public ParaChecker() {
        JPanel panel = new JPanel();
        textBox = new JTextArea(6, 30);
        JScrollPane scrollPane = new JScrollPane(textBox);
        JButton exitButton = new JButton("Exit");
        textBox.addKeyListener(this); // below we handle when a key is typed
        
        // exit button closes
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // add componenets and show the panel
        panel.add(scrollPane);
        panel.add(exitButton);
        this.add(panel);
        setVisible(true);
        this.pack();
    }

    /**
     * Each time a key is pressed this method examines the contents of the
     * text cell and checks to see if the ( ) match correctly.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("char: " + e.getKeyChar() + " text: " + this.textBox.getText());
        if (this.paraMatch(this.textBox.getText()+e.getKeyChar()))
            this.textBox.setForeground(new Color(0, 200, 0));
        else
            this.textBox.setForeground(new Color(200, 0, 0));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method tub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    private boolean paraMatch(String eq) {
        StackReferenceBased<Character> parStack = new StackReferenceBased<Character>();
        for (int i = 0; i < eq.length(); i++) {
            if (eq.charAt(i) == '(')
                parStack.push('(');
            else if (eq.charAt(i) == ')') {
                if (parStack.isEmpty())
                    return false;
                else
                    parStack.pop();
            }
        }

        // true if ( matched a ) and false otherwise
        return parStack.isEmpty();
    }
}
