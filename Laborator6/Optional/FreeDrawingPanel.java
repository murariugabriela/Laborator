package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FreeDrawingPanel extends JPanel {
    FreeDraw frame;
    private int x1, y1, x, y;
    private boolean first = true;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public FreeDrawingPanel(FreeDraw frame) {
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
    }


    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);

    }

}

