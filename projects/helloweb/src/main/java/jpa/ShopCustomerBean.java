package jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class ShopCustomerBean {
    @PersistenceContext
    private EntityManager em;
    public List<Customer> getAllCustomers(){
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    public List<Customer> getBigCityCustomers(){
        CriteriaQuery<Customer> ca = em.getCriteriaBuilder().createQuery(Customer.class);
        Root<Customer> cust = ca.from(Customer.class);
        ca.select(cust);
        ca.where(cust.get(Customer_.address).get(Address_.city).in("New York", "Detroit"));
        return em.createQuery(ca).getResultList();
    }
}
