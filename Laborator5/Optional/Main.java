import java.util.Objects;

public class Main {

    public static void main(String[] args) throws Exception {
        Catalog catalog = new Catalog("catalog1");
        Song song1 = new Song("Phil Collins - In the Air Tonight", "E:\\Gabe\\alin\\playlist\\Phil Collins - In the Air Tonight.mp3");
        Image image1 = new Image("Bear", "E:\\Gabe\\alin\\Brasov2019\\brasov2019\\20190904_125653.jpg");
        Movie movie1 = new Movie("Hamilton", "C:\\Users\\Gabe\\Downloads\\Hamilton.2020.1080p.WEB.h264-WATCHER[rarbg]\\hamilton.2020.1080p.web.h264-watcher.mkv");
        Song song2 = new Song("Zip", "C:\\Users\\Gabe\\Desktop\\Diagrame.zip");
        SaveCommand saveCommand = new SaveCommand();
        PlayCommand playCommand = new PlayCommand();
        AddCommand addCommand = new AddCommand();
        LoadCommand loadCommand = new LoadCommand();
        ListCommand listCommand = new ListCommand();
        SimpleShell simpleShell = new SimpleShell();
        if (Objects.equals(simpleShell.getCommandLineTokens().get(0), "Add"))
            addCommand.command(simpleShell.getCommandLineTokens(), catalog);
        SimpleShell simpleShell2 = new SimpleShell();
        if (Objects.equals(simpleShell2.getCommandLineTokens().get(0), "Play"))
            playCommand.command(simpleShell2.getCommandLineTokens(), catalog);
        SimpleShell simpleShell3 = new SimpleShell();
        if (Objects.equals(simpleShell3.getCommandLineTokens().get(0), "Save"))
            saveCommand.command(simpleShell3.getCommandLineTokens(), catalog);
        SimpleShell simpleShell4 = new SimpleShell();
        Catalog catalog2 = new Catalog("catalog2");
        if (Objects.equals(simpleShell4.getCommandLineTokens().get(0), "Load"))
            loadCommand.command(simpleShell4.getCommandLineTokens(), catalog2);
        SimpleShell simpleShell5 = new SimpleShell();
        if (Objects.equals(simpleShell5.getCommandLineTokens().get(0), "List"))
            listCommand.command(simpleShell5.getCommandLineTokens(), catalog2);

    }
}