import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadCommand extends GenericMethod {
    @Override
    public void command(List<String> tokens, Catalog catalog) throws Exception {
        if (tokens.size() <= 1) {
            throw new Exception("Comanda trebuie sa fie de tipul load catalogName");
        }
        Catalog savedCatalog = new Catalog("catalog2");
        try {
            FileInputStream fileInputStream = new FileInputStream("catalog");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            savedCatalog = ((Catalog) objectInputStream.readObject());
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        catalog.setItems(savedCatalog.getItems());
        catalog.setName(savedCatalog.getName());
    }
}
