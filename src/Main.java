import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Create gui.
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
}
