package ViewCover;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class CircleImagePanel extends JPanel {

    private int radius;
    private Color color;

    public CircleImagePanel( int radius , Color color) {
        super();
        this.color = color;
        this.radius = radius;
        // Đặt kích thước của JPanel để bao quanh hình tròn
        setPreferredSize(new Dimension(radius * 2, radius * 2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Vẽ hình tròn
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.drawOval(0, 0, radius * 2, radius * 2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        // Chèn ảnh vào hình tròn
        g2.fillOval(0, 0, radius * 2, radius * 2);
    }
}