package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class FreeDraw extends JFrame implements MouseMotionListener {

    private int x1, y1, x, y;
    private int W = 800, H = 600;
    private boolean first = true;
    private JButton button = new JButton("Figures Draw");
    BufferedImage image; //the offscreen image
    Graphics2D graphics;

    public FreeDraw(int width, int height) {
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createOffscreenImage();
        setVisible(true);
        button.addActionListener(this::figuresDraw);
         FreeDrawingPanel canvas = new FreeDrawingPanel(this);
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(button, BorderLayout.NORTH);
        pack();
        addMouseMotionListener(this);
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = x1;
        y = y1;
        x1 = e.getX();
        y1 = e.getY();
        if (first) {
            x = x1;
            y = y1;
            first = false;
        }
        repaint();
    }
    public void figuresDraw(ActionEvent actionEvent)
    {
        this.dispose();
        new MainFrame().setVisible(true);
    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void paint(Graphics graphics) {
        graphics.drawLine(x, y, x1, y1);
    }

}

