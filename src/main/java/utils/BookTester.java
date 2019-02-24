/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesper
 */
public class BookTester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Book b1 = new Book("Hello");
        try {
            em.getTransaction().begin();
            em.persist(b1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        System.out.println(b1);
    }
    
    public void findBook(int id) {
        System.out.println();
    }
}
