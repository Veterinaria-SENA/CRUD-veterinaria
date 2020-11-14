
package veterinaria;
import modelo.*;
import vista.*;
import controlador.*;
import modelo.MascotaDAO;

public class veterinaria {
    
    public static void main(String [] args){
        JFMascota vistaC= new JFMascota();
        MascotaDAO modeloC = new MascotaDAO();
        ControladorCrud controlaC= new ControladorCrud(vistaC, modeloC);
        
        vistaC.setVisible(true);
        vistaC.setLocationRelativeTo(null);
    }
}
