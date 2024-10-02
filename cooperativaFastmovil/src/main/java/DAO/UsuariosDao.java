package DAO;

import java.util.Date;
import java.util.List;

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
            usuario.setNombres(usuarios.getNombres().toUpperCase());
            usuario.setApellidos(usuarios.getApellidos().toUpperCase());
            usuario.setEdad(usuarios.getEdad());
            usuario.setUsuario(usuarios.getUsuario().toUpperCase());
            usuario.setPassword(usuarios.getPassword().toUpperCase());
            usuario.setEmail(usuarios.getEmail().toUpperCase());
            usuario.setEstado(usuarios.getEstado().toUpperCase());
            usuario.setTelefono(usuarios.getTelefono());
            usuario.setRol(usuarios.getRol().toUpperCase());
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
    
    public List<Usuarios> obtenerTodosLosUsuarios() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Usuarios> usuarios = null;
        try {
            String hql = "FROM Usuarios where estado = 'A' order by nombres ASC";
            usuarios = entityManager.createQuery(hql, Usuarios.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return usuarios;
    }
    
    public boolean actualizarUsuarios(Usuarios usuarios) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            // Verificar si el usuario existe antes de hacer un merge
            Usuarios usuarioExistente = entityManager.find(Usuarios.class, usuarios.getId_User());
            if (usuarioExistente != null) {
                usuarioExistente.setNombres(usuarios.getNombres().toUpperCase());
                usuarioExistente.setApellidos(usuarios.getApellidos().toUpperCase());
                usuarioExistente.setUsuario(usuarios.getUsuario().toUpperCase());
                usuarioExistente.setPassword(usuarios.getPassword().toUpperCase());
                usuarioExistente.setEmail(usuarios.getEmail().toUpperCase());
                usuarioExistente.setTelefono(usuarios.getTelefono());

                entityManager.merge(usuarioExistente);  // Actualizar el usuario
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
    
    public boolean desactivarUsuario(int idUSer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            // Buscar el usuario por ID
            Usuarios usuarioExistente = entityManager.find(Usuarios.class, idUSer);
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
    
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
