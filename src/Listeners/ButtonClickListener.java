package Listeners;

import File.PixelGridFileHandler;
import GUI.PixelGrid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for handling the click events for the ui buttons.
 */
public class ButtonClickListener implements ActionListener {
  private PixelGrid pixelGrid;

  /**
   * Constructor
   * @param pixelGrid PixelGrid
   */
  public ButtonClickListener(PixelGrid pixelGrid) {
    this.pixelGrid = pixelGrid;
  }

  /**
   * Find out which button was clicked and perform correct task.
   * @param e ActionEvent
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();

    switch (command) {
      case "New":
        int response = JOptionPane.showConfirmDialog(
            pixelGrid,
            "Do you want to create a new file?",
            "New",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
          pixelGrid.resetBufferedImage();
          pixelGrid.update();
        }
        break;
      case "Save":
        PixelGridFileHandler.save(pixelGrid);
        break;
      case "Load":
        PixelGridFileHandler.load(pixelGrid);
        pixelGrid.update();
        break;
    }
  }
}
