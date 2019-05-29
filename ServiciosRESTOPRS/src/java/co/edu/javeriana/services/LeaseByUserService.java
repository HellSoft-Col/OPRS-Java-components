/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.services;

import co.edu.javeriana.dtos.RentSignDTO;
import co.edu.javeriana.facades.FacadeObtenerContratosSinFirmarRemote;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author SANTI
 */
@Path("LeaseByUser")
public class LeaseByUserService {
    private FacadeObtenerContratosSinFirmarRemote facadeObtenerContratosSinFirmar = lookupFacadeObtenerContratosSinFirmarRemote();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LeaseByUserService
     */
    public LeaseByUserService() {
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public List<RentSignDTO> getUnsignedLeasesCustomer(@PathParam("id") BigDecimal id) {
        return this.facadeObtenerContratosSinFirmar.getContratosSinFirmarCustomer(id);
    }

    private FacadeObtenerContratosSinFirmarRemote lookupFacadeObtenerContratosSinFirmarRemote() {
        try {
            javax.naming.Context c = new InitialContext();
            return (FacadeObtenerContratosSinFirmarRemote) c.lookup("java:global/LogicaDeNegocioOPRS/FacadeObtenerContratosSinFirmar!co.edu.javeriana.facades.FacadeObtenerContratosSinFirmarRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
