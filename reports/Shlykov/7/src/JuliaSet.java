import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.File;

public class JuliaSet {
    public static void main(String[] args) throws Exception {
        int width = 800, height = 800, max = 1000;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        double zx, zy, cX, cY, tmp;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                zx = zy = 0;
                cX = (x - 500) / 200.0;
                cY = (y - 500) / 200.0;
                int iter = max;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }
                image.setRGB(x, y, iter | (iter << 8));
            }
        }
        ImageIO.write(image, "png", new File("julia.png"));

        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
