/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.services;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.PropertyQueryDTO;
import co.edu.javeriana.entities.Property;
import co.edu.javeriana.facades.FacadeBuscarPropiedadRemote;
import com.google.gson.Gson;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("serachProperty")
public class serachPropertyService {
    FacadeBuscarPropiedadRemote facadeBuscarPropiedad = lookupFacadeBuscarPropiedadRemote();
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of serachPropertyService
     */
    public serachPropertyService() {
    }

    /**
     * Retrieves representation of an instance of co.edu.javeriana.services.serachPropertyService
     * @return an instance of co.edu.javeriana.dtos.PropertyQueryDTO
     */
    @GET
    @Produces("application/json")
    public PropertyQueryDTO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @POST
    @Consumes("application/json")
    public Response searchProperties(PropertyQueryDTO search) {
        Gson gson = new Gson();
        List<PropertyDTO> res =  this.facadeBuscarPropiedad.searchProperty(search);
        String json = gson.toJson(res);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
    
    /**
     * PUT method for updating or creating an instance of serachPropertyService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(PropertyQueryDTO content) {
    }

    private FacadeBuscarPropiedadRemote lookupFacadeBuscarPropiedadRemote() {
        try {
            javax.naming.Context c = new InitialContext();
            return (FacadeBuscarPropiedadRemote) c.lookup("java:global/LogicaDeNegocioOPRS/FacadeBuscarPropiedad!co.edu.javeriana.facades.FacadeBuscarPropiedadRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
