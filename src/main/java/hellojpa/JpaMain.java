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

        tx.begin();


//                  객체를 테이블 중심으로 모델링
//        try{
//
//            Team team = new Team();
//            team.setName("아연이네");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("아연");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member member1 = em.find(Member.class, member.getId());
//            Long teamId = member1.getTeamId();
//            Team team1 = em.find(Team.class, teamId);
//
//            System.out.println("team1 = " + team1);
//
//
//            System.out.println("member = " + member.getTeamId());
//
//
//            tx.commit();
//        }catch(Exception e ){
//            tx.rollback();
//        }finally{
//            em.close();
//        }emf.close();
//

        try{

            Team team = new Team();
            team.setName("아연이네");
            em.persist(team);

            Member member = new Member();
            member.setUsername("아연");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member member1 = em.find(Member.class, member.getId());
            Team team1 = member1.getTeam();
//            Team team2 = em.find(Team.class, team1);
            System.out.println("member.teamId = " + team1.getId());

            // 수정
//            Team newTeam = em.find(Team.class, 100L);
//            member1.setTeam(newTeam);

            tx.commit();
        }catch(Exception e ){
            tx.rollback();
        }finally{
            em.close();
        }emf.close();

        }
    }
