import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

public class TransformedShapes extends JPanel {
	
	private Graphics2D g2; 
	private void resetTransform() {
		g2.setTransform(new AffineTransform());
	}
	
	private void circle() {
		g2.fillOval(-50,-50,100,100);
	}

	private void square() {
		g2.fillRect(-50,-50,100,100);
	}

	private void triangle() {
		g2.fillPolygon(new int[] {-50,50,0}, new int[] {50,50,-50}, 3);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(15));
        
        Polygon p1 = new Polygon();
        p1.addPoint(100, 100);
        p1.addPoint(500, 100);
        g2.drawPolygon(p1);

        Polygon p2 = new Polygon();
        p2.addPoint(500, 100);
        p2.addPoint(100, 500);
        g2.drawPolygon(p2);

        Polygon p3 = new Polygon();
        p3.addPoint(100, 500);
        p3.addPoint(500, 500);
        g2.drawPolygon(p3);
        
		resetTransform();
	} 

	public TransformedShapes() {
		setPreferredSize(new Dimension(600,600) );
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
	}

	public static void main(String[] args)  {
		JFrame window = new JFrame("Drawing With Transforms");
		window.setContentPane(new TransformedShapes());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}