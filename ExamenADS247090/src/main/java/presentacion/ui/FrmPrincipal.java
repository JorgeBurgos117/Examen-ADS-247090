
package presentacion.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import presentacion.styles.RoundButton;

public class FrmPrincipal extends JFrame{
    
    JLabel lblTitulo = new JLabel("BBVA");
    
    JPanel contenido;
        
    
    public FrmPrincipal() {
        
        //Establecimiento del frame
        setLayout(new BoxLayout(this, 1));
        add(lblTitulo);
        
        contenido = new PnlMenu(this);
        add(contenido);
        
    }
    
    public void retirarEfectivo() {
        System.out.println("Desplegando menú de retiro de efectivo");
        contenido = new PnlRetirarEfectivo(this);
    }
    
}
