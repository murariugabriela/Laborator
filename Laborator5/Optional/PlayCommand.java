import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PlayCommand extends GenericMethod {

    @Override
    public void command(List<String> tokens, Catalog catalog) throws Exception {
        if (tokens.size() <= 1) {
            throw new Exception("Comanda trebuie sa fie de tipul play filePath");
        }
        String path = tokens.get(1);
        File file = new File(path);
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
