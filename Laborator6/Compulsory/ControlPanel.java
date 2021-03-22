import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton load = new JButton("Load");
    JButton reset = new JButton("Reset");
    JButton exit = new JButton("Exit");

    //todo create all buttons (Load, Reset, Exit)
    ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(load);
        add(reset);
        add(exit);
        add(saveBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        load.addActionListener(this::load);
        exit.addActionListener(this::exit);
        reset.addActionListener(this::reset);

    }

    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(frame);
        File file = fileChooser.getSelectedFile();
        try {
            ImageIO.write(frame.canvas.image, "PNG", file);
            repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int option = fileChooser.showOpenDialog(frame);
            File file = fileChooser.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            BufferedImage image = ImageIO.read(fis);
            frame.canvas.image = image;
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void exit(ActionEvent e) {
        frame.dispose();
    }

    private void reset(ActionEvent e) {
        frame.canvas.createOffscreenImage();
        revalidate();
        repaint();
    }

}
