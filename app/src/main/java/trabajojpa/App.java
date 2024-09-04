package trabajojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import trabajojpa.Entidades.Articulo;
import trabajojpa.Entidades.Categoria;
import trabajojpa.Entidades.Cliente;
import trabajojpa.Entidades.DetalleFactura;
import trabajojpa.Entidades.Domicilio;
import trabajojpa.Entidades.Factura;

public class App {

    public static void main(String[] args) {

        // crea el EntytyManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        System.out.printf("EntityManagerFactory Creado");

        // crea el EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.printf("EntityManager Creado");

        try {
            // Persistir una nueva entidad Person
            entityManager.getTransaction().begin();

            Factura fact1 = new Factura();

            fact1.setNumero(1);
            fact1.setFecha("10/08/2024");

            Domicilio domi1 = new Domicilio("Belgrano", 1234);

            Cliente cli1 = new Cliente("Juan", "Pérez", 123456);

            cli1.setDomicilio(domi1);
            fact1.setCliente(cli1);

            Categoria perecedero = new Categoria("Perecedero");
            Categoria lacteos = new Categoria("Lacteo");
            Categoria limpieza = new Categoria("Limpieza");

            Articulo art1 = new Articulo(200, "Yogur Serenito Sabor vainilla", 20);
            Articulo art2 = new Articulo(350, "Detergente Magistral", 30);

            art1.getCategoria().add(perecedero);
            art1.getCategoria().add(lacteos);
            lacteos.getArticulo().add(art1);
            perecedero.getArticulo().add(art1);

            art2.getCategoria().add(limpieza);
            limpieza.getArticulo().add(art2);

            DetalleFactura det1 = new DetalleFactura();
            det1.setArticulo(art1);
            det1.setCantidad(2);
            det1.setSubtotal(40);

            art1.getDetalleFactura().add(det1);
            fact1.getDetalleFactura().add(det1);
            det1.setFactura(fact1);

            DetalleFactura det2 = new DetalleFactura();

            det2.setArticulo(art2);
            det2.setCantidad(1);
            det2.setSubtotal(89);

            art2.getDetalleFactura().add(det2);
            fact1.getDetalleFactura().add(det2);
            det2.setFactura(fact1);

            fact1.setTotal(120);
            entityManager.persist(cli1);

            entityManager.flush();

            entityManager.getTransaction().commit();

            // Consultar y mostrar la entidad persistida
            // Persona retrievedPerson = entityManager.find(Persona.class, person.getId());
            // System.out.println("Retrieved Person: " + retrievedPerson.getName());
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
