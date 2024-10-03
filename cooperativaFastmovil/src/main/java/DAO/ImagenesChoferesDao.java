package DAO;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.Choferes;
import modelo.ImagenesChoferes;

public class ImagenesChoferesDao {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

	public boolean insertarImagen(int choferId, byte[] imageBytes) {
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();
	    try {
	        transaction.begin();
	        
	        // Crea una nueva instancia de ImagenesChoferes
	        ImagenesChoferes imagen = new ImagenesChoferes();
	        imagen.setImagen(imageBytes); // Suponiendo que tienes un método setImagen en tu entidad
	        // Configura la relación con el chofer
	        Choferes chofer = entityManager.find(Choferes.class, choferId);
	        if (chofer != null) {
	            imagen.setChofer_id(chofer); // Establece la relación con el chofer
	            entityManager.persist(imagen); // Guarda la imagen
	        } else {
	            return false; // El chofer no existe
	        }

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
	
}
