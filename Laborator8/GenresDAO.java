import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenresDAO implements DAO<Genre> {
    private DBConnection dbConnection = DBConnection.getConnection();
    private List<Genre> genres = new ArrayList<>();

    @Override
    public Genre getById(long id) {
        Genre genre = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from genres where genre_id=?;");
            preparedStatement.setInt(1, (int) id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                genre = new Genre((int) id, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return genre;
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> genres = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from genres;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Genre genre = new Genre(id, name);
                genres.add(genre);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return genres;
    }

    @Override
    public void save(Genre genre) {
        boolean genreAlreadyExtists = false;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from genres;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                if (Objects.equals(name, genre.getName())) {
                    genreAlreadyExtists = true;
                    break;
                }
            }
            if (!genreAlreadyExtists) {
                preparedStatement = dbConnection.getConnectionDB().prepareStatement("Insert into genres (name) values(?);");

                preparedStatement.setString(1, genre.getName());
                preparedStatement.executeUpdate();
//                System.out.println(affectedRows);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
