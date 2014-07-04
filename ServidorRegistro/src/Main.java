/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo Vargas M
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfazSR interfaz = InterfazSR.getInstance();
    }
    public static Conexion con = new Conexion("root", "", "localhost", "sistemasdistribuidos");
    public static InterfazSR interfaz;
}
