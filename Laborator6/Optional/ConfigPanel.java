package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConfigPanel extends JPanel {
    MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JComboBox figureField = new JComboBox(); // number of sides
    JComboBox colorCombo = new JComboBox(); // the color of the shape
    private JButton button = new JButton("Free Draw");
    private JButton button2 = new JButton("Delete Figure");
    private JSpinner buttonDelete;
    JSpinner figureSize;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        JLabel deleteLabel = new JLabel("index of the figure to delete:");
        buttonDelete = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        JButton update = new JButton("Update color combo");
        //create the label and the spinner
        JLabel sidesLabel = new JLabel("Number of sides:");
        JLabel sizeLabel = new JLabel("Size:");
        String figure[] = {"Square", "Circle", "Snowflake"};
        figureField = new JComboBox(figure);
        figureSize = new JSpinner(new SpinnerNumberModel(5, 5, 500, 1));
        figureSize.setValue(50);
        button.addActionListener(this::freeDraw);
        button2.addActionListener(this::delete);
        //TODO create the colorCombo, containing the values: Random and Black
        add(sizeLabel);
        add(figureSize);
        add(sidesLabel); //JPanel uses FlowLayout by default
        String colors[] = {"BLACK", "RANDOM"};
        colorCombo = new JComboBox(colors);
        add(figureField);
        add(colorCombo);
        add(button);
        add(deleteLabel);
        add(buttonDelete);
        add(button2);
    }

    private void delete(ActionEvent e) {
        List<Shape> temporaryList = new ArrayList<>();
        for (Shape shape : this.frame.getCanvas().getShapeList()) {
            if (!Objects.equals(shape, frame.getCanvas().getShapeList().get((int) getButtonDelete().getValue()))) {
                temporaryList.add(shape);
            }
        }
        this.frame.canvas.setShapeList(temporaryList);
        Shape screen = new Rectangle2D.Float(0, 0, 800, 600);
        this.frame.canvas.graphics.setColor(Color.white);
        this.frame.canvas.graphics.draw(screen);
        this.frame.canvas.graphics.fill(screen);
        repaint();
        for (Shape shape : temporaryList) {
            frame.canvas.graphics.draw(shape);
            frame.canvas.graphics.fill(shape);
            repaint();
        }

    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }

    public JSpinner getButtonDelete() {
        return buttonDelete;
    }

    public JComboBox getFigureField() {
        return figureField;
    }

    public JSpinner getFigureSize() {
        return figureSize;
    }

    private void freeDraw(ActionEvent e) {
        frame.dispose();
        new FreeDraw(800, 600);
    }
}
