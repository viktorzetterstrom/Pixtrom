import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * UI Class that 
 */
public class GUI extends JFrame implements ActionListener {
  /**
   * Standard settings.
   */
  private final String WINDOW_TITLE = "Pixtrom";
  private final int PIXELS_WIDTH = 32;
  private final int PIXELS_HEIGHT = 32;
  private final int WINDOW_WIDTH = 500;
  private final int WINDOW_HEIGHT = 600;


  
  private PixelGrid pixelGrid;
  private JColorChooser colorChooser;

  /**
   * Constructor
   */
  public GUI() {
    initiateInstanceVariables();
    makeFrame();
  }

  /**
   * Initiates instance variables of gui.
   */
  private void initiateInstanceVariables() {
    // BufferedImage representing the image.
    //BufferedImage image = new BufferedImage(PIXELS_WIDTH, PIXELS_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    try {
      BufferedImage image = ImageIO.read(new File("32x32_empty.jpeg"));
      pixelGrid = new PixelGrid(image);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // ColorChooser setup.
    colorChooser = new JColorChooser();
    colorChooser.setPreviewPanel(new JPanel()); // Disable preview
    AbstractColorChooserPanel[] chooserPanels = colorChooser.getChooserPanels();
    for (AbstractColorChooserPanel chooserPanel : chooserPanels) {
      if(!chooserPanel.getDisplayName().equals("Swatches")) {
        colorChooser.removeChooserPanel(chooserPanel);
      }
    }



  }

  /**
   * Adds gui elements to JFrame.
   */
  private void makeFrame() {
    // Set JFrame settings.
    setTitle(WINDOW_TITLE);
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setResizable(false);

    // Add Elements.
    add(pixelGrid, BorderLayout.CENTER);
    add(colorChooser, BorderLayout.SOUTH);

  }

  /**
   * Adds listeners for the gui.
   * @param e ActionEvent
   */
  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
