package DAO;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.Usuarios;

public class UsuariosDao {

	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UsuariosDao() {
        // Crea la instancia de EntityManagerFactory
        this.entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        // Crea la instancia de EntityManager
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void insertarUsuario(Usuarios usuarios) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Usuarios usuario = new Usuarios();
            usuario.setNombres(usuarios.getNombres());
            usuario.setApellidos(usuarios.getApellidos());
            usuario.setEdad(usuarios.getEdad());
            usuario.setUsuario(usuarios.getUsuario());
            usuario.setPassword(usuarios.getPassword());
            usuario.setEmail(usuarios.getEmail());
            usuario.setEstado(usuarios.getEstado());
            usuario.setTelefono(usuarios.getTelefono());
            usuario.setFecha_Salida(null); // NULL si no se conoce aún

            entityManager.persist(usuario);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cierra el EntityManager
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
	
}
