package ViewCover;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class JPanelCover extends javax.swing.JPanel {
	/**
	 * Create the panel.
	 */
	public JPanelCover() {
		this.setOpaque(false);
		this.setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		GradientPaint gra = new GradientPaint(0, 0, new Color(35, 116, 97), 0, getHeight(), new Color(22, 116, 66));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(grphcs);
	}
	
}
