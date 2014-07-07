package ejb;

import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("converter")
public class ConverterResource {
    @EJB
    private ConverterBean converterBean;

    @GET
    @Path("d2y/{dollar}")
    public BigDecimal getYenFromDollar(@PathParam("dollar") BigDecimal dollar){
        return converterBean.dollarToYen(dollar);
    }
    @GET
    @Path("y2e/{yen}")
    public BigDecimal getEuroFromYen(@PathParam("yen") BigDecimal yen){
        return converterBean.yenToEuro(yen);
    }
    
}
