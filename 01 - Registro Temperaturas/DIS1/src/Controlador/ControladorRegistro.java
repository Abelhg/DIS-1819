/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Temperatura;
import Modelo.Unidad;
import Persistencia.RegistroBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class ControladorRegistro {

    public void setValorIntroducido(float temp, Unidad unidad) {

        Connection con = null;
        Temperatura t = new Temperatura(temp, unidad);

        if (t.comprobarValorCorrecto()) {

            if (con == null) {
                try {
                    con = DriverManager.getConnection("jdbc:odbc:miBD", "dis1819", "dis1819");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }else{
            Exception e = new Exception("valor incorrecto");
        }
    }
}
