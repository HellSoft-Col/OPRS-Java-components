/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.services;

import co.edu.javeriana.dtos.PaymentResponseDTO;
import co.edu.javeriana.dtos.RentPropertyDTO;
import co.edu.javeriana.facades.RentPropertyFacadeRemote;
import com.google.gson.Gson;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author HellSoft
 */
@Path("RentProperty")
public class RentPropertyService {
    RentPropertyFacadeRemote rentPropertyFacade = lookupRentPropertyFacadeRemote();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RentPropertyService
     */
    public RentPropertyService() {
    }

    /**
     * Retrieves representation of an instance of
     * co.edu.javeriana.services.RentPropertyService
     *
     * @return an instance of co.edu.javeriana.dtos.RentPropertyDTO
     */
    @GET
    @Produces("application/json")
    public RentPropertyDTO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewRent(RentPropertyDTO params) {
        Gson gson = new Gson();
        PaymentResponseDTO flag = rentPropertyFacade.AddRent(params);
        if (flag.getAprobacion() == null || flag.getNumAprobacion() == null) {
            return Response.status(Response.Status.NOT_ACCEPTABLE.getStatusCode()).build();
        }
        String json = gson.toJson(flag);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
    
    

    /**
     * PUT method for updating or creating an instance of RentPropertyService
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(RentPropertyDTO content) {
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
