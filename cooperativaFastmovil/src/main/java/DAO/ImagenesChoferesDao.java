package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.Part;

import modelo.Choferes;
import modelo.ImagenData;
import modelo.ImagenesChoferes;

public class ImagenesChoferesDao {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

	public boolean insertarImagen(int choferId, List<ImagenData> imagesDataList) {
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();
	    try {
	        transaction.begin();
	        
	        for (ImagenData imagenData : imagesDataList) {

	        	byte[] imagenBytes = imagenData.getImageBytes();
	        	String tipoImagen = imagenData.gettipoImagen();
	        	
		        ImagenesChoferes imagen = new ImagenesChoferes();
		        imagen.setImagen(imagenBytes);
		        imagen.setTipo(tipoImagen);

		        Choferes chofer = entityManager.find(Choferes.class, choferId);
		        if (chofer != null) {
		        	imagen.setChofer_id(chofer); // Establece la relación con el chofer
		            entityManager.persist(imagen); // Guarda la imagen
		        } else {
		            return false; // El chofer no existe
		        }
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
	
	public String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                String nombreImagen = token.substring(token.indexOf('=') + 2, token.length() - 1);
                int posicion= nombreImagen.lastIndexOf('.');
                String nonbreCorto= nombreImagen.substring(0,posicion);
                if ("perfil".equals(nonbreCorto)) {
                	return "P";
                }else {
                	return "V";
                }
            }
        }
    
        return null;
    }
	
	public List<ImagenesChoferes> obtenerImagenesID(int idChofer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<ImagenesChoferes> imagenesChoferes = null;
        try {
            String hql = "FROM ImagenesChoferes where id_chofer = :idChofer";
            imagenesChoferes = entityManager.createQuery(hql, ImagenesChoferes.class)
            						.setParameter("idChofer", idChofer)
            						.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return imagenesChoferes;
    }
	
	public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
	
}
