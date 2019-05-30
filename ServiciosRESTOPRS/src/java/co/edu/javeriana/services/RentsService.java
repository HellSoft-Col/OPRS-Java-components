/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.services;

import co.edu.javeriana.dtos.RentDTO;
import co.edu.javeriana.facades.FacadeBuscarTransaccionesRentasRemote;
import com.google.gson.Gson;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author LICHO
 */
@Path("rents")
public class RentsService {
    
    FacadeBuscarTransaccionesRentasRemote facadeBuscarTransaccionesRentas = lookupFacadeBuscarTransaccionesRentasRemote();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RentsService
     */
    public RentsService() {
    }

    /**
     * Retrieves representation of an instance of co.edu.javeriana.services.RentsService
     * @return an instance of co.edu.javeriana.dtos.RentDTO
     */
    @GET
    @Produces("application/json")
    public Response getJson() {
        Gson gson = new Gson();
        List<RentDTO> res =  this.facadeBuscarTransaccionesRentas.buscarTransaccionesRentas();
        String json = gson.toJson(res);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    /**
     * PUT method for updating or creating an instance of RentsService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(RentDTO content) {
     
    }

    private FacadeBuscarTransaccionesRentasRemote lookupFacadeBuscarTransaccionesRentasRemote() {
        try {
            javax.naming.Context c = new InitialContext();
            return (FacadeBuscarTransaccionesRentasRemote) c.lookup("java:global/LogicaDeNegocioOPRS/FacadeBuscarTransaccionesRentas!co.edu.javeriana.facades.FacadeBuscarTransaccionesRentasRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
