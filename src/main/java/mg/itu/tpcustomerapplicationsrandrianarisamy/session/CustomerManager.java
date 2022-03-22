/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mg.itu.tpcustomerapplicationsrandrianarisamy.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mg.itu.tpcustomerapplicationsrandrianarisamy.Customer;

/**
 *
 * @author jolivot
 */
/**
 * Gère la persistance des Customers.
 */
@Stateless
public class CustomerManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void persist(Customer customer) {
      em.persist(customer);
    }
    
    public List<Customer> getAllCustomers() { 
      Query query = em.createNamedQuery("Customer.findAll");
      return query.getResultList();
    }  
        
    public Customer update(Customer customer) {
      return em.merge(customer);
    }       
}
