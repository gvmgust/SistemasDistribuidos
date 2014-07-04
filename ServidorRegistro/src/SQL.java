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

    public static String registrarPersona(String ci, String nombre, String apellidop, String apellidom, String direccion, String pass) {
        return "INSERT INTO `persona`(`ci`,`nombre`,`apellido_paterno`,`apellido_materno`,`Direccion`,`habilitado`) VALUES ( '"
                + ci + "','"
                + nombre + "','"
                + apellidop + "','"
                + apellidom + "','"
                + direccion + "','"
                + Tools.sha1(pass)+"'); ";
    }

    public static String mostrarUltimosNHabilitados(int limite) {
        return "SELECT * FROM persona WHERE habilitado = 1 ORDER BY fecha_inscripcion DESC LIMIT 0," + limite + ";";
    }

    public static String seleccionarMaximoId_opc() {
        return "SELECT MAX(id_opc)+1 FROM opciones";
    }

    public static String insertarOpcion(int id_opc, String opcion) {
        return "Insert into opciones(id_opc,opciones)values('" + id_opc + "','" + opcion + "');";
    }
}
