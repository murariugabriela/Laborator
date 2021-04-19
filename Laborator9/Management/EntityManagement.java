package Management;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagement {
    private static final EntityManagement management = new EntityManagement();
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    private EntityManagement() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Laborator9");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static EntityManagement getManagement() {
        return management;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
