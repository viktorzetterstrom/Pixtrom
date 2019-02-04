package File;

import GUI.PixelGrid;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Class that handles saving and loading of files.
 */
public class PixelGridFileHandler {
  /**
   * Shows a JFileChooser and saves current image to that location. Saves in
   * .png format.
   * @param pixelGrid
   */
  public static void save(PixelGrid pixelGrid) {
    JFileChooser chooser = new JFileChooser();
    int retrieval = chooser.showSaveDialog(null);
    if (retrieval == JFileChooser.APPROVE_OPTION) {
      try {
        File outputFile  = new File(chooser.getSelectedFile() + ".png");
        ImageIO.write(pixelGrid.getBufferedImage(), "png", outputFile);
      } catch (IOException ioex) {
        ioex.printStackTrace();
      }
    }
  }

  public static PixelGrid load(String fileName) {

    return new PixelGrid(10, 10);
  }
}
