package Repositories;

import Management.EntityManagement;
import Models.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepository {
    EntityManagement management = EntityManagement.getManagement();
    EntityManager entityManager = management.getEntityManager();
    public Object findById(int movie_id) {

        return entityManager.find(User.class, movie_id);
    }

    public Object findByName(String name) {
        List<Object> query = entityManager.createNamedQuery("User.findByName").setParameter("name", name).getResultList();
        return query.isEmpty() ? null : query.get(0);
    }

    public void create(User user) {
        entityManager.persist(user);
//        entityManager.getTransaction().commit();
//        entityManager.getTransaction().begin();

    }
}
