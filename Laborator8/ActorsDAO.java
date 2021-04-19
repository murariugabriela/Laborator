import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorsDAO implements DAO<Actor>{

    private DBConnection dbConnection = DBConnection.getConnection();
    private List<Actor> actors = new ArrayList<>();
    @Override
    public Actor getById(long id) {
        Actor actor = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from actors where actor_id=?;");
            preparedStatement.setInt(1, (int) id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                int movie_id = resultSet.getInt(3);
                String characterPlayed = resultSet.getString(4);
                //    actor_id   actor_name   movie_id charac_played
                actor = new Actor((int) id, name, movie_id, characterPlayed);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return actor;
    }

    @Override
    public List<Actor> getAll() {
        List<Actor> actors = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Select * from actors;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int movie_id = resultSet.getInt(3);
                String characterPlayed = resultSet.getString(4);
                //    actor_id   actor_name   movie_id charac_played
                Actor actor = new Actor(id, name, movie_id, characterPlayed);
                actors.add(actor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return actors;
    }

    @Override
    public void save(Actor actor) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dbConnection.getConnectionDB().prepareStatement("Insert into actors (actor_name,character_played_name,movie_id) values(?,?,?);");

            preparedStatement.setString(1, actor.getName());
            preparedStatement.setString(2, actor.getCharachterPlayed());
            preparedStatement.setInt(3, actor.getMovie_id());
//            int affectedRows = preparedStatement.executeUpdate();
//            System.out.println(affectedRows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
