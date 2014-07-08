package jpa;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("customers")
public class CustomerResource {
    @EJB ShopCustomerBean customerBean;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Customer> getCustomers(){
        return customerBean.getAllCustomers();
    }

    @Path("bigcity")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Customer> getBigCityCustomers(){
        return customerBean.getBigCityCustomers();
    }
}
