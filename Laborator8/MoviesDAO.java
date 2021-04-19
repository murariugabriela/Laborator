import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAO implements DAO<Movie> {
    private DBConnection dbConnection = DBConnection.getConnection();
    private List<Movie> movies = new ArrayList<>();

    @Override
    public Movie getById(long id) {
        Movie movie = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from movies where movie_id=?;");
            preparedStatement.setInt(1, (int) id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String date = String.valueOf(resultSet.getDate(3));
                float duration = resultSet.getFloat(4);
                float score = resultSet.getFloat(5);
                movie = new Movie((int) id, name, date, duration, score);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movie;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from movies;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String date = String.valueOf(resultSet.getDate(3));
                float duration = resultSet.getFloat(4);
                float score = resultSet.getFloat(5);
                Movie movie = new Movie(id, name, date, duration, score);
                movies.add(movie);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movies;
    }

    @Override
    public void save(Movie movie) {
        PreparedStatement preparedStatement;
        if(movie.getReleaseDate().indexOf("-")!=-1) {
            try {
                preparedStatement = dbConnection.getConnectionDB().prepareStatement("Insert into movies (title,release_date,duration,score) values(?,?,?,?);");
//            preparedStatement.setInt(1, movie.getIdMovie());
                preparedStatement.setString(1, movie.getName());
                preparedStatement.setDate(2, Date.valueOf(movie.getReleaseDate()));
                preparedStatement.setFloat(3, movie.getDuration());
                preparedStatement.setFloat(4, movie.getScore());
                preparedStatement.executeUpdate();
//            System.out.println(affectedRows);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}

