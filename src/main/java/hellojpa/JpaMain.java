package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try{




            Member member = new Member();

            member.setName("남다연");
            member.setId(250L);

            em.persist(member);

            tx.begin();
            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }emf.close();

    }
    }
