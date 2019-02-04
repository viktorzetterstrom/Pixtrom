package Listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Class for keeping track of where the mouse is currently.
 */
public class MousePositionListener implements MouseMotionListener {
  private JLabel positionLabel;
  private Point coordinate;

  /**
   * Constructor.
   * @param positionLabel
   */
  public MousePositionListener(JLabel positionLabel) {
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
   * Override of MouseMotionListener events.
   * @param e MouseEvent
   */
  @Override
  public void mouseDragged(MouseEvent e) {
    this.mouseMoved(e);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    coordinate.x = e.getX();
    coordinate.y = e.getY();
    positionLabel.setText("(" + coordinate.getX() + ", " + coordinate.getY() + ")");
  }
}
