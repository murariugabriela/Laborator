package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Catalog {
    private String name;
    private List<Item> items = new ArrayList<>();

    Catalog(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void addItem(Item item) throws Exception {

        File file = new File(item.getPath());
        if (file.exists()) {
            items.add(item);
        } else {
            throw new Exception("Fisierul " + item.getName() + " nu exista");
        }
    }

    void listItems() {
        for (Item item : items) {
            System.out.println(item.getName() + " " + item.getPath());
        }
    }

    void play(Item item) throws Exception {
        Exception myExceptionOpen = new Exception("Fisierul " + item.getName() + " nu exista");
        Exception myExceptionDesktop = new Exception("Programul nu are acces la Desktop");
        File file = new File(item.getPath());
        if (!Desktop.isDesktopSupported()) {
            System.out.println("not supported");
            throw myExceptionDesktop;
        }
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        } else {
            throw myExceptionOpen;
        }

    }

    void save(Catalog catalog) throws Exception {
        FileOutputStream fileToSaveTo = new FileOutputStream("E:\\Gabe\\facultate\\An 2\\Sem2\\Programare Avansata - Java\\Lab5 Compulsory\\src\\com\\company\\" + catalog.getName() + ".txt");
        try {
            for (Item item : items) {
                fileToSaveTo.write(item.getName().getBytes());
                fileToSaveTo.write(' ');
                fileToSaveTo.write(item.getPath().getBytes());
                fileToSaveTo.write('\n');
            }
            fileToSaveTo.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void load(Catalog catalog) throws FileNotFoundException {
        try {
            List<String> textNameAndPath = Files.readAllLines(Paths.get("E:\\Gabe\\facultate\\An 2\\Sem2\\Programare Avansata - Java\\Lab5 Compulsory\\src\\com\\company\\" + this.getName() + ".txt"));
            for (String s : textNameAndPath) {
                int positionPath = s.lastIndexOf(":") - 1;
                String name = s.substring(0, positionPath - 1);
                String path = s.substring(positionPath);
                int fileNamePosition = path.lastIndexOf("\\") + 1;
                Pattern image = Pattern.compile("([0-9a-zA-Z_\\-.\\s\\[\\]]+(\\.(?i)(jpe?g|png|gif|bmp))$)");
                Pattern movie = Pattern.compile("([0-9a-zA-Z_\\-.\\s\\[\\]]+(\\.(?i)(mkv|mp4|amv|mpg))$)");
                Pattern song = Pattern.compile("([0-9a-zA-Z_\\-.\\s\\[\\]]+(\\.(?i)(mp3|wav))$)");
                if (image.matcher(path.substring(fileNamePosition)).matches()) {
                    Image imageItem = new Image(name, path);
                    catalog.addItem(imageItem);
                } else if (movie.matcher(path.substring(fileNamePosition)).matches()) {
                    Movie movieItem = new Movie(name, path);
                    catalog.addItem(movieItem);
                } else if (song.matcher(path.substring(fileNamePosition)).matches()) {
                    Song songItem = new Song(name, path);
                    catalog.addItem(songItem);
                } else {
                    System.err.println("Nu exista tipul de fisier " + name + " " + path);
                }

            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
