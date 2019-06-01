/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.services;

import co.edu.javeriana.dtos.LoginDTO;
import co.edu.javeriana.facades.FacadeLoginRemote;
import com.google.gson.Gson;
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
@Path("login")
public class LoginService {
    FacadeLoginRemote facadeLogin = lookupFacadeLoginRemote();
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginService
     */
    public LoginService() {
    }

    /**
     * Retrieves representation of an instance of co.edu.javeriana.services.LoginService
     * @return an instance of co.edu.javeriana.dtos.LoginDTO
     */
    @GET
    @Produces("application/json")
    public LoginDTO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @POST
    @Consumes("application/json")
    public Response logIn(LoginDTO login) {
        Gson gson = new Gson();
        LoginDTO loginDto = this.facadeLogin.iniciarSesion(login);
        String json = gson.toJson(loginDto);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    /**
     * PUT method for updating or creating an instance of LoginService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(LoginDTO content) {
    }

    private FacadeLoginRemote lookupFacadeLoginRemote() {
        try {
            javax.naming.Context c = new InitialContext();
            return (FacadeLoginRemote) c.lookup("java:global/LogicaDeNegocioOPRS/FacadeLogin!co.edu.javeriana.facades.FacadeLoginRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

 
}
