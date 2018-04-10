/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import control.Conexion;
import dao.TestDao;
import java.sql.Connection;
import java.util.List;
import modelo.Test;

/**
 *
 * @author WAlvarezV
 */
public class GestionTest {

    Conexion conexion;
    Connection conn;

    public GestionTest() {
        conexion = new Conexion();
    }

    // <editor-fold defaultstate="collapsed" desc="Métodos Gestión Test">
    public Test crearTest(Test obj) {
        try {
            conn = conexion.conectar();
            TestDao objDao = new TestDao();
            objDao.create(conn, obj);
            return (Test) objDao.searchMatching(conn, obj).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return null;
    }

    public String editarTest(Test obj) {
        String msj = "OK";
        try {
            conn = conexion.conectar();
            TestDao objDao = new TestDao();
            objDao.save(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
            msj = "ERROR editarTest: " + e.getMessage();
        } finally {
            conexion.cerrarConexion();
        }
        return msj;
    }

    public Test buscarTest(Test obj) {
        try {
            conn = conexion.conectar();
            TestDao objDao = new TestDao();
            return (Test) objDao.searchMatching(conn, obj).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return null;
    }

    public boolean eliminarTest(Test obj) {
        try {
            conn = conexion.conectar();
            TestDao objDao = new TestDao();
            objDao.delete(conn, obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public List listarTest() {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            TestDao objDao = new TestDao();
            mylista = objDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return mylista;
    }
    // </editor-fold>

}
