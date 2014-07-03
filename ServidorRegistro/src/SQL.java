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

    public static String registrarPersona(String ci, String nombre, String apellidop, String apellidom, String direccion, int habilitado) {
        return "INSERT INTO `persona`(`ci`,`nombre`,`apellido_paterno`,`apellido_materno`,`Direccion`,`habilitado`) VALUES ( '"
                + ci + "','"
                + nombre + "','"
                + apellidop + "','"
                + apellidom + "','"
                + direccion + "','1'); ";
    }
}
