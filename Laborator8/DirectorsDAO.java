import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorsDAO implements DAO<Director>{

    private DBConnection dbConnection = DBConnection.getConnection();
    private List<Director> directors = new ArrayList<>();
    @Override
    public Director getById(long id) {
        Director director = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from directors where director_id=?;");
            preparedStatement.setInt(1, (int) id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                int movie_id = resultSet.getInt(3);
                director = new Director((int) id, name, movie_id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return director;
    }

    @Override
    public List<Director> getAll() {
        List<Director> directors = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from directors;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int movie_id = resultSet.getInt(3);
                Director director = new Director(id, name, movie_id);
                directors.add(director);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return directors;
    }

    @Override
    public void save(Director director) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Insert into movies (director_name,movie_id) values(?,?);");

            preparedStatement.setString(1, director.getName());
            preparedStatement.setInt(2, director.getMovieId());
//            int affectedRows = preparedStatement.executeUpdate();
//            System.out.println(affectedRows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
