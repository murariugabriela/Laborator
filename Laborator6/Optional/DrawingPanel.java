package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Random;

public class DrawingPanel extends JPanel {
    MainFrame frame;
    private int x1, y1, x, y;
    private boolean first = true;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    protected void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        int radius = (int) frame.getConfigPanel().getFigureSize().getValue();
        String chosenFigure = (String) frame.getConfigPanel().getFigureField().getSelectedItem();
        Random rnd = new Random();
        int r = rnd.nextInt(128) + 128; // 128 ... 255
        int g = rnd.nextInt(128) + 128; // 128 ... 255
        int b = rnd.nextInt(128) + 128; // 128 ... 255
        float hsbValues[] = new float[3];
        Color.RGBtoHSB(r, g, b, hsbValues);
        if (Objects.equals(frame.getConfigPanel().colorCombo.getSelectedItem(), "BLACK"))
            graphics.setColor(Color.BLACK);
        else
            graphics.setColor(Color.getHSBColor(hsbValues[0], hsbValues[1], hsbValues[2]));
        if (Objects.equals(chosenFigure, "Square"))
            graphics.fill(new RegularPolygon(x, y, radius, 4));
        else if (Objects.equals(chosenFigure, "Circle")) {
            graphics.drawOval(x, y, radius, radius);
            graphics.fillOval(x, y, radius, radius);
        } else {
            graphics.setStroke(new BasicStroke(4));
            graphics.drawLine(x, y, x + radius, y + radius);
            graphics.drawLine(x, y + radius, x + radius, y);
            graphics.drawLine(x + radius / 2, y + radius, x + radius / 2, y);
            graphics.drawLine(x, y + radius / 2, x + radius, y + radius / 2);
            graphics.drawLine(x + radius / 2, y + radius, x + radius / 2, y);
        }

    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);

    }

}

