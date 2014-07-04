
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public VotarImp() throws java.rmi.RemoteException {
        super();
    }

    @Override
    public void emitirVoto(String v,String ci) {
        int id_opc = -1;
        ResultSet rs = Main.con.consultar(SQL.buscarOpcion(v));
        try {
            while(rs.next()){
                id_opc = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VotarImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.con.ejecutar(SQL.updateVotos(id_opc));
        Main.con.ejecutar(SQL.registrarVoto(ci));
        Main.interfazVotos.actualizarTablas();
    }

    @Override
    public int loguea(String ci, String pass) throws RemoteException {
        int activo = -1;
        ResultSet rs = Main.con.consultar(SQL.habilitado(ci, pass));
        try {
            while (rs.next()) {
                activo = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VotarImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(activo==1){
            rs = Main.con.consultar(SQL.verificarSiVoto(ci));
            try {
                while(rs.next()){
                    activo = 2;
                }
            } catch (SQLException ex) {
                Logger.getLogger(VotarImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return activo;
    }

    @Override
    public ArrayList<String> listarOpciones() {
        ArrayList<String> opciones = new ArrayList();
        ResultSet rs = Main.con.consultar(SQL.listarOpciones());
        try {
            while (rs.next()) {
                opciones.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VotarImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return opciones;
    }


}
