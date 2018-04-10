/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import gestion.GestionTest;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Test;


/**
 *
 * @author Unicomfacauca
 */
@WebService(serviceName = "PWN_ws")
public class PWN_ws {

    GestionTest gestionTest;
    
    public PWN_ws() {
        gestionTest = new GestionTest();        
    }
    
    
    
    

// <editor-fold defaultstate="collapsed" desc="Métodos Servicio Test">
    @WebMethod(operationName = "crearTest")
    public Test crearTest(@WebParam(name = "Test") Test obj) {
        return gestionTest.crearTest(obj);
    }

    @WebMethod(operationName = "editarTest")
    public String editarTest(@WebParam(name = "Test") Test obj) {
        return gestionTest.editarTest(obj);
    }

    @WebMethod(operationName = "buscarTest")
    public Test buscarTest(@WebParam(name = "Test") Test obj) {
        return gestionTest.buscarTest(obj);
    }

    @WebMethod(operationName = "eliminarTest")
    public boolean eliminarTest(@WebParam(name = "Test") Test obj) {
        return gestionTest.eliminarTest(obj);
    }

    @WebMethod(operationName = "listarTest")
    public List listarTest() {
        return gestionTest.listarTest();
    }
    // </editor-fold>
}
