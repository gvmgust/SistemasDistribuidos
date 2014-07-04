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
                + Tools.sha1(pass) + "'); ";
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

    public static String seleccionarOpciones() {
        return "SELECT * FROM opciones";
    }

    public static String maximoIdSelec() {
        return "SELECT MAX(id_elec)+1 id_elec FROM eleccion";
    }

    public static String registrarEleccion(int id_elec, String pregunta, String inic_inscrip, String fin_inscrip, String inicio, String fin) {
        return "INSERT INTO eleccion(id_elec,pregunta,inic_inscrip,fin_inscrip,inicio,fin)VALUES('"
                + id_elec + "','"
                + pregunta + "','"
                + inic_inscrip + "','"
                + fin_inscrip + "','"
                + inicio + "','"
                + fin + "');";
    }

    public static String depurarVotantes(int id_elec) {
        return "UPDATE `persona` LEFT JOIN votacion\n"
                + "ON votacion.`ci` = persona.`ci` \n"
                + "SET persona.`habilitado`='0'\n"
                + "WHERE votacion.`id_ele` = "+id_elec;
    }

    public static String idOpciones(String cad){
        return "SELECT id_opc FROM opciones WHERE opciones IN("+cad+")";
    }
    
    public static String insertarPostulantes(int id_ele,int id_opc){
        return "INSERT INTO `postulantes` (id_ele, id_opc, votos)VALUES('"+id_ele+"','"+id_opc+"','0');";
    }
    
}
