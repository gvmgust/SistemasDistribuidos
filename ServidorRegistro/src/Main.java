
import com.birosoft.liquid.LiquidLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

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
        style();
        interfaz = InterfazSR.getInstance();
    }
    
    public static void style() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            LiquidLookAndFeel.setLiquidDecorations(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public static Conexion con = new Conexion("root", "", "localhost", "sistemasdistribuidos");
    public static InterfazSR interfaz;
}
