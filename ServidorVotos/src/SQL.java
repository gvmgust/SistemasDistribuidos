/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo Vargas M
 */
public abstract class SQL {

    public static String habilitado(String ci, String pass) {
        return "SELECT habilitado FROM persona WHERE ci = '" + ci + "' AND pass = '" + Tools.sha1(pass) + "'";
    }

    public static String listarOpciones() {
        return "SELECT opciones FROM opciones INNER JOIN postulantes\n"
                + "ON opciones.`id_opc` = postulantes.`id_opc`\n"
                + "WHERE id_ele = '" + Main.Eleccion + "'";
    }

}
