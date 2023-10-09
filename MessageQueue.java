import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class MessageQueue extends JFrame {
    /**
     * Starts the JFrame GUI
     * 
     * @param args - not used
     */
    public static void main(String[] args) {
        MessageQueue o = new MessageQueue();
    }

    QueueArrayBased<String> queue; // queue of worder orders
    //QueueCircular<String> queue;
    // used to give numbers to the tickets
    int orderNum = ThreadLocalRandom.current().nextInt(100, 200);
    // text fields containing work orders, name, and current issue
    JTextArea txtWorkOrders;
    JTextField txtName;
    JTextField txtIssue;

    public MessageQueue() {
        // holds the work orders
        this.queue = new QueueArrayBased<String>();
        //this.queue = new QueueCircular<String>();
        
        JPanel panel = new JPanel();
        txtIssue = new JTextField();
        JScrollPane scrollPane = new JScrollPane(txtIssue);
        JButton submitButton = new JButton("Submit");
        JButton completeButton = new JButton("Complete");
        JButton exitButton = new JButton("Exit");

        JPanel panelForInfo = new JPanel();
        panelForInfo.setLayout(new BoxLayout(panelForInfo, BoxLayout.Y_AXIS));
        txtWorkOrders = new JTextArea(30, 30);
        this.txtWorkOrders.setEditable(false);
        JScrollPane messagePane = new JScrollPane(txtWorkOrders);
        txtName = new JTextField();
        panelForInfo.add(new JLabel("Name"));
        panelForInfo.add(txtName);
        panelForInfo.add(new JLabel("Issue"));
        panelForInfo.add(txtIssue);
        panelForInfo.add(new JLabel("Work Orders"));
        panelForInfo.add(messagePane);

        // adds a new work order to the queue
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addJob();
            }
        });

        // removes a work order from the queue
        completeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                completeJob();
            }
        });

        // exit button closes
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // add componenets and show the panel
        panel.add(panelForInfo);
        panel.add(scrollPane);
        panel.add(submitButton);
        panel.add(completeButton);
        panel.add(exitButton);
        this.add(panel);

        setVisible(true);
        this.pack();
    }

    private void addJob() {
        // add a ticket number 
        String s = "---------------Ticket #" + this.orderNum + "----------------\n";
        s = s + this.txtName.getText() + " \n";
        s = s + this.txtIssue.getText() + "\n";
        this.queue.enqueue(s);

        String jobs = this.txtWorkOrders.getText() + s;
        this.txtWorkOrders.setText(jobs);
        this.orderNum++;
    }

    private void completeJob() {
        // remove completed job from queue
        if (!this.queue.isEmpty())
            this.queue.dequeue();

        // update the GUI to reflect job complete
        String s = this.txtWorkOrders.getText();
        s = s.substring(s.indexOf('\n') + 1);
        s = s.substring(s.indexOf('\n') + 1);
        s = s.substring(s.indexOf('\n') + 1);
        this.txtWorkOrders.setText(s);
    }

}