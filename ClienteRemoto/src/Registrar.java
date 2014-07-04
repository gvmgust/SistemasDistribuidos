
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Gustavo Vargas M
 */
public interface Registrar extends Remote {
    void registrarPersona(String ci, String nombre, String apellidop, String apellidom,String direccion, String pass)throws RemoteException;
}
