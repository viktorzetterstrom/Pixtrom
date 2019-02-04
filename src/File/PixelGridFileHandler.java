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
        // Make sure .png is used.
        String fileName = chooser.getSelectedFile().toString();
        if (!fileName.endsWith(".png")) fileName += ".png";

        // Save file.
        File outputFile  = new File(fileName);
        ImageIO.write(pixelGrid.getBufferedImage(), "png", outputFile);
      } catch (IOException ioex) {
        ioex.printStackTrace();
      }
    }
  }

  /**
   * Loads a BufferedImage from disk and changes the image inside PixelGrid.
   * @param pixelGrid
   */
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
