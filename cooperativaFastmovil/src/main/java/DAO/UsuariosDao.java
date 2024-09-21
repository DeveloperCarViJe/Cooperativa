package DAO;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import modelo.Usuarios;


public class UsuariosDao {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public boolean insertarUsuario(Usuarios usuarios) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
            usuario.setFecha_ingreso(new Date());
            usuario.setFecha_Salida(null); // NULL si no se conoce aún

            entityManager.persist(usuario);

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
    
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
