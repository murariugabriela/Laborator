import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveCommand extends GenericMethod {

    @Override
    public void command(List<String> tokens, Catalog catalog) throws Exception {
        if (tokens.size() <= 1) {
            throw new Exception("Comanda trebuie sa fie de tipul save catalogName");
        }
        try {
            FileOutputStream fileToSaveTo = new FileOutputStream("catalog");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileToSaveTo);
            objectOutputStream.writeObject(catalog);
            objectOutputStream.flush();
            fileToSaveTo.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
