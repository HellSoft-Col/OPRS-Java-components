/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxies;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:LeaseByUserService
 * [LeaseByUser]<br>
 * USAGE:
 * <pre>
        ProxyBuscarContratosUsuario client = new ProxyBuscarContratosUsuario();
        Object response = client.XXX(...);
        // do whatever with response
        client.close();
 </pre>
 *
 * @author SANTI
 */
public class ProxyBuscarContratosUsuario {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ServiciosRESTOPRS/webresources";

    public ProxyBuscarContratosUsuario() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("LeaseByUser");
    }

    public <T> T getUnsignedLeasesCustomer(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
