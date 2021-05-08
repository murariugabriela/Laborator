package Repositories;

import Management.EntityManagement;
import Models.Friendships;
import Models.Message;
import Models.User;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class UserRepository {
    EntityManagement management = EntityManagement.getManagement();
    EntityManager entityManager = management.getEntityManager();

    public Object findById(int userId) {

        return entityManager.find(User.class, userId);
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
