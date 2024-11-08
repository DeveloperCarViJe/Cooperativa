package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.Choferes;
import modelo.DestinoCarrera;
import modelo.Usuarios;

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
    
    public void actualizarDestino(DestinoCarrera destinoCarrera) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            // Verificar si el usuario existe antes de hacer un merge
            DestinoCarrera destinoExistente = entityManager.find(DestinoCarrera.class, destinoCarrera.getId());
            if (destinoExistente != null) {
            	destinoExistente.setValor(destinoCarrera.getValor());

                entityManager.merge(destinoExistente);  // Actualizar el usuario
                transaction.commit();
            }
            
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
