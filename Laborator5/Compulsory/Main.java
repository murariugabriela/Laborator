package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        Catalog catalog = new Catalog("catalog1");
        Song song1 = new Song("Phil Collins - In the Air Tonight","E:\\Gabe\\alin\\playlist\\Phil Collins - In the Air Tonight.mp3");
        Image image1 = new Image("Bear","E:\\Gabe\\alin\\Brasov 2019\\brasov2019\\20190904_125653.jpg");
        Movie movie1 = new Movie("Hamilton","C:\\Users\\Gabe\\Downloads\\Hamilton.2020.1080p.WEB.h264-WATCHER[rarbg]\\hamilton.2020.1080p.web.h264-watcher.mkv");
        Song song2 = new Song("Zip", "C:\\Users\\Gabe\\Desktop\\Diagrame.zip");
        catalog.addItem(song1);
        catalog.addItem(image1);
        catalog.addItem(movie1);
        catalog.addItem(song2);
        catalog.listItems();
//        catalog.play(song1);
//        catalog.play(image1);
        //catalog.play(song2);
        //catalog.play(movie1);
        Catalog catalog2 = new Catalog("catalog2");
        catalog.load(catalog2);
        catalog2.save(catalog2);
        catalog2.listItems();
    }
}
