package trabajojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import trabajojpa.Entidades.Cliente;

public class App {

    public static void main(String[] args) {

//crea el EntytyManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unidadPersistencia");
        System.out.printf("EntityManagerFactory Creado");

//crea el EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.printf("EntityManager Creado");

        try {
            // Persistir una nueva entidad Person
            entityManager.getTransaction().begin();

            Cliente cli1 = new Cliente("Juan", "Pérez", 123456);

            entityManager.persist(cli1);

            entityManager.flush();

            entityManager.getTransaction().commit();

            // Consultar y mostrar la entidad persistida
            //Persona retrievedPerson = entityManager.find(Persona.class, person.getId());
            //System.out.println("Retrieved Person: " + retrievedPerson.getName());
        } catch (Exception e) {

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("Error inesperado durante la ejecución");
        }

// Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }

}
