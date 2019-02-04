package GUI;

import File.PixelGridFileHandler;
import Listeners.ButtonClickListener;
import Listeners.PixelGridMouseAdapter;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;

/**
 * Main class responsible for the UI and its events.
 */
public class GUI extends JFrame {
  /**
   * Standard settings.
   */
  private final String WINDOW_TITLE = "Pixtrom";
  private final int DEFAULT_PIXELS_WIDTH = 32;
  private final int DEFAULT_PIXELS_HEIGHT = 32;
  private final int WINDOW_WIDTH = 530;
  private final int WINDOW_HEIGHT = 700;
  private final int SWATCHES_SIZE = 12;
  private final int SWATCHES_RECENT_SIZE = 18;


  /**
   * UI elements.
   */
  private PixelGrid pixelGrid;
  private JLabel mousePositionLabel;
  private JButton newButton;
  private JButton saveButton;
  private JButton loadButton;
  private JColorChooser colorChooser;

  /**
   * Listeners
   */
  private ButtonClickListener buttonClickListener;
  private PixelGridMouseAdapter pixelGridMouseAdapter;

  /**
   * Constructor
   */
  public GUI() {
    initiateInstanceVariables();
    makeFrame();
    createListeners();
  }

  /**
   * Initiates instance variables of gui.
   */
  private void initiateInstanceVariables() {
    // PixelGrid
    pixelGrid = new PixelGrid(DEFAULT_PIXELS_WIDTH, DEFAULT_PIXELS_HEIGHT);

    // ColorChooser setup.
    // Increase width of swatches.
    UIManager.put("ColorChooser.swatchesRecentSwatchSize", new Dimension(SWATCHES_RECENT_SIZE, SWATCHES_RECENT_SIZE));
    UIManager.put("ColorChooser.swatchesSwatchSize", new Dimension(SWATCHES_SIZE, SWATCHES_SIZE));
    colorChooser = new JColorChooser();
    colorChooser.setPreviewPanel(new JPanel()); // Disable preview
    AbstractColorChooserPanel[] chooserPanels = colorChooser.getChooserPanels();
    // Remove all color options except swatches.
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
    mousePositionLabel = new JLabel();
    mousePositionLabel.setHorizontalAlignment(SwingConstants.RIGHT);

    // Mouseadapter.
    pixelGridMouseAdapter = new PixelGridMouseAdapter(pixelGrid, colorChooser, mousePositionLabel);
    buttonClickListener = new ButtonClickListener(pixelGrid);
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
    toolbarButtons.add(mousePositionLabel);
    // Add buttons and color chooser to toolbar and add it to JFrame.
    toolbar.add(colorChooser, BorderLayout.CENTER);
    toolbar.add(toolbarButtons, BorderLayout.SOUTH);
    add(toolbar, BorderLayout.SOUTH);
  }

  /**
   * Adds listeners to UI elements.
   */
  private void createListeners() {
    // Add buttons.
    newButton.addActionListener(buttonClickListener);
    saveButton.addActionListener(buttonClickListener);
    loadButton.addActionListener(buttonClickListener);

    // Add PixelGridMouseAdapter to GUI.PixelGrid.
    pixelGrid.addMouseMotionListener(pixelGridMouseAdapter);
    pixelGrid.addMouseListener(pixelGridMouseAdapter);
  }
}
