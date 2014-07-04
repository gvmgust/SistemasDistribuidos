
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo Vargas M
 */
public class RegistrarImpl 
    extends UnicastRemoteObject implements Registrar {

    public RegistrarImpl() throws java.rmi.RemoteException{
        super();
    }

    @Override
    public void registrarPersona(String ci, String nombre, String apellidop, String apellidom, String direccion, int habilitado) {     
        Main.con.ejecutar(SQL.registrarPersona(ci, nombre, apellidop, apellidom, direccion, habilitado));
        Main.interfaz.actualizarVistaTablas();
    }

}
