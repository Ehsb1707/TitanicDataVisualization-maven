import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {
    public Main () throws IOException {
        this.setTitle("Titanic Data Visualization");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.WINDOW_WIDTH , Constants.WINDOW_HEIGHT);
        this.add(new MainPanel(Constants.X_AND_Y, Constants.X_AND_Y, Constants.WINDOW_WIDTH , Constants.WINDOW_HEIGHT));
        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
