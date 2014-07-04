
import java.rmi.RemoteException;
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
public class VotarImp extends UnicastRemoteObject implements Votar {

    public VotarImp()throws java.rmi.RemoteException{
        super();
    }
    
    @Override
    public void emitirVoto(String s) {
        
    }
    
}
