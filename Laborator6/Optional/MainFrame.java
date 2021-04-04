package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel = new ConfigPanel(this);
    ControlPanel controlPanel = new ControlPanel(this);
    DrawingPanel canvas;

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this);
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(controlPanel, BorderLayout.SOUTH);
        add(configPanel, BorderLayout.NORTH);
        pack();
    }

}
