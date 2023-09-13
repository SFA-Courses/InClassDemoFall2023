import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FavoritesGUI {
  public static void main(String[] args) throws ListException, MalformedURLException {
    JFrame frame = new JFrame("Text File to Button List");
    frame.setSize(400, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    FavoriteList favList = new FavoriteList();
    favList.add(0, new Favorite("Grounded", "https://www.youtube.com/watch?v=_BqgJ9nW468"));
    favList.add(1, new Favorite("Vampire Survivor", "https://www.youtube.com/watch?v=6HXNxWbRgsg"));
    favList.add(2, new Favorite("High on Life", "https://www.youtube.com/watch?v=NyfneSMsr5U"));
    
    //String[] lines = readTextFile("textfile.txt");
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    for (int i = 0; i <= 2; i++) {
      String name = "<html>" + favList.get(i).toString().replace("\n", "<br>") + "</html>";
      JButton button = new JButton(name);
      
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          System.out.println("Button clicked: " + name);
        }
      });
      panel.add(button);
    }

    JScrollPane scrollPane = new JScrollPane(panel);
    frame.add(scrollPane, BorderLayout.CENTER);

//    frame.setSize(300, 150);
    frame.setVisible(true);
  }
}
