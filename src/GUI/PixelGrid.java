package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class that draws and maintains a grid of pixels through use of a
 * BufferedImage.
 */
public class PixelGrid extends JPanel {
  private BufferedImage bufferedImage;

  /**
   * Constructor
   * @param width
   * @param height
   */
  public PixelGrid(int width, int height) {
    this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    resetBufferedImage(bufferedImage);
  }

  /**
   * Resets the buffered Image by painting it white.
   * @param bufferedImage
   */
  private void resetBufferedImage(BufferedImage bufferedImage) {
    for (int x = 0; x < bufferedImage.getWidth(); x++) {
      for (int y = 0; y < bufferedImage.getHeight(); y++) {
        bufferedImage.setRGB(x, y, Color.white.getRGB());
      }
    }
  }

  /**
   * Override of paintComponent to draw BufferedImage inside JPanel.
   * @param g Graphics object
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
  }

  /**
   * Wrapper around bufferedImage setRGB to color pixels.
   * @param x x-coordinate
   * @param y y-coordinate
   * @param rgb rgb-value of color.
   */
  public void setRGB(int x, int y, int rgb) {
    bufferedImage.setRGB(x, y, rgb);
    revalidate();
    repaint();
  }

  /**
   * Returns the
   * @return Width.
   */
  public double getWidthFactor() {
    double factor = (double) bufferedImage.getWidth() / getWidth();
    return factor;
  }

  /**
   * Getter for height.
   * @return Height
   */
  public double getHeightFactor() {
    double factor = (double) bufferedImage.getHeight() / getHeight();
    return factor;
  }
}
