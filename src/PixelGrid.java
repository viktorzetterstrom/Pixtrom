import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelGrid extends JPanel {
  private BufferedImage bufferedImage;

  public PixelGrid(BufferedImage bufferedImage) {
    this.bufferedImage = bufferedImage;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
  }
}
