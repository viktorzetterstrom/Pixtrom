package File;

import GUI.PixelGrid;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
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

  public static void load(PixelGrid pixelGrid) {
    JFileChooser chooser = new JFileChooser();
    int retrieval = chooser.showOpenDialog(null);
    if (retrieval == JFileChooser.APPROVE_OPTION) {
      try {
        File inputFile = chooser.getSelectedFile();
        BufferedImage bufferedImage = ImageIO.read(inputFile);
        pixelGrid.setBufferedImage(bufferedImage);
      } catch (IOException ioex) {
        ioex.printStackTrace();
      }
    }
  }
}
