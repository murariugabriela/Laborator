import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieGenresDAO {
    private DBConnection dbConnection = DBConnection.getConnection();
    List<MoviesGenres> moviesGenres = new ArrayList<>();

    public MoviesGenres getByGenreId(long id) {
        MoviesGenres moviesGenres = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from movies_genres where genre_id=?;");
            preparedStatement.setInt(1, (int) id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int movieId = resultSet.getInt(1);
                moviesGenres = new MoviesGenres((int) id, movieId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return moviesGenres;
    }

    public MoviesGenres getByMovieId(long id) {
        MoviesGenres moviesGenres = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from movies_genres where movie_id=?;");
            preparedStatement.setInt(1, (int) id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int genreId = resultSet.getInt(1);
                moviesGenres = new MoviesGenres((int) id, genreId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return moviesGenres;
    }

    public List<MoviesGenres> getAll() {
        List<MoviesGenres> moviesGenres = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from movies_genres;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idMovie = resultSet.getInt(1);
                int idGenre = resultSet.getInt(2);
                moviesGenres.add(new MoviesGenres(idMovie, idGenre));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return moviesGenres;
    }

    public void save(Genre genre, Movie movie) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Insert into movies_genres values(?, ?);");
            preparedStatement.setInt(1, movie.getIdMovie());
            preparedStatement.setInt(2, genre.getIdGenre());
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " randuri afectate ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
