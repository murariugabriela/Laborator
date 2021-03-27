import java.io.File;
import java.util.List;
import java.util.Objects;

public class AddCommand extends GenericMethod {

    @Override
    public void command(List<String> tokens, Catalog catalog) throws Exception {
//        Add Song/Image/Movie name path year/artistName/width *height
        if (tokens.size() <= 3) {
            throw new Exception("Comanda trebuie sa fie de tipul Add Song/Image/Movie name path year/artistName/width *height");
        }
        String name = tokens.get(2);
        String type = tokens.get(1);
        String path = tokens.get(3);
        File file = new File(path);
        if (file.exists()) {
            List<Item> itemList = catalog.getItems();
            if (Objects.equals(type, "Movie")) {
                Movie item = new Movie(name, path);
                item.setYear(Integer.parseInt(tokens.get(4)));
                itemList.add(item);
                catalog.setItems(itemList);
            } else if (Objects.equals(type, "Image")) {
                try{
                    Image item = new Image(name, path);
                    item.setWidth(Integer.parseInt(tokens.get(4)));
                    item.setHeight(Integer.parseInt(tokens.get(5)));
                    itemList.add(item);
                    catalog.setItems(itemList);}
                catch (Exception e)
                {
                    System.err.println("Lipseste un argument");
                    e.printStackTrace();
                }

            } else if (Objects.equals(type, "Song")) {
                Song item = new Song(name, path);
                item.setArtistName(tokens.get(4));
                itemList.add(item);
                catalog.setItems(itemList);
            } else {
                throw new Exception("Comanda trebuie sa fie de forma: Add Song/Image/Movie name path year/artistName/width *height(doar pt imagini)");
            }
            catalog.setItems(itemList);
        }
    }
}
