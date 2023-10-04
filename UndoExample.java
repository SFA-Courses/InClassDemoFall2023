import javax.swing.*;
import java.awt.event.*;
import javax.swing.undo.*;
import javax.swing.event.*;

public class UndoExample extends JFrame implements KeyListener {
    public static void main(String[] args) {
        UndoExample o = new UndoExample();
    }

    // UndoManager m = new UndoManager();
    StackArrayBased<Character> stack;

    public UndoExample() {
        stack = new StackArrayBased<Character>();
        JPanel panel = new JPanel();
        JTextArea textBox = new JTextArea(6, 30);
        JScrollPane scrollPane = new JScrollPane(textBox);
        JButton undoButton = new JButton("Undo");
        JButton exitButton = new JButton("Exit");
        textBox.addKeyListener(this);
        undoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!stack.isEmpty())
                        stack.pop();
                    System.out.println(stack);
                    String s = textBox.getText();
                    textBox.setText(s.substring(0, s.length() - 1));
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
        panel.add(undoButton);
        panel.add(exitButton);
        this.add(panel);
        setVisible(true);
        this.pack();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.stack.push(e.getKeyChar());
        System.out.println(this.stack);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}