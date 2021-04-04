package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JComboBox figureField = new JComboBox(); // number of sides
    JComboBox colorCombo = new JComboBox(); // the color of the shape
    private JButton button = new JButton("Free Draw");
    JSpinner figureSize;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        JButton update = new JButton("Update color combo");
        //create the label and the spinner
        JLabel sidesLabel = new JLabel("Number of sides:");
        JLabel sizeLabel = new JLabel("Size:");
        String figure[] = {"Square", "Circle","Snowflake"};
        figureField = new JComboBox(figure);
        figureSize = new JSpinner(new SpinnerNumberModel(5, 5, 500, 1));
        figureSize.setValue(50);
        button.addActionListener(this::freeDraw);
        //TODO create the colorCombo, containing the values: Random and Black
        add(sizeLabel);
        add(figureSize);
        add(sidesLabel); //JPanel uses FlowLayout by default
        String colors[] = {"BLACK", "RANDOM"};
        colorCombo = new JComboBox(colors);
        add(figureField);
        add(colorCombo);
        add(button);
    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }

    public JComboBox getFigureField() {
        return figureField;
    }
    public JSpinner getFigureSize() {
        return figureSize;
    }
    private void freeDraw(ActionEvent e) {
        frame.dispose();
        new FreeDraw(800,600);
    }
}
