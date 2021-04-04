package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class DrawingPanel extends JPanel {
    MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    private List<Shape> shapeList = new ArrayList<>();

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
                paintShape(shapeList);
            }
        });

    }

    public void paintShape(List<Shape> shapeList) {
        for (Shape shape : shapeList) {
            graphics.draw(shape);
            graphics.fill(shape);
            repaint();
        }

    }

    public void setShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public List<Shape> getShapeList() {
        return shapeList;
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
        if (Objects.equals(chosenFigure, "Square")) {
            shapeList.add(new Rectangle2D.Float(x, y, x + radius, y + radius));
//            graphics.fill(new RegularPolygon(x, y, radius, 4));
        } else if (Objects.equals(chosenFigure, "Circle")) {
            shapeList.add(new Ellipse2D.Float(x, y, radius, radius));
//            graphics.drawOval(x, y, radius, radius);
//            graphics.fillOval(x, y, radius, radius);
        } else {
//            shapeList.add(new Line2D.Float(x,y,radius,radius));
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

