
package src.main.java.com.mycompany.examenads247090;


import src.main.java.controlador.RetiroController;
import src.main.java.modelo.Cliente;
import src.main.java.vista.ui.FrmPrincipal;

public class ExamenADS247090 {

    public static void main(String[] args) {

        Cliente clientePrueba = new Cliente("Jorge Burgos", generarNumero(), 20000);
        //RetiroController controller = new RetiroController(clientePrueba, panel);
        FrmPrincipal frmPrincipal = new FrmPrincipal(clientePrueba);
        
    }

    //para generar la cuenta
    public static String generarNumero() {
        java.util.Random random = new java.util.Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 16; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
