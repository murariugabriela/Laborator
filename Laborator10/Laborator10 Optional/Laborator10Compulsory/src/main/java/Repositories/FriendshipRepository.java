package Repositories;

import Management.EntityManagement;
import Models.Friendship;
import Models.Friendships;
import Models.User;

import javax.persistence.EntityManager;
import java.util.List;

public class FriendshipRepository {
    EntityManagement management = EntityManagement.getManagement();
    EntityManager entityManager = management.getEntityManager();
    final UserRepository userRepository = new UserRepository();

    public Object findById(int userId) {

        return entityManager.find(Friendships.class, userId);
    }
    public List<Object> findByUserId(Integer userId) {
        List<Object> query = entityManager.createNamedQuery("Friendships.findById").setParameter("id", userId).getResultList();
        return query;
    }

    public List<Object> getAll() {
        List<Object> query = entityManager.createNamedQuery("Friendships.getAll").getResultList();
        return query;
    }
    //    @Modifying
//    @Transactional
    public void addFriend(String name, String username) {
//        entityManager.joinTransaction();
//        int countUpdated = entityManager.createNativeQuery("update users set friends = concat(concat(?1, ', '), (select friends from users where username = ?2)) where username = ?2").setParameter(1, name).setParameter(2, username).executeUpdate();
//        System.out.println(countUpdated);
        entityManager.persist(new Friendships(((User)userRepository.findByName(username)).getId(),((User)userRepository.findByName(name)).getId()));
    }
}
