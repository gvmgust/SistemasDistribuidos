
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo Vargas M
 */
public interface Votar  extends Remote {
    public void emitirVoto(String v,String ci)throws RemoteException;
    public int loguea(String ci, String pass)throws RemoteException;
    public ArrayList<String> listarOpciones();
}
