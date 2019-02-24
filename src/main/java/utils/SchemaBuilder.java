/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesper
 */
public class SchemaBuilder {

    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Customer c1 = new Customer("Jesper", "Christensen");
            c1.addHobbies("Gaming");
            c1.addPhone("123456789", "Home");
            c1.addPhone("987654321", "Mobile");
            em.persist(c1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
