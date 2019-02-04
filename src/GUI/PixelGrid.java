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
    resetBufferedImage();
  }

  /**
   * Constructor with bufferedImage.
   * @param bufferedImage
   */
  public PixelGrid(BufferedImage bufferedImage) {
    this.bufferedImage = bufferedImage;
  }

  /**
   * Resets the buffered Image by painting it white.
   */
  public void resetBufferedImage() {
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
    int width = bufferedImage.getWidth();
    int height = bufferedImage.getHeight();
    if ((0 <= x && x < width) && (0 <= y && y < height)) {
      bufferedImage.setRGB(x, y, rgb);
      update();
    }
  }

  /**
   * Redraws the JPanel.
   */
  public void update() {
    revalidate();
    repaint();
  }
  /**
   * Returns the factor to multiply current x-position with to get correct pixel.
   * @return x-coordinate multiplication factor
   */
  public double getWidthFactor() {
    double factor = (double) bufferedImage.getWidth() / getWidth();
    return factor;
  }

  /**
   * Returns the factor to multiply current y-position with to get correct pixel.
   * @return y-coordinate multiplication factor
   */
  public double getHeightFactor() {
    double factor = (double) bufferedImage.getHeight() / getHeight();
    return factor;
  }

  /**
   * Getter for bufferedImage
   * @return BufferedImage
   */
  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  /**
   * Function that sets the bufferedImage
   * @param bufferedImage
   */
  public void setBufferedImage(BufferedImage bufferedImage) {
    this.bufferedImage = bufferedImage;
  }
}
