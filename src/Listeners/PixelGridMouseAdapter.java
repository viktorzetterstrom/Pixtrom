package Listeners;

import GUI.PixelGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class for keeping track of where the mouse is currently and updating a given
 * JLabel.
 */
public class PixelGridMouseAdapter extends MouseAdapter {
  private JLabel positionLabel;
  private PixelGrid pixelGrid;
  private JColorChooser colorChooser;
  private Point coordinate;

  /**
   * Constructor.
   * @param positionLabel JLabel where position will be printed.
   * @param pixelGrid PixelGrid
   */
  public PixelGridMouseAdapter(PixelGrid pixelGrid, JColorChooser colorChooser, JLabel positionLabel) {
    this.pixelGrid = pixelGrid;
    this.colorChooser = colorChooser;
    this.positionLabel = positionLabel;
    coordinate = new Point();
  }

  /**
   * Getter for coordinate
   * @return Point
   */
  public Point getCoordinate() {
    return coordinate;
  }

  /**
   * Override of MouseMotionListener events, keeps track of current position and
   * updates JLabel.
   * @param e MouseEvent
   */
  @Override
  public void mouseDragged(MouseEvent e) {
    this.mouseMoved(e);
    this.mousePressed(e);
  }

  /**
   * Updates the position whenever the mouse is moved.
   * @param e MouseEvent
   */
  @Override
  public void mouseMoved(MouseEvent e) {
    int x = (int) Math.floor(e.getX() * pixelGrid.getWidthFactor());
    int y = (int) Math.floor(e.getY() * pixelGrid.getHeightFactor());
    coordinate.setLocation(x, y);
    positionLabel.setText("(" + x + ", " + y + ")  ");
  }

  @Override
  public void mousePressed(MouseEvent e) {
    Point current = coordinate.getLocation();
    pixelGrid.setRGB((int) current.getX(), (int) current.getY(), colorChooser.getColor().getRGB());
  }
}
