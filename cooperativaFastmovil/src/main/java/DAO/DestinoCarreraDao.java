package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.Choferes;
import modelo.DestinoCarrera;

public class DestinoCarreraDao {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public boolean insertarDestinoCarrera(DestinoCarrera destinoCarrera) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            DestinoCarrera destino = new DestinoCarrera();
            destino.setOrigen(destinoCarrera.getOrigen());
            destino.setDestino(destinoCarrera.getDestino());
            destino.setValor(destinoCarrera.getValor());
            entityManager.persist(destino);

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public List<DestinoCarrera> obtenerDestinoCarreraFiltro(String filtro) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<DestinoCarrera> desiDestinoCarreras = null;
        try {
        	System.out.println("ingreso a buscar DAO");
            String hql = "from DestinoCarrera c where upper(c.Destino) like upper(:filtro) order by c.valor asc";
            desiDestinoCarreras = entityManager.createQuery(hql, DestinoCarrera.class)
            								   .setParameter("filtro", "%" + filtro + "%")
            								   .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return desiDestinoCarreras;
    }
    
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
