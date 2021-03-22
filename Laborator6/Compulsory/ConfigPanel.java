
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo = new JComboBox(); // the color of the shape
    JSpinner figureSize;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        JButton update = new JButton("Update color combo");
        update.addActionListener(e -> updateCombo());
        updateCombo();
        //create the label and the spinner
        JLabel sidesLabel = new JLabel("Number of sides:");
        JLabel sizeLabel = new JLabel("Size:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        figureSize = new JSpinner(new SpinnerNumberModel(5, 5, 500, 1));
        sidesField.setValue(5); //default number of sides
        figureSize.setValue(50);
        //TODO create the colorCombo, containing the values: Random and Black
        add(sizeLabel);
        add(figureSize);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
        add(update);
    }

    void updateCombo() {
        Random rnd = new Random();
        int r = rnd.nextInt(128) + 128; // 128 ... 255
        int g = rnd.nextInt(128) + 128; // 128 ... 255
        int b = rnd.nextInt(128) + 128; // 128 ... 255
        float hsbValues[] = new float[3];
        Color.RGBtoHSB(r, g, b, hsbValues);
        Color colors[] = new Color[2];
        colors[0] = Color.BLACK;
        colors[1] = Color.getColor("Random", Color.getHSBColor(hsbValues[0], hsbValues[1], hsbValues[2]));
        DefaultComboBoxModel copyColorCombo = new DefaultComboBoxModel(colors);
        colorCombo.setModel(copyColorCombo);
    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public JSpinner getFigureSize() {
        return figureSize;
    }
}
