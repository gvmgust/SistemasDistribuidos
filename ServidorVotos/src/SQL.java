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

    public static String buscarOpcion(String opcion) {
        return "SELECT id_opc FROM opciones WHERE opciones = '" + opcion + "'";
    }

    public static String updateVotos(int id_opc) {
        return "UPDATE postulantes SET votos=votos+1 WHERE id_opc = '" + id_opc + "' AND id_ele = '" + Main.Eleccion + "'";
    }

    public static String registrarVoto(String CI) {
        return "INSERT INTO votacion(id_ele,ci)VALUES('" + Main.Eleccion + "','" + CI + "');";
    }

    public static String verificarSiVoto(String ci) {
        return "SELECT COUNT(id_ele) FROM votacion WHERE ci = '" + ci + "' AND id_ele = '" + Main.Eleccion + "';";
    }

    public static String contarVotos() {
        return "SELECT opciones.`Opciones`, postulantes.`votos` \n"
                + "FROM opciones INNER JOIN postulantes\n"
                + "ON opciones.id_opc = postulantes.`id_opc`\n"
                + "WHERE id_ele = '" + Main.Eleccion + "'";
    }
}
