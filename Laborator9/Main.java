import Management.EntityManagement;
import Models.Actor;
import Models.Movie;
import Repositories.MoviesRepository;

import javax.persistence.EntityManager;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagement management = EntityManagement.getManagement();
        EntityManager entityManager = management.getEntityManager();
        entityManager.getTransaction().begin();
        Movie movie = new Movie();
        movie.setDuration(120f);
        movie.setRelease_date(Date.valueOf("1997-12-19"));
        movie.setTitle("Titanic");
        movie.setScore(7.6f);
        MoviesRepository moviesRepository = new MoviesRepository();
        System.out.println(moviesRepository.findById(4));
        System.out.println(moviesRepository.findByName("Cleopatra"));
        moviesRepository.create(movie);
        System.out.println(moviesRepository.findByName("Titanic"));
        Actor actor = new Actor();
        actor.setId(1);
        actor.setCharacterPlayed("Rose");
        actor.setName("Kate Winslet");
        actor.setMovieId(1);
        entityManager.getTransaction().commit();
        entityManager.close();
        EntityManagement.closeEntityManagerFactory();
    }
}
