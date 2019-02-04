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
 * Main class responsible for the UI and its events.
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


  /**
   * UI elements.
   */
  private PixelGrid pixelGrid;
  private JLabel cursorPositionLabel;
  private JButton newButton;
  private JButton saveButton;
  private JButton loadButton;
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

    // Buttons
    newButton = new JButton("New");
    saveButton = new JButton("Save");
    loadButton = new JButton("Load");

    // Label for cursor position.
    cursorPositionLabel = new JLabel("Pos: ");

  }

  /**
   * Add gui elements to JFrame.
   */
  private void makeFrame() {
    // Set JFrame settings.
    setTitle(WINDOW_TITLE);
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setResizable(false);

    // Add pixelgrid to center.
    add(pixelGrid, BorderLayout.CENTER);

    // Create toolbar with color swatch and buttons for file operations.
    JPanel toolbar = new JPanel(new BorderLayout());
    JPanel toolbarButtons = new JPanel(new GridLayout(1, 4));
    // Add buttons and cursor label.
    toolbarButtons.add(newButton);
    toolbarButtons.add(saveButton);
    toolbarButtons.add(loadButton);
    toolbarButtons.add(cursorPositionLabel);
    // Add buttons and color chooser to toolbar and add it to JFrame.
    toolbar.add(colorChooser, BorderLayout.CENTER);
    toolbar.add(toolbarButtons, BorderLayout.SOUTH);
    add(toolbar, BorderLayout.SOUTH);
  }

  /**
   * Add listeners for the gui.
   * @param e ActionEvent
   */
  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
