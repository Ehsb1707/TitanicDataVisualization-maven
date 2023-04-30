import javax.swing.*;
import java.awt.*;

public class OpenPic extends JPanel {

    private ImageIcon imageIcon ;

    public OpenPic (int x ,int y , int width , int height ) {
        this.setBounds(x, y, width, height);
        this.imageIcon = new ImageIcon("titanic.png");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.imageIcon.paintIcon(this, g , Constants.WINDOW_WIDTH , Constants.WINDOW_HEIGHT);
    }
}
