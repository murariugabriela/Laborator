import java.util.List;

public class ListCommand extends GenericMethod {
    @Override
    public void command(List<String> tokens, Catalog catalog) throws Exception {

        if (tokens.size() <= 1) {
            throw new Exception("Comanda trebuie sa fie de tipul list catalogName");
        }
        for (Item item : catalog.getItems()) {
            System.out.println(item.getName() + " " + item.getPath());
        }
    }
}
