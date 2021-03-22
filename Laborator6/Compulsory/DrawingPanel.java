import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
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
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    private void drawShape(int x, int y) {
        int radius = (int) frame.getConfigPanel().getFigureSize().getValue();
        int sides = (int) frame.getConfigPanel().getSidesField().getValue(); //get the value from UI (in ConfigPanel)
        Random rnd = new Random();
        int r = rnd.nextInt(128) + 128; // 128 ... 255
        int g = rnd.nextInt(128) + 128; // 128 ... 255
        int b = rnd.nextInt(128) + 128; // 128 ... 255
        float hsbValues[] = new float[3];
        Color.RGBtoHSB(r, g, b, hsbValues);
        if(Objects.equals(frame.getConfigPanel().colorCombo.getSelectedItem(),"BLACK"))
            graphics.setColor(Color.BLACK);
        else
            graphics.setColor(Color.getHSBColor(hsbValues[0],hsbValues[1],hsbValues[2]));
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) {
    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

