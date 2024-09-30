package DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.Choferes;

public class ChoferesDao {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public boolean insertarChofer(Choferes choferes) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Choferes chofer = new Choferes();
            chofer.setMovil(choferes.getMovil());
            chofer.setNombres(choferes.getNombres().toUpperCase());
            chofer.setApellidos(choferes.getApellidos().toUpperCase());
            chofer.setEdad(choferes.getEdad());
            chofer.setEmail(choferes.getEmail().toUpperCase());
            chofer.setEstado(choferes.getEstado().toUpperCase());
            chofer.setTelefono(choferes.getTelefono());
            chofer.setDireccion(choferes.getDireccion().toUpperCase());
            chofer.setModelo(choferes.getModelo().toUpperCase());
            chofer.setColor_vehiculo(choferes.getColor_vehiculo().toUpperCase());
            chofer.setNumero_placa(choferes.getNumero_placa().toUpperCase());
            chofer.setFotos_vehiculo(choferes.getFotos_vehiculo());
            chofer.setFecha_ingreso(new Date());
            chofer.setFecha_Salida(null);

            entityManager.persist(chofer);

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
    
    public List<Choferes> obtenerTodosLosChoferes() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Choferes> choferes = null;
        try {
            String hql = "FROM Choferes where estado = 'A' order by movil ASC";
            choferes = entityManager.createQuery(hql, Choferes.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return choferes;
    }
    
    public boolean desactivarChofer(int idChofer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            // Buscar el usuario por ID
            Choferes usuarioExistente = entityManager.find(Choferes.class, idChofer);
            if (usuarioExistente != null) {
                usuarioExistente.setEstado("I");
                usuarioExistente.setFecha_Salida(new Date());
                
                entityManager.merge(usuarioExistente);
                transaction.commit();
            }
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
    
    public boolean movilExistente(int movil) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT c FROM Choferes c WHERE c.movil = :movil and c.estado = 'A'";
            List<Choferes> resultado = entityManager.createQuery(jpql, Choferes.class)
                                                    .setParameter("movil", movil)
                                                    .getResultList();
            return !resultado.isEmpty(); // Devuelve true si el móvil ya existe
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
