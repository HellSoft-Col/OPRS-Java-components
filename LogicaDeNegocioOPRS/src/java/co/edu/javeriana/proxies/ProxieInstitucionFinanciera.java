/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.proxies;

import co.edu.javeriana.dtos.PaymentDTO;
import co.edu.javeriana.dtos.PaymentResponseDTO;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

/**
 *
 * @author SANTI
 */
@Stateless
public class ProxieInstitucionFinanciera implements ProxieInstitucionFinancieraLocal {

    @Override
    public PaymentResponseDTO solicitarConfirmacionPago(PaymentDTO params) {
        PaymentResponseDTO result = new PaymentResponseDTO();
        
        Gson gson = new Gson();
        String parameters = gson.toJson(params);
        ProxieClientInstitucionFinanciera client = new ProxieClientInstitucionFinanciera();
        Response result_request = client.InfoPago(parameters);
       
        String result_string = new String();
        //result_string = result_request.readEntity(String.class);        
        result = gson.fromJson(result_string, PaymentResponseDTO.class);
        
        return result;
    }

}
