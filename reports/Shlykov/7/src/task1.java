import java.awt.*;
import javax.swing.*;

class RotatingRectangle extends JPanel {

    private double angleInDegrees = 0;
    private int pivotX = 50; // Координата X вершины для вращения
    private int pivotY = 50; // Координата Y вершины для вращения

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        g2d.setColor(Color.RED);
        g2d.translate(centerX, centerY);
        g2d.rotate(Math.toRadians(angleInDegrees), pivotX, pivotY);
        g2d.drawRect(-pivotX, -pivotY, 100, 100);
        g2d.dispose();
    }

    public void rotateBy(int degrees) {
        angleInDegrees += degrees;
        repaint();
    }

    public static void main(String[] args) {
        RotatingRectangle rotatingRectangle = new RotatingRectangle();

        JFrame frame = new JFrame();
        frame.add(rotatingRectangle);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            rotatingRectangle.rotateBy(1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
