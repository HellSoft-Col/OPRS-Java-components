/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.services;

import co.edu.javeriana.dtos.LeaseUtilityDTO;
import co.edu.javeriana.facades.RentPropertyFacadeRemote;
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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author HellSoft
 */
@Path("SignLease")
public class SignLeaseService {
    private RentPropertyFacadeRemote rentPropertyFacade = lookupRentPropertyFacadeRemote();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SignLeaseService
     */
    public SignLeaseService() {
    }

    /**
     * Retrieves representation of an instance of co.edu.javeriana.services.SignLeaseService
     * @return an instance of co.edu.javeriana.dtos.LeaseUtilityDTO
     */
    @GET
    @Produces("application/json")
    public LeaseUtilityDTO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of SignLeaseService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(LeaseUtilityDTO content) {
    }
    
    @POST
    @Consumes("application/json")
    public Response signLease(LeaseUtilityDTO params){
        boolean flag = this.rentPropertyFacade.SignLease(params.getLease_id());
         if(!flag){
            return Response.serverError().build();
        }
        return Response.ok().build();
    }

    private RentPropertyFacadeRemote lookupRentPropertyFacadeRemote() {
        try {
            javax.naming.Context c = new InitialContext();
            return (RentPropertyFacadeRemote) c.lookup("java:global/LogicaDeNegocioOPRS/RentPropertyFacade!co.edu.javeriana.facades.RentPropertyFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
