
package utils;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesper
 */
public class Tester {
    public static void main(String[] args) {
        //Persistence.generateSchema("pu", null);
        Person p1 = new Person("Jesper Christensen");
        Person p2 = new Person("Jasper Christensen");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
            
            
        } finally {
            em.close();
        }
        System.out.println(p1);
    }
    
}

