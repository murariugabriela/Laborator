package Repositories;

import Management.EntityManagement;
import Models.Message;
import Models.User;

import javax.persistence.EntityManager;
import java.util.List;

public class MessageRepository {
    EntityManagement management = EntityManagement.getManagement();
    EntityManager entityManager = management.getEntityManager();
    final UserRepository userRepository = new UserRepository();
    public Object findById(int userId) {

        return entityManager.find(Message.class, userId);
    }
    public List<Object> findByUserId(Integer userId) {
        List<Object> query = entityManager.createNamedQuery("Message.findById").setParameter("id", userId).getResultList();
        return query;
    }

    //    @Modifying
//    @Transactional
    public void sendMessage(String username, String message, String sender) {
//        entityManager.joinTransaction();
//        int countUpdated = entityManager.createNativeQuery("update users set messages = concat(concat(concat(concat(?3,': '), ?1),'$'), (select messages from users where username = ?2)) where username = ?2").setParameter(1, message).setParameter(2, username).setParameter(3, sender).executeUpdate();
//        System.out.println(countUpdated);
        System.out.println(username + " " + message + " " + sender);
        Message message1 = new Message(((User)userRepository.findByName(username)).getId(),sender + ": " + message);
//        System.out.println(message1);
        entityManager.persist(message1);
    }
}
